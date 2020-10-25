package playground.swine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/*
 *	https://docs.microsoft.com/en-us/windows/desktop/direct3d10/d3d10-graphics-programming-guide-resources-block-compression
 */
public class DXTDecompress {

	public static void main(String[] args) throws IOException {
		Path root = new File("D:/Temp/190609_swine/remaster").toPath();

		// Find and convert all DXT files in the root folder
		Files.walk(root).forEach(path -> {
			File file = path.toFile();

			if (file.isDirectory() || !file.getName().endsWith(".dxt"))
				return;

			System.out.println(file);

			try {
				FileChannel input = new FileInputStream(file).getChannel();

				// Read file header
				ByteBuffer header = ByteBuffer.allocate(20);

				input.read(header);
				header.flip();

				// Verify stormregion signature
				int major = header.getInt();
				int minor = header.getInt();
				int type  = header.getInt();

				assert major == 0x53721A1B;
				assert minor == 0x0D0A870A;
				assert type  == 0x54455854;

				// Load texture data to memory
				header.order(ByteOrder.LITTLE_ENDIAN);

				int content = header.getInt();
				int unkn0   = header.getInt();

				ByteBuffer buffer = ByteBuffer.allocate(content).order(ByteOrder.LITTLE_ENDIAN);

				input.read(buffer);
				buffer.flip();

				int sizeX  = buffer.getInt();
				int sizeY  = buffer.getInt();
				int format = buffer.getInt();

				// Decode first mipmap level
				File into = new File(file.getParent(), file.getName().replace(".dxt", ".png"));

				ImageIO.write(decodeDXT(buffer, format, sizeX, sizeY), "PNG", into);

				// Done!
			} catch (IOException err) {
				throw new RuntimeException("Failed to decode file " + path, err);
			}
		});
	}

	public static final int DXT1 = 0x31545844;
	public static final int DXT5 = 0x35545844;

	static int unpack565(int color) {
		int R = (color >> 11) & 0x1F;
		int G = (color >> 5 ) & 0x3F;
		int B = (color >> 0 ) & 0x1F;

		// Upscale to 8 bit
		R = (R << 3) | (R >> 2);
		G = (G << 2) | (G >> 4);
		B = (B << 3) | (B >> 2);

		return (R << 16) | (G << 8) | B;
	}

	static int interpolate(int color0, int m0, int color1, int m1) {
		int total = m0 + m1;

		int A = ((color0 >> 24) & 0xFF) * m0 + ((color1 >> 24) & 0xFF) * m1;
		int R = ((color0 >> 16) & 0xFF) * m0 + ((color1 >> 16) & 0xFF) * m1;
		int G = ((color0 >> 8)  & 0xFF) * m0 + ((color1 >> 8)  & 0xFF) * m1;
		int B = ((color0 >> 0)  & 0xFF) * m0 + ((color1 >> 0)  & 0xFF) * m1;

		return (A / total) << 24 | (R / total) << 16 | (G / total) << 8 | (B / total);
	}

	// TODO: This makes it a tiny bit more efficient, but NOT thread safe/reentrant
	final static int[] alpha = new int[8];
	final static int[] color = new int[4];

	final static int[] texel = new int[16];

	static void decodeAlpha(ByteBuffer buffer, int[] argb) {

		// Build alpha palette
		alpha[0] = Byte.toUnsignedInt(buffer.get());
		alpha[1] = Byte.toUnsignedInt(buffer.get());

		// Interpolate alpha range
		if (alpha[0] > alpha[1]) {
			for (int idx = 2; idx < 8; idx++) {
				alpha[idx] = (alpha[0] * (8 - idx) + alpha[1] * (idx -1)) / 7;
			}
		} else {
			for (int i = 2; i < 6; i++) {
				alpha[i] = (alpha[0] *  + alpha[1] * (i -1)) / 5;
			}

			alpha[6] = 0;
			alpha[7] = 255;
		}

		// Unpack pixel alpha from indices
		for (int off = 0; off < 4*4; off += 8) {
			long packed = buffer.get() | (buffer.get() << 8) | (buffer.get() << 16);

			for (int pixel = 0; pixel < 8; pixel++) {
				int select = (int) (packed >> 3 * pixel) & 7;

				argb[off + pixel] = alpha[select] << 24;
			}
		}
	}

	static void decodeDiffuse(ByteBuffer colors, ByteBuffer indices, int[] argb, int alpha) {
		color[0] = (alpha << 24) | unpack565(colors.getShort());
		color[1] = (alpha << 24) | unpack565(colors.getShort());

		if (color[0] > color[1]) {
			color[2] = interpolate(color[0], 2, color[1], 1);
			color[3] = interpolate(color[0], 1, color[1], 2);
		} else {
			color[2] = interpolate(color[0], 1, color[1], 1);
			color[3] = 0x0;
		}

		// color[2] = interpolate(color[0], 1, color[1], 2);
		// color[3] = interpolate(color[0], 2, color[1], 1);

		for (int off = 0; off < 4*4; off += 4) {
			int packed = indices.get();

			argb[off + 0] |= color[(packed >> 0) & 3];
			argb[off + 1] |= color[(packed >> 2) & 3];
			argb[off + 2] |= color[(packed >> 4) & 3];
			argb[off + 3] |= color[(packed >> 6) & 3];
		}
	}

	private static void validateImage(int sizeX, int sizeY, int format) {
		if (sizeX % 4 != 0)
			throw new IllegalArgumentException("sizeX");

		if (sizeY % 4 != 0)
			throw new IllegalArgumentException("sizeY");

		switch (format) {
			case DXT1:
			case DXT5:
				break;

			default:
				throw new IllegalArgumentException("Unsupported image format " + Integer.toHexString(format));
		}
	}

	public static BufferedImage decodeDXT(ByteBuffer buffer, int format, int sizeX, int sizeY) {
		validateImage(sizeX, sizeY, format);

		BufferedImage image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);

		// All reads expect little endian order
		buffer.order(ByteOrder.LITTLE_ENDIAN);

		for (int y = 0; y < sizeY; y += 4) {
			for (int x = 0; x < sizeX; x += 4) {
				Arrays.fill(texel, 0);

				if (format == DXT5) {
					decodeAlpha(buffer, texel);
					decodeDiffuse(buffer, buffer, texel, 0);
				} else {
					decodeDiffuse(buffer, buffer, texel, 255);
				}

				image.setRGB(x, y, 4, 4, texel, 0, 4);
			}
		}

		return image;
	}

	public static BufferedImage decodeBifurcatedDXT1(ByteBuffer buffer, int sizeX, int sizeY) {
		validateImage(sizeX, sizeY, DXT1);

		BufferedImage image = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);

		// This DXT buffer is bifurcated, color first, indices next
		int dataSize = (sizeX /4) * (sizeY /4) * 8;

		ByteBuffer color   = buffer.slice().order(ByteOrder.LITTLE_ENDIAN);
		ByteBuffer indices = buffer.slice().order(ByteOrder.LITTLE_ENDIAN);

		indices.position(dataSize /2);

		for (int y = 0; y < sizeY; y += 4) {
			for (int x = 0; x < sizeX; x += 4) {
				Arrays.fill(texel, 0xFF000000);

				decodeDiffuse(color, indices, texel, 255);

				image.setRGB(x, y, 4, 4, texel, 0, 4);
			}
		}

		// Simulate progress on the buffer
		buffer.position(buffer.position() + dataSize);

		return image;
	}

}

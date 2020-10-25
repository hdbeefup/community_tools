package playground.swine;

import io.airlift.compress.zstd.ZstdDecompressor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class ANIXDecompress {

	public static void main(String[] args) throws IOException {
		File anim   = new File("D:/Temp/190609_swine/remaster/videos/p_intro.anif");
		File folder = new File("D:/Temp/190609_swine/anim");

		FileChannel input = new FileInputStream(anim).getChannel();

		ByteBuffer header = ByteBuffer.allocate(28).order(ByteOrder.LITTLE_ENDIAN);

		input.read(header);
		header.flip();

		header.position(8); // Skip stormregion headers

		int format = header.getInt();
		int size   = header.getInt();

		int W = header.getInt();
		int H = header.getInt();
		int frames = header.getInt();

		// DXT encoding required W and H to be divisible by 4, thus the 'real'
		//  buffer is slightly bigger than the actual image size
		int sizeX = W;
		int sizeY = H;

		int frameBufferSize = sizeX * sizeY * 8;

		// Weird way of calculating frame buffer size, directly from disassembly
		long esi = (W + ((W +3) & 3)) >> 2;
		long eax = (H + ((H +3) & 3)) >> 2;

		frameBufferSize = (int) ((esi * eax) * frames) << 3;

		ByteBuffer before = ByteBuffer.allocateDirect(size - 12);
		ByteBuffer after  = ByteBuffer.allocateDirect(frameBufferSize);

		input.read(before);
		before.flip();

		ZstdDecompressor decomp = new ZstdDecompressor();
			decomp.decompress(before, after);

		after.flip();

		for (int i = 0; i < frames; i++) {
			BufferedImage frame = DXTDecompress.decodeBifurcatedDXT1(after, W, H);

			ImageIO.write(frame, "PNG", new File(folder, i + ".png"));
		}

		System.out.println(after);
	}

}

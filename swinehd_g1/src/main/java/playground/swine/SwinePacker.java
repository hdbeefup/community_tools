package playground.swine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Consumer;

public class SwinePacker {
	private static final Charset FNAME_CHARSET = StandardCharsets.ISO_8859_1;

	private static int compareByEncodedName(PakEntry A, PakEntry B) {
		ByteBuffer aName = A.nameEncoded;
		ByteBuffer bName = B.nameEncoded;

		int len = Math.min(aName.capacity(), bName.capacity());

		// Special care to compare bytes in an unsigned fashion, just like how strcmp does in C++
		for (int i = 0; i < len; i++) {
			int aChar = Byte.toUnsignedInt( aName.get(i) );
			int bChar = Byte.toUnsignedInt( bName.get(i) );

			if (aChar != bChar) {
				return aChar - bChar;
			}
		}

		// Longer buffer loses
		return aName.capacity() - bName.capacity();
	}

	public static class PakEntry {
		String     name;
		ByteBuffer nameEncoded;

		Path path;

		long offset;
		long size;

		private PakEntry(Path root, Path file) throws IOException {
			this.path = file;
			this.name = root.relativize(file).toString().replace('\\', '/');

			// Encode filename, so we can sort by them
			this.nameEncoded = FNAME_CHARSET.encode(name);

			if (Files.isDirectory(file)) {
				this.name += '/';
			} else {
				this.size = Files.size(file);
			}
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static void main(String[] args) throws Exception {
		Path root = new File("D:/Temp/190609_swine/remaster").toPath();
		File pak  = new File("D:/SteamLibrary/steamapps/common/SWINE HD Remaster/gamedata/base/base.pak");

		RedBlackTree<PakEntry> pakLookupTree = new RedBlackTree<>(SwinePacker::compareByEncodedName);

		// Discover files, build search tree
		Files.walkFileTree(root, new SimpleFileVisitor<Path>() {

			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				if (!dir.equals(root)) {
					pakLookupTree.insert(new PakEntry(root, dir));
				}

				return FileVisitResult.CONTINUE;
			}

			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				pakLookupTree.insert(new PakEntry(root, file));

				return FileVisitResult.CONTINUE;
			}
		});

		// In-order traversal, compute content offset
		pakLookupTree.traverseValues(new Consumer<PakEntry>() {
			long offset = 0;

			public void accept(PakEntry pakEntry) {
				System.out.println(pakEntry.name);

				pakEntry.offset = offset;

				offset += pakEntry.size;
			}
		}, RedBlackTree.Traversal.IN_ORDER);

		// Prepare IO resources
		FileChannel output = new FileOutputStream(pak).getChannel();
		ByteBuffer  buffer = ByteBuffer.allocate(512);

		// Write header + magic, prepare header size field
		buffer.order(ByteOrder.BIG_ENDIAN)
			.putInt(0x53721A1B)		// 53 72 1A 1B - Stormregion file
			.putInt(0x0D0A870A)		// 0D 0A 87 0A - Stormregion archive
			.putInt(0x5041434B);	// 'PACK'

		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.putInt(0x0);

		long indexOffset   = buffer.position();
		long contentOffset = 0;

		buffer.flip();
		output.write(buffer);

		// Serialize lookup tree
		writeTreeBranch(output, buffer, pakLookupTree.root(), indexOffset);

		// Populate index end position
		contentOffset = output.position() - indexOffset;

		buffer.clear();
		buffer.putInt((int) contentOffset);
		buffer.flip();

		output.write(buffer, indexOffset - Integer.BYTES);

		// Populate final pak with file data
		pakLookupTree.traverseValues(pakEntry -> {

			// Skip directories/empty files
			if (pakEntry.size == 0)
				return;

			try {
				FileChannel input = new FileInputStream(pakEntry.path.toFile()).getChannel();

				input.transferTo(0, input.size(), output);
				input.close();
			} catch (IOException err) {
				throw new RuntimeException("IOError while packing " + pakEntry.path, err);
			}

		}, RedBlackTree.Traversal.IN_ORDER);

		// Complete
		output.close();
	}

	private static void writeTreeBranch(FileChannel out, ByteBuffer buffer, RedBlackTree<PakEntry>.Node node, long indexOffset) throws IOException {
		if (node == null)
			return;

		PakEntry entry = node.value();

		buffer.clear();

		// Determine prefix length to use
		// TODO: It seems that the game actually accepts archives without this optimization as well
		int usePrefix = 0;

		buffer.put((byte) usePrefix);
		buffer.put((byte) (entry.nameEncoded.capacity() - usePrefix));

		entry.nameEncoded.position(usePrefix);
		buffer.put(entry.nameEncoded);

		buffer.putInt((int) entry.offset);
		buffer.putInt((int) entry.size);

		boolean hasLeft  = node.left()  != null;
		boolean hasRight = node.right() != null;

		buffer.put((byte) (hasLeft ? 1 : 0));
		buffer.putInt(0x0);

		buffer.flip();
		out.write(buffer);

		long rightNodeLoc = out.position() - Integer.BYTES;

		if (hasLeft) {
			// Write left side of search tree
			writeTreeBranch(out, buffer, node.left(), indexOffset);
		}
		if (hasRight) {
			// Record right side offset from indexOffset
			buffer.clear();
			buffer.putInt((int) (out.position() - indexOffset));
			buffer.flip();

			out.write(buffer, rightNodeLoc);

			// Write right side of search tree
			writeTreeBranch(out, buffer, node.right(), indexOffset);
		}
	}

}

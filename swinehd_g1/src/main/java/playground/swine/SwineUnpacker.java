package playground.swine;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SwineUnpacker {
	private static Charset charset = StandardCharsets.ISO_8859_1;
	private static ByteBuffer buffer = ByteBuffer.allocate(512).order(ByteOrder.LITTLE_ENDIAN);

	private static class FileEntry {
		String name;

		int offset;
		int size;

		FileEntry(String name, int offset, int size) {
			this.name = name;

			this.offset = offset;
			this.size   = size;
		}

		@Override
		public String toString() {
			return String.format("[FileEntry; offset=%08X, size=%08X, name=%s]", offset, size, name);
		}
	}

	private static ArrayList<FileEntry> files = new ArrayList<>();

	private static int indexOffset;
	private static int contentOffset;

	static String indent = "";

	private static int compareArrays(byte[] haystack, int off, byte[] needle) {
		int i = 0;

		while (true) {
			if (haystack.length <= i + off || needle.length <= i) {
				return (haystack.length - off) - needle.length;
			}

			int diff = Byte.toUnsignedInt(haystack[i + off]) - Byte.toUnsignedInt(needle[i]);

			if (diff != 0) {
				return diff;
			}

			i++;
		}
	}

	private static void findHeapEntry(FileChannel input, byte[] target, int pos) throws Exception {
		buffer.clear();

		input.read(buffer, pos);
		buffer.flip();

		int checkFrom = buffer.get();
		int checkLen  = buffer.get();

		byte[] fragment = new byte[checkLen];
		buffer.get(fragment);

		int offset   = buffer.getInt();
		int size     = buffer.getInt();

		int hasLeft = buffer.get();
		int next    = buffer.getInt();

		// Traverse
		int diff = compareArrays(target, checkFrom, fragment);

		if (diff < 0) {
			if (hasLeft == 0) {
				throw new RuntimeException("Not found");
			} else {
				findHeapEntry(input, target, pos + 2 + checkLen + 13);
			}
		} else if (diff == 0) {
			// System.out.println("File found");
		} else {
			if (next == 0) {
				throw new RuntimeException("Not found");
			} else {
				findHeapEntry(input, target, indexOffset + next);
			}
		}
	}

	private static void readHeapEntry(FileChannel input, String path, int pos) throws Exception {
		buffer.clear();

		input.read(buffer, pos);
		buffer.flip();

		// Parse record
		int nameReuse = buffer.get();
		int nameLen   = buffer.get();

		byte[] fragmentBytes = new byte[nameLen];
		buffer.get(fragmentBytes);

		String fragment = new String(fragmentBytes, charset);
		String filename = path.substring(0, nameReuse) + fragment;

		int offset   = buffer.getInt();
		int size     = buffer.getInt();

		int hasLeft = buffer.get();
		int next    = buffer.getInt();

		System.out.format("%s%s!%s\n", indent, path.substring(0, nameReuse), fragment);
		indent += "\t";

		if (hasLeft != 0) {
			readHeapEntry(input, filename, pos + 2 + nameLen + 13);
		}

		files.add(new FileEntry(filename, offset, size));

		if (next != 0) {
			readHeapEntry(input, filename, indexOffset + next);
		}

		indent = indent.substring(0, indent.length() -1);
	}


	public static void main(String[] args) throws Exception {
		File pak  = new File("D:/Temp/190609_swine/swine01.pak");
		File base = new File("D:/Temp/190609_swine/original");

		FileChannel input = new FileInputStream(pak).getChannel();

		input.read(buffer);
		buffer.flip();

		buffer.position(12); // Skip magic: 53 72 1A 1B | 0D 0A 87 0A | 'PACK'

		contentOffset = buffer.getInt() + buffer.position();
		indexOffset   = buffer.position();

		readHeapEntry(input,"", indexOffset);

		for (FileEntry entry : files) {
			try {
				findHeapEntry(input, entry.name.getBytes(charset), indexOffset);
			} catch (Exception err) {
				System.out.println(entry.name);
			}
		}

		for (FileEntry entry : files) {
			if (entry.size == 0)
				continue;

			System.out.println(entry.name);

			File outFile = new File(base, entry.name);
				outFile.getParentFile().mkdirs();

			FileChannel output = new FileOutputStream(outFile).getChannel();

			input.transferTo(contentOffset + entry.offset, entry.size, output);

			output.close();
		}
	}

}

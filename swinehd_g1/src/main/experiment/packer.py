import os
import struct

FNAME_CHARSET = "ISO-8859-1"


class PakEntry:
    def __init__(self, root, file):
        self.name = os.path.relpath(file, root).replace("\\", "/")
        self.name_encoded = self.name.encode(FNAME_CHARSET)

        if os.path.isdir(file):
            self.name += "/"
        else:
            self.size = os.path.getsize(file)


def compare_by_encoded_name(a, b):
    len_ = min(len(a.name_encoded), len(b.name_encoded))

    for i in range(len_):
        a_char = a.name_encoded[i]
        b_char = b.name_encoded[i]

        if a_char != b_char:
            return a_char - b_char

    return len(a.name_encoded) - len(b.name_encoded)


def discover_files(root):
    pak_lookup_tree = {}

    for root_, dirs, files in os.walk(root):
        for file in dirs + files:
            file_path = os.path.join(root_, file)
            pak_entry = PakEntry(root, file_path)
            pak_lookup_tree[pak_entry.name_encoded] = pak_entry

    return pak_lookup_tree


def compute_content_offsets(pak_lookup_tree):
    offset = 0

    for name, pak_entry in pak_lookup_tree.items():
        pak_entry.offset = offset
        offset += pak_entry.size


def write_pak_file(pak_path, pak_lookup_tree):
    # Open the output stream for the PAK file.
    with open(pak_path, "wb") as pak_file:
        # Write the header.
        pak_file.write(b"PACK")
        pak_file.write(struct.pack("<I", len(pak_lookup_tree)))

        # Write the directory.
        for name, pak_entry in pak_lookup_tree.items():
            pak_file.write(pak_entry.name_encoded)
            pak_file.write(b"\0")
            pak_file.write(struct.pack("<Q", pak_entry.offset))
            pak_file.write(struct.pack("<Q", pak_entry.size))

        # Write the content.
        for name, pak_entry in pak_lookup_tree.items():
            # Open the input stream for the file.
            with open(pak_entry.name, "rb") as file:
                # Read the file content and write it to the PAK file.
                pak_file.write(file.read())

def main(root, pak):
    # Discover the files in the directory tree.
    pak_lookup_tree = discover_files(root)

    # Compute the content offset for each PAK entry.
    compute_content_offsets(pak_lookup_tree)

    # Write the PAK file.
    write_pak_file(pak, pak_lookup_tree)


if __name__ == "__main__":
    import sys

    if len(sys.argv) < 3:
        print("Usage: SwinePacker <root> <pak>")
        sys.exit(1)

    main(sys.argv[1], sys.argv[2])

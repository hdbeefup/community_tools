import struct
from typing import List

charset = "iso-8859-1"
buffer = bytearray(512)

class FileEntry:
    def __init__(self, name: str, offset: int, size: int):
        self.name = name
        self.offset = offset
        self.size = size

    def __str__(self):
        return f"[FileEntry; offset=%08X, size=%08X, name=%s]" % (self.offset, self.size, self.name)

files: List[FileEntry] = []
index_offset: int
content_offset: int

indent = ""

def compare_arrays(haystack: bytes, off: int, needle: bytes) -> int:
    i = 0
    while True:
        if len(haystack) <= i + off or len(needle) <= i:
            return (len(haystack) - off) - len(needle)
        diff = haystack[i + off] - needle[i]
        if diff != 0:
            return diff
        i += 1

def find_heap_entry(input, target: bytes, pos: int):
    input.seek(pos)
    input.readinto(buffer)
    check_from, check_len = struct.unpack("<BB", buffer[:2])
    fragment = buffer[2:2+check_len]
    offset, size, has_left, next_ = struct.unpack("<IIIB", buffer[2+check_len:])
    diff = compare_arrays(target, check_from, fragment)
    if diff < 0:
        if has_left == 0:
            raise RuntimeError("Not found")
        else:
            find_heap_entry(input, target, pos + 2 + check_len + 13)
    elif diff == 0:
        pass
    else:
        if next_ == 0:
            raise RuntimeError("Not found")
        else:
            find_heap_entry(input, target, index_offset + next_)

def read_heap_entry(input, path: str, pos: int):
    input.seek(pos)
    input.readinto(buffer)
    name_reuse, name_len = struct.unpack("<BB", buffer[:2])
    fragment = buffer[2:2+name_len].decode(charset)
    filename = path[:name_reuse] + fragment
    offset, size, has_left, next_ = struct.unpack("<IIIB", buffer[2+name_len:])
    print(f"{indent}{filename}")
    files.append(FileEntry(filename, offset, size))
    if has_left != 0:
        read_heap_entry(input, filename, pos + 2 + name_len + 13)
    if next_ != 0:
            read_heap_entry(input, path, index_offset + next_)

def unpack(input, output_dir: str):
    global indent
    global index_offset
    global content_offset
    input.seek(4)
    index_offset, content_offset = struct.unpack("<II", input.read(8))
    input.seek(index_offset)
    read_heap_entry(input, "", index_offset)
    for file in files:
        input.seek(content_offset + file.offset)
        content = input.read(file.size)
        with open(output_dir + "/" + file.name, "wb") as f:
            f.write(content)

if __name__ == "__main__":
    with open("swine01.pak", "rb") as input:
        unpack(input, "output")


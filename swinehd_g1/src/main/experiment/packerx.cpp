#include <algorithm>
#include <cstring>
#include <fstream>
#include <iostream>
#include <numeric>
#include <optional>
#include <string>
#include <unordered_map>
#include <vector>

// The Charset class from Java does not exist in C++. Instead, you can use the
// std::string class for storing text data and specify the character encoding when
// reading or writing to a file. In this case, ISO-8859-1 can be used for storing
// filenames in the PAK file.
constexpr std::string_view FNAME_CHARSET = "ISO-8859-1";

struct PakEntry {
  std::string name;
  std::string nameEncoded;

  std::string path;

  std::uint64_t offset;
  std::uint64_t size;
};

// The RedBlackTree class is not part of the C++ standard library. You can use
// other data structures, such as std::set or std::map, to store the PAK entries.
// Here, I will use std::unordered_map, which provides fast lookup and insertion
// operations using a hash table.
using PakLookupTree = std::unordered_map<std::string, PakEntry>;

int compareByEncodedName(const PakEntry& a, const PakEntry& b) {
  // Compare the encoded filenames using the same approach as in the Java code.
  int len = std::min(a.nameEncoded.size(), b.nameEncoded.size());

  for (int i = 0; i < len; i++) {
    int aChar = static_cast<std::uint8_t>(a.nameEncoded[i]);
    int bChar = static_cast<std::uint8_t>(b.nameEncoded[i]);

    if (aChar != bChar) {
      return aChar - bChar;
    }
  }

  // Longer buffer loses
  return a.nameEncoded.size() - b.nameEncoded.size();
}

// The Files class from Java does not exist in C++. You can use the <filesystem>
// header to access the file system and perform operations such as walking through
// the directory tree or reading and writing files.
#include <filesystem>
namespace fs = std::filesystem;

PakLookupTree discoverFiles(const fs::path& root) {
  PakLookupTree pakLookupTree;

  // Walk through the directory tree and add the entries to the map.
  for (const auto& entry : fs::recursive_directory_iterator(root)) {
    if (entry.is_directory()) {
      PakEntry pakEntry;
      pakEntry.name = entry.path().string().substr(root.string().size() + 1);
      pakEntry.nameEncoded = pakEntry.name;
      pakEntry.path = pakEntry.name;

      // Add the '/' character to the end of the filename to indicate a directory.
      pakEntry.name += '/';
      pakLookupTree[pakEntry.nameEncoded] = std::move(
PakLookupTree discoverFiles(const fs::path& root) {
  PakLookupTree pakLookupTree;

  // Walk through the directory tree and add the entries to the map.
  for (const auto& entry : fs::recursive_directory_iterator(root)) {
    if (entry.is_directory()) {
      PakEntry pakEntry;
      pakEntry.name = entry.path().string().substr(root.string().size() + 1);
      pakEntry.nameEncoded = pakEntry.name;
      pakEntry.path = pakEntry.name;

      // Add the '/' character to the end of the filename to indicate a directory.
      pakEntry.name += '/';
      pakLookupTree[pakEntry.nameEncoded] = std::move(pakEntry);
    } else {
      PakEntry pakEntry;
      pakEntry.name = entry.path().string().substr(root.string().size() + 1);
      pakEntry.nameEncoded = pakEntry.name;
      pakEntry.path = pakEntry.name;
      pakEntry.size = fs::file_size(entry);
      pakLookupTree[pakEntry.nameEncoded] = std::move(pakEntry);
    }
  }

  return pakLookupTree;
}

// Compute the content offset for each PAK entry.
void computeContentOffsets(PakLookupTree& pakLookupTree) {
  std::uint64_t offset = 0;

  // Iterate through the map and update the offset for each entry.
  for (auto& [key, pakEntry] : pakLookupTree) {
    pakEntry.offset = offset;
    offset += pakEntry.size;
  }
}

void writePakFile(const fs::path& pakPath, const PakLookupTree& pakLookupTree) {
  // Open the output stream for the PAK file.
  std::ofstream pakFile(pakPath, std::ios::binary);

  // Write the header.
  pakFile << "PACK";
  pakFile << std::uint32_t{pakLookupTree.size()};

  // Write the directory.
  for (const auto& [key, pakEntry] : pakLookupTree) {
    pakFile.write(pakEntry.nameEncoded.data(), pakEntry.nameEncoded.size());
    pakFile << char{0};
    pakFile << std::uint64_t{pakEntry.offset};
    pakFile << std::uint64_t{pakEntry.size};
  }

  // Write the content.
  for (const auto& [key, pakEntry] : pakLookupTree) {
    // Open the input stream for the file.
    std::ifstream file(pakEntry.path, std::ios::binary);

    // Read the file content and write it to the PAK file.
    std::vector<char> buffer(pakEntry.size);
    file.read(buffer.data(), pakEntry.size);
    pakFile.write(buffer.data(), pakEntry.size);
 
int main(int argc, char* argv[]) {
  // Parse the command-line arguments.
  if (argc < 3) {
    std::cerr << "Usage: SwinePacker <root> <pak>" << std::endl;
    return 1;
  }

  fs::path root{argv[1]};
  fs::path pakPath{argv[2]};

  // Discover the files in the directory tree.
  PakLookupTree pakLookupTree = discoverFiles(root);

  // Compute the content offset for each PAK entry.
  computeContentOffsets(pakLookupTree);

  // Write the PAK file.
  writePakFile(pakPath, pakLookupTree);

  return 0;
}

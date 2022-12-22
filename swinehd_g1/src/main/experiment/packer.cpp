#include <algorithm>
#include <cstdint>
#include <cstring>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

// This class is used to represent a file or directory in the packed file.
class PakEntry {
 public:
  // Initializes the PakEntry object with the given file or directory path.
  explicit PakEntry(const std::string& path) : path_(path) {
    // Encode the filename so that it can be sorted by it.
    name_encoded_ = std::vector<uint8_t>(path.begin(), path.end());
    if (path[path.length() - 1] == '/') {
      // This is a directory, so append a '/' character to the name.
      name_ += '/';
    } else {
      // This is a file, so store its size.
      std::ifstream file(path, std::ios::binary | std::ios::ate);
      size_ = file.tellg();
      file.close();
    }
  }

  // Returns the path of the file or directory.
  const std::string& path() const { return path_; }

  // Returns the encoded name of the file or directory.
  const std::vector<uint8_t>& name_encoded() const { return name_encoded_; }

  // Returns the size of the file. If this PakEntry object represents a
  // directory, the returned value is 0.
  std::streampos size() const { return size_; }

  // Sets the offset at which the file or directory will be stored in the packed
  // file.
  void set_offset(std::streampos offset) { offset_ = offset; }

  // Returns the offset at which the file or directory is stored in the packed
  // file.
  std::streampos offset() const { return offset_; }

 private:
  std::string path_;
  std::vector<uint8_t> name_encoded_;
  std::string name_;
  std::streampos size_ = 0;
  std::streampos offset_ = 0;
};

// This class is used to represent a red-black tree of PakEntry objects.
class RedBlackTree {
 public:
  // Inserts the given PakEntry object into the tree.
  void insert(const PakEntry& entry) {
    // Insert the entry into the tree using a recursive function.
    insert(entry, &root_);
  }

  // Traverses the tree in-order and calls the given function for each
  // PakEntry object.
  void traverse_values(const std::function<void(const PakEntry&)>& fn) {

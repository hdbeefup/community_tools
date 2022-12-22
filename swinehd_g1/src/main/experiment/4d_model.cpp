#include <cstring>
#include <fstream>
#include <iostream>
#include <map>
#include <vector>

#include "mathutils/mathutils.h"

std::string read_kind(std::ifstream& file) {
  std::string res;
  res.resize(4);
  file.read(&res[0], 4);
  return res;
}

unsigned int read_uint(std::ifstream& file) {
  unsigned int res;
  file.read(reinterpret_cast<char*>(&res), 4);
  return res;
}

int read_sint(std::ifstream& file) {
  int res;
  file.read(reinterpret_cast<char*>(&res), 4);
  return res;
}

unsigned short read_ushort(std::ifstream& file) {
  unsigned short res;
  file.read(reinterpret_cast<char*>(&res), 2);
  return res;
}

float read_float(std::ifstream& file) {
  float res;
  file.read(reinterpret_cast<char*>(&res), 4);
  return res;
}

std::string read_string(std::ifstream& file) {
  std::string res;
  res.resize(read_ushort(file));
  file.read(&res[0], res.size());
  return res;
}

mathutils::Vector read_vec(std::ifstream& file, int components) {
  mathutils::Vector res;

  for (int i = 0; i < components; ++i) {
    res[i] = read_float(file);
  }

  return res;
}

class ParsingContext {
 public:
  ParsingContext() : scale_(0.005f), folder_(), objects_(), parents_() {}

  float scale() const { return scale_; }
  const std::string& folder() const { return folder_; }
  const std::vector<mathutils::Object*>& objects() const { return objects_; }
  const std::vector<int>& parents() const { return parents_; }
  mathutils::Object* object() const { return object_; }
  mathutils::Mesh* mesh() const { return mesh_; }

  void set_folder(const std::string& folder) { folder_ = folder; }
  void set_object(mathutils::Object* object) { object_ = object; }
  void set_mesh(mathutils::Mesh* mesh) { mesh_ = mesh; }

 private:
  float scale_;
  std::string folder_;
  std::vector<mathutils::Object*> objects_;
  std::vector<int> parents_;
  mathutils::Object* object_;
  mathutils::Mesh* mesh_;
};

void parse_material(std::ifstream& file,
                    int limit,
                    ParsingContext& ctx) {
  // TODO: These properties are actually unsupported, first DIFF applies to whole
  // object
  unsigned int num_faces = read_

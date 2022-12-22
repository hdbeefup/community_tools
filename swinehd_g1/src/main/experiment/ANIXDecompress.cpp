#include <iostream>
#include <fstream>
#include <cstring>
#include <algorithm>

#include "compress/zstd/zstd_decompressor.h"

#include "imageio.h"
#include "awt/image.h"

using namespace std;

int main(int argc, char* argv[]) {
  ifstream anim("D:/Temp/190609_swine/remaster/videos/p_intro.anif", ios::binary);
  string folder = "D:/Temp/190609_swine/anim";

  char header[28];
  anim.read(header, 28);

  // Skip stormregion headers
  int format = *(int*)(header + 8);
  int size = *(int*)(header + 12);

  int W = *(int*)(header + 16);
  int H = *(int*)(header + 20);
  int frames = *(int*)(header + 24);

  // DXT encoding required W and H to be divisible by 4, thus the 'real'
  //  buffer is slightly bigger than the actual image size
  int sizeX = W;
  int sizeY = H;

  int frameBufferSize = sizeX * sizeY * 8;

  // Weird way of calculating frame buffer size, directly from disassembly
  long esi = (W + ((W + 3) & 3)) >> 2;
  long eax = (H + ((H + 3) & 3)) >> 2;

  frameBufferSize = (esi * eax) * frames << 3;

  char* before = new char[size - 12];
  anim.read(before, size - 12);

  char* after = new char[frameBufferSize];

  ZstdDecompressor decomp;
  decomp.decompress(before, size - 12, after, frameBufferSize);

  for (int i = 0; i < frames; i++) {
    BufferedImage frame = DXTDecompress::decodeBifurcatedDXT1(after, W, H);
    ImageIO::write(frame, "PNG", folder + '/' + to_string(i) + ".png");
  }

  cout << after << endl;

  delete[] before;
  delete[] after;

  return 0;
}
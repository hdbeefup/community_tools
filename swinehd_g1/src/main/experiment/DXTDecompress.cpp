#include <fstream>
#include <iostream>
#include <vector>

constexpr int DXT1 = 0x31545844;
constexpr int DXT5 = 0x35545844;

int unpack565(int color) {
  int R = (color >> 11) & 0x1F;
  int G = (color >> 5) & 0x3F;
  int B = (color >> 0) & 0x1F;

  // Upscale to 8 bit
  R = (R << 3) | (R >> 2);
  G = (G << 2) | (G >> 4);
  B = (B << 3) | (B >> 2);

  return (R << 16) | (G << 8) | B;
}

int interpolate(int color0, int m0, int color1, int m1) {
  int total = m0 + m1;

  int A = ((color0 >> 24) & 0xFF) * m0 + ((color1 >> 24) & 0xFF) * m1;
  int R = ((color0 >> 16) & 0xFF) * m0 + ((color1 >> 16) & 0xFF) * m1;
  int G = ((color0 >> 8) & 0xFF) * m0 + ((color1 >> 8) & 0xFF) * m1;
  int B = ((color0 >> 0) & 0xFF) * m0 + ((color1 >> 0) & 0xFF) * m1;

  return (A / total << 24) | (R / total << 16) | (G / total << 8) | (B / total << 0);
}

int main(int argc, char** argv) {
  // Find and convert all DXT files in the root folder
  std::string root = "D:/Temp/190609_swine/remaster";
  std::vector<std::string> files = find_files_in_directory(root, ".dxt");
  for (const auto& file : files) {
    std::cout << file << std::endl;

    std::ifstream input(file, std::ios::binary);

    // Read file header
    std::vector<char> header(20);
    input.read(header.data(), header.size());

    // Verify stormregion signature
    int major = *reinterpret_cast<int*>(header.data());
    int minor = *reinterpret_cast<int*>(header.data() + 4);
    int type = *reinterpret_cast<int*>(header.data() + 8);

    assert(major == 0x53721A1B);
    assert(minor == 0x0D0A870A);
    assert(type == 0x54455854);

    // Load texture data to memory
    int content = *reinterpret_cast<int*>(header.data() + 12);
    int unkn0 = *reinterpret_cast<int*>(header.data() + 16);
    std::vector<char> buffer(content);
    input.read(buffer.data(), buffer.size());

    int sizeX = *reinterpret_cast<int*>(buffer.data());
    int sizeY = *reinterpret_cast<int*>(buffer.data() + 4);
    int format = *reinterpret_cast<int*>(buffer.data() + 8);

    // Decode first mipmap level
    std::string output_file = file.substr(0, file.size() - 4) + ".png";
    decodeDXT(buffer.data() + 12, format, sizeX, sizeY, output_file);

    // Done!
  }

  return 0;
}

void decodeDXT(const char* data, int format, int sizeX, int sizeY, const std::string& output_file) {
  if (format == DXT1) {
    // Create output image
    std::vector<int> pixels(sizeX * sizeY);

    int block_count_x = (sizeX + 3) / 4;
    int block_count_y = (sizeY + 3) / 4;

    // Decode blocks
    for (int y = 0; y < block_count_y; y++) {
      for (int x = 0; x < block_count_x; x++) {
        int block_index = y * block_count_x + x;
        int block_offset = block_index * 8;

        int color0 = *reinterpret_cast<const int*>(data + block_offset + 0);
        int color1 = *reinterpret_cast<const int*>(data + block_offset + 4);

        int codes = *reinterpret_cast<const int*>(data + block_offset + 8);

        int colors[4];
        colors[0] = unpack565(color0);
        colors[1] = unpack565(color1);

        if (color0 > color1) {
          colors[2] = interpolate(colors[0], 2, colors[1], 1);
          colors[3] = interpolate(colors[0], 1, colors[1], 2);
        } else {
          colors[2] = interpolate(colors[0], 1, colors[1], 1);
          colors[3] = 0;
        }

        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
            int index = codes & 0x3;
            codes >>= 2;

            int pixel_x = x * 4 + j;
            int pixel_y = y * 4 + i;
            if (pixel_x >= sizeX || pixel_y >= sizeY)
              continue;

            pixels[pixel_y * sizeX + pixel_x] = colors[index];
          }
        }
      }
    }

    save_image(pixels, sizeX, sizeY, output_file);
  } else if (format == DXT5) {
    // Create output image
    std::vector<int> pixels(sizeX * sizeY);

    int block_count_x = (sizeX + 3) / 4;
    int block_count_y = (sizeY + 3) / 4;

    // Decode blocks
    for (int y = 0; y < block_count_y; y++) {
      for (int x = 0; x < block_count_x; x++) {
        int block_index = y * block_count_x + x;
        int block_offset = block_index * 16;

        int alpha0 = *reinterpret_cast<const char*>(data + block_offset + 0);
        int alpha1 = *reinterpret_cast<const char*>(data + block_offset + 1);

        int codes = *reinterpret_cast<const int*>(data + block_offset + 8);

        int alphas[8];
        alphas[0] = alpha0;
        alphas[1] = alpha1;
        if (alpha0 > alpha1) {
          for (int i = 0; i < 6; i++)
            alphas[i + 2] = (6 - i) * alpha0 / 6 + i * alpha1 / 6;
        } else {
          for (int i = 0; i < 4; i++)
            alphas[i + 2] = (4 - i) * alpha0 / 4 + i * alpha1 / 4;
          alphas[6] = 0;
          alphas[7] = 255;
        }

        int color0 = *reinterpret_cast<const int*>(data + block_offset + 4);
        int color1 = *reinterpret_cast<const int*>(data + block_offset + 12);

        int colors[4];
        colors[0] = unpack565(color0);
        colors[1] = unpack565(color1);

        if (color0 > color1) {
          colors[2] = interpolate(colors[0], 2, colors[1], 1);
          colors[3] = interpolate(colors[0], 1, colors[1], 2);
        } else {
          colors[2] = interpolate(colors[0], 1, colors[1], 1);
          colors[3] = 0;
        }

        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < 4; j++) {
            int index = codes & 0x3;
            codes >>= 2;

            int pixel_x = x * 4 + j;
            int pixel_y = y * 4 + i;
            if (pixel_x >= sizeX || pixel_y >= sizeY)
              continue;

            int color = colors[index];
            int alpha_index = (codes >> (3 * (4 - i - 1))) & 0x7;
            int alpha = alphas[alpha_index];

            pixels[pixel_y * sizeX + pixel_x] = (alpha << 24) | (color & 0xFFFFFF);
          }
        }
      }
    }

    save_image(pixels, sizeX, sizeY, output_file);
  }
}

void save_image(const std::vector<int>& pixels, int width, int height, const std::string& file_name) {
  // ...
}

std::vector<std::string> find_files_in_directory(const std::string& directory, const std::string& extension) {
  // ...
}

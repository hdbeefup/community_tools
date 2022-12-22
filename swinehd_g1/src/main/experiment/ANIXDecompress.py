import io
import numpy as np
from PIL import Image
from airlift.compress.zstd import ZstdDecompressor

def anix_decompress(anim_path, folder_path):
    with open(anim_path, 'rb') as anim:
        header = anim.read(28)
        header = header[8:]  # Skip stormregion headers

        format, size, W, H, frames = np.frombuffer(header, np.int32)

        # DXT encoding required W and H to be divisible by 4, thus the 'real'
        #  buffer is slightly bigger than the actual image size
        size_x = W
        size_y = H

        frame_buffer_size = size_x * size_y * 8

        # Weird way of calculating frame buffer size, directly from disassembly
        esi = (W + ((W + 3) & 3)) >> 2
        eax = (H + ((H + 3) & 3)) >> 2

        frame_buffer_size = (esi * eax) * frames << 3

        before = anim.read(size - 12)
        before = np.frombuffer(before, np.uint8)

        decomp = ZstdDecompressor()
        after = decomp.decompress(before, frame_buffer_size)
        after = np.frombuffer(after, np.uint8)

        for i in range(frames):
            frame = DXTDecompress.decode_bifurcated_dxt1(after, W, H)
            frame = Image.fromarray(frame)
            frame.save(f"{folder_path}/{i}.png")

anim_path = "D:/Temp/190609_swine/remaster/videos/p_intro.anif"
folder_path = "D:/Temp/190609_swine/anim"
anix_decompress(anim_path, folder_path)

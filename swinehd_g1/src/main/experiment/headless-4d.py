import os
import struct
import math
import mathutils

# Remove the following import statements, as they are specific to Blender and not needed in a standalone script
# import bpy
# import bpy_extras.image_utils
# import bpy_extras.node_shader_utils

import collections

def read_kind(file):
    return file.read(4).decode()

def read_uint(file):
    return struct.unpack('<I', file.read(4))[0]

def read_sint(file):
    return struct.unpack('<i', file.read(4))[0]

def read_ushort(file):
    return struct.unpack('<H', file.read(2))[0]

def read_float(file):
    return struct.unpack('<f', file.read(4))[0]

def read_string(file):
    return file.read( read_ushort(file) ).decode()

def read_vec(file, components):
    res = mathutils.Vector()
    
    for i in range(components):
        res[i] = read_float(file)
        
    return res

def iter_chunks(file, limit):    
    while(file.tell() < limit):
        kind = read_kind(file)
        size = read_uint(file)
        
        last = file.tell() + size
    
        yield (kind, last)
    
        file.seek(last)


class ParsingContext():
    def __init__(self):
        self.scale = 0.005  # Sr model files are HUGE in blender units..

        self.folder   = None        
        self.objects = []
        self.parents = []

        self.mesh = None
        self.obj  = None

def parse_material(file, limit, ctx):
    
    # TODO: These properties are actually unsupported, first DIFF applies to whole object
    numFaces    = read_uint(file)
    vertexStart = read_uint(file)
    vertexEnd   = read_uint(file) + vertexStart
    
    diffuse = None
    
    for (kind, limit) in iter_chunks(file, limit):    
        if kind == 'DIFF':
            diffuse = read_string(file)
            
            # All textures are supposed to be .png files
            diffuse = diffuse.replace('.tga', '.png')
            
        # Other settings are not supported
        pass

    # Sanity check
    if not diffuse:
        return

    # Assign material to mesh vertices
    uid = diffuse

    # Reuse existing material if exists, create in worst case
    material = bpy.data.materials.get(uid)
    
    if not material:
        material = bpy.data.materials.new(uid)

        wrapper = bpy_extras.node_shader_utils.PrincipledBSDF
(material, is_readonly=False)  

        wrapper.base_color = (1, 1, 1)
        wrapper.use_nodes  = True

        # Load/create the diffuse texture for this material
        # wrapper.base_color_texture.image = bpy_extras.image_utils.load_image(diffuse, ctx.folder, place_holder=True)
    
    # Associate material with the current object
    materialID = len(ctx.mesh.materials)

    ctx.mesh.materials.append(material)

    # Apply material selectively to the selected polygons
    for poly in ctx.mesh.polygons:
        for vertexID in poly.vertices:
            
            if vertexStart <= vertexID and vertexID <= vertexEnd:
                poly.material_index = materialID

def parse_object(file, limit, ctx):
    name     = read_string(file)
    parentID = read_sint(file)
    
    # Allocate associated blender structures
    ctx.mesh = bpy.data.meshes.new(name)
    ctx.obj  = bpy.data.objects.new(name, ctx.mesh)
    
    # Add to parsing context
    ctx.objects.append(ctx.obj)
    ctx.parents.append(parentID)
    
    for (kind, limit) in iter_chunks(file, limit):    
        if kind == 'VRTS':
            parse_vertices(file, limit, ctx)
            
        elif kind == 'TRIS':
            parse_triangles(file, limit, ctx)
            
        elif kind == 'MATT':
            parse_material(file, limit, ctx)
            
        # Other object chunks are not supported
        pass

def parse_vertices(file, limit, ctx):
    numVertices = read_uint(file)

    ctx.mesh.vertices.add(numVertices)
    ctx.mesh.vertices.foreach_set("co", [ (read_float(file) * ctx.scale, read_float(file) * ctx.scale, read_float(file) * ctx.scale) for i in range(numVertices) ] )
    
    for (kind, limit) in iter_chunks(file, limit):
        if kind == 'UVCO':
            uvcoords = [(read_float(file), read_float(file)) for i in range(numVertices)]
            uvlayer = ctx.mesh.uv_layers.new()
            uvlayer.data.foreach_set("uv", uvcoords)
    
        # Other vertex chunks are not supported
        pass

def parse_triangles(file, limit, ctx):
    numTriangles = read_uint(file)

    ctx.mesh.polygons.add(numTriangles)

    triangles = [ (read_ushort(file), read_ushort(file), read_ushort(file)) for i in range(numTriangles) ]

    ctx.mesh.polygons.foreach_set("vertices", triangles)

def parse_mesh(file, limit, ctx):
    name = read_string(file)

    # Allocate associated blender structures
    ctx.mesh = bpy.data.meshes.new(name)
    ctx.obj  = bpy.data.objects.new(name, ctx.mesh)

    # Add to parsing context
    ctx.objects.append(ctx.obj)
    ctx.parents.append(-1)

    for (kind, limit) in iter_chunks(file, limit):    
        if kind == 'VRTS':
            parse_vertices(file, limit, ctx)
            
        elif kind == 'TRIS':
            parse_triangles(file, limit, ctx)
            
        elif kind == 'MATT':
            parse_material(file, limit, ctx)
            
        elif kind == 'OBJT':
            parse_object(file, limit, ctx)
            
        # Other mesh chunks are not supported
        pass

def parse_file(file, ctx):
    for (kind, limit) in iter_chunks(file, file.seek(0, 2)):    
        if kind == 'MESH':
            parse_mesh(file, limit, ctx)
            
        # Other top-level chunks are not supported
        pass

def parse(filepath, ctx):
    with open(filepath, 'rb') as file:
        parse_file(file, ctx)
        
        # Compute parenting
        for i, parent in enumerate(ctx.parents):
            if parent >= 0:
                ctx.objects[i].parent = ctx.objects[parent]

# Main program

if __name__ == "__main__":
    import sys
    
    if len(sys.argv) != 3:
        print("Usage: sr_import.py <input.sr> <output.obj>")
        sys.exit(1)
    
    ctx = ParsingContext()
    ctx.folder = os.path.dirname(sys.argv[1])
    
    parse(sys.argv[1], ctx)
    
    # Write .obj file
    with open(sys.argv[2], 'w') as file:
        # Write vertex data
        for vertex in ctx.mesh.vertices:
            file.write("v %f %f %f\n" % vertex.co[:])
        
        # Write texture coordinate data
        uv_layer = ctx.mesh.uv_layers.active
        
        if uv_layer is not None:
            for uv in uv_layer.data:
                file.write("vt %f %f\n" % uv.uv[:])
        
        # Write face data
        for polygon in ctx.mesh.polygons:
            file.write("f")
            
            for loop_index in polygon.loop_indices:
                vertex_index = ctx.mesh.loops[loop_index].vertex_index
                
                if uv_layer is not None:
                    uv_index = ctx.mesh.loops[loop_index].uv_index
                    file.write(" %d/%d" % (vertex_index + 1, uv_index + 1))
                else:
                    file.write(" %d" % (vertex_index + 1))
            
            file.write("\n")



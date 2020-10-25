/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.myVertex;
/*    */ import java4d.my4dfile.InvalidDataException;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.sect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VERTdata
/*    */   extends sectData
/*    */ {
/*    */   public myVertex[] vert;
/*    */   
/*    */   public VERTdata(sect owner)
/*    */   {
/* 23 */     super(owner);
/* 24 */     this.vert = null;
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 29 */     return this.vert.length * this.vert[0].dataSize() + 8;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 34 */     byte[] ret = new byte[this.vert.length * this.vert[0].dataSize() + 8];
/* 35 */     myutil.putInt(this.vert.length, ret, 0);
/* 36 */     for (int i = 0; i < this.vert.length; i++)
/* 37 */       this.vert[i].toBytes(ret, 8 + i * this.vert[0].dataSize());
/* 38 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset) throws InvalidDataException
/*    */   {
/* 43 */     int loaded = 4;
/* 44 */     this.vert = new myVertex[myutil.getInt(data, offset + loaded)];
/* 45 */     this.vert[0] = new myVertex();
/* 46 */     if (myutil.getInt(data, offset + loaded + 4) != 0)
/* 47 */       throw new InvalidDataException("VERT section: int #2: " + myutil.getInt(data, offset + loaded + 4));
/* 48 */     loaded += 8;
/*    */     
/* 50 */     for (int i = 0; i < this.vert.length; i++) {
/* 51 */       this.vert[i] = new myVertex(data, offset + loaded + i * this.vert[0].dataSize());
/*    */     }
/* 53 */     loaded += this.vert.length * this.vert[0].dataSize();
/*    */     
/* 55 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/VERTdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
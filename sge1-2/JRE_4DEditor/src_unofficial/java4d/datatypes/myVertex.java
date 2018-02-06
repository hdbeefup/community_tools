/*    */ package java4d.datatypes;
/*    */ 
/*    */ import java.awt.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class myVertex
/*    */   extends myDataType
/*    */ {
/*    */   public vector3f coord;
/*    */   public vector3f normal;
/*    */   public vector2f textureCoord;
/*    */   
/*    */   public myVertex()
/*    */   {
/* 21 */     this.coord = new vector3f();
/* 22 */     this.normal = new vector3f();
/* 23 */     this.textureCoord = new vector2f();
/*    */   }
/*    */   
/*    */   public int dataSize() {
/* 27 */     return this.coord.dataSize() + this.normal.dataSize() + this.textureCoord.dataSize();
/*    */   }
/*    */   
/*    */ 
/*    */   public myVertex(byte[] source, int offset)
/*    */   {
/* 33 */     this();
/* 34 */     getFrom(source, offset);
/*    */   }
/*    */   
/*    */   public void toBytes(byte[] dest, int offset) {
/* 38 */     this.coord.toBytes(dest, offset);
/* 39 */     this.normal.toBytes(dest, offset + this.coord.dataSize());
/* 40 */     this.textureCoord.toBytes(dest, offset + this.coord.dataSize() * 2);
/*    */   }
/*    */   
/*    */   public void getFrom(byte[] source, int offset) {
/* 44 */     this.coord.getFrom(source, offset);
/* 45 */     this.normal.getFrom(source, offset + this.coord.dataSize());
/* 46 */     this.textureCoord.getFrom(source, offset + this.coord.dataSize() * 2);
/*    */   }
/*    */   
/*    */ 
/*    */   public myVertex clone()
/*    */   {
/* 52 */     myVertex copy = new myVertex();
/* 53 */     copy.coord = this.coord.clone();
/* 54 */     copy.normal = this.normal.clone();
/* 55 */     copy.textureCoord = this.textureCoord.clone();
/* 56 */     return copy;
/*    */   }
/*    */   
/*    */   public Component getEditor()
/*    */   {
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/myVertex.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
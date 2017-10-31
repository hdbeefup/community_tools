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
/*    */ public class myBox
/*    */   extends myDataType
/*    */ {
/*    */   public vector3f[] coords;
/*    */   
/*    */   public myBox()
/*    */   {
/* 19 */     this.coords = new vector3f[8];
/* 20 */     for (int i = 0; i < 8; i++)
/* 21 */       this.coords[i] = new vector3f();
/*    */   }
/*    */   
/*    */   public int dataSize() {
/* 25 */     return 8 * this.coords[0].dataSize();
/*    */   }
/*    */   
/*    */   public myBox(byte[] source, int offset) {
/* 29 */     this();
/* 30 */     getFrom(source, offset);
/*    */   }
/*    */   
/*    */   public void toBytes(byte[] dest, int offset) {
/* 34 */     for (int i = 0; i < 8; i++) {
/* 35 */       this.coords[i].toBytes(dest, offset + i * this.coords[0].dataSize());
/*    */     }
/*    */   }
/*    */   
/*    */   public void getFrom(byte[] source, int offset) {
/* 40 */     for (int i = 0; i < 8; i++) {
/* 41 */       this.coords[i].getFrom(source, offset + i * this.coords[0].dataSize());
/*    */     }
/*    */   }
/*    */   
/*    */   public myBox clone()
/*    */   {
/* 47 */     myBox copy = new myBox();
/* 48 */     for (int i = 0; i < 8; i++)
/* 49 */       copy.coords[i] = this.coords[i].clone();
/* 50 */     return copy;
/*    */   }
/*    */   
/*    */   public Component getEditor()
/*    */   {
/* 55 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/myBox.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
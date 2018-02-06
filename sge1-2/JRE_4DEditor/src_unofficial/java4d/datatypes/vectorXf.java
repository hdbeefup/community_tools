/*    */ package java4d.datatypes;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java4d.myutil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class vectorXf
/*    */   extends myDataType
/*    */ {
/*    */   public float[] val;
/*    */   
/*    */   public vectorXf(int cardinality)
/*    */   {
/* 20 */     this.val = new float[cardinality];
/*    */   }
/*    */   
/*    */   public int dataSize() {
/* 24 */     return this.val.length * 4;
/*    */   }
/*    */   
/*    */   public vectorXf(byte[] source, int offset, int cardinality) {
/* 28 */     this(cardinality);
/* 29 */     getFrom(source, offset);
/*    */   }
/*    */   
/*    */   public void toBytes(byte[] dest, int offset) {
/* 33 */     for (int i = 0; i < this.val.length; i++)
/* 34 */       myutil.putFloat(this.val[i], dest, offset + i * 4);
/*    */   }
/*    */   
/*    */   public void getFrom(byte[] source, int offset) {
/* 38 */     for (int i = 0; i < this.val.length; i++) {
/* 39 */       this.val[i] = myutil.getFloat(source, offset + i * 4);
/*    */     }
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 45 */     String ret = new String("( ");
/* 46 */     for (float f : this.val) {
/* 47 */       ret = ret + String.format("%.2f ", new Object[] { Float.valueOf(f) });
/*    */     }
/* 49 */     return ret + ") ";
/*    */   }
/*    */   
/*    */ 
/*    */   public vectorXf clone()
/*    */   {
/* 55 */     vectorXf copy = new vectorXf(this.val.length);
/* 56 */     copy.val = ((float[])this.val.clone());
/* 57 */     return copy;
/*    */   }
/*    */   
/*    */   public Component getEditor()
/*    */   {
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/vectorXf.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
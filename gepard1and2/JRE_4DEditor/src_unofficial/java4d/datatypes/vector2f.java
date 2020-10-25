/*    */ package java4d.datatypes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class vector2f
/*    */   extends vectorXf
/*    */ {
/*    */   public vector2f()
/*    */   {
/* 16 */     super(2);
/*    */   }
/*    */   
/*    */   public vector2f(byte[] source, int offset) {
/* 20 */     this();
/* 21 */     getFrom(source, offset);
/*    */   }
/*    */   
/*    */ 
/*    */   public vector2f clone()
/*    */   {
/* 27 */     vector2f copy = new vector2f();
/* 28 */     copy.val = ((float[])this.val.clone());
/* 29 */     return copy;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/vector2f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
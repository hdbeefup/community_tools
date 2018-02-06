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
/*    */ public class vector3f
/*    */   extends vectorXf
/*    */ {
/*    */   public vector3f()
/*    */   {
/* 16 */     super(3);
/*    */   }
/*    */   
/*    */   public vector3f(byte[] source, int offset) {
/* 20 */     this();
/* 21 */     getFrom(source, offset);
/*    */   }
/*    */   
/*    */   public vector3f clone()
/*    */   {
/* 26 */     vector3f copy = new vector3f();
/* 27 */     copy.val = ((float[])this.val.clone());
/* 28 */     return copy;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/vector3f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
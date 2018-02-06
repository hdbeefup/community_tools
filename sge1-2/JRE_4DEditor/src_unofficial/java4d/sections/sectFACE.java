/*    */ package java4d.sections;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectFACE
/*    */   extends sectINDI
/*    */ {
/*    */   public sectFACE(sect parent)
/*    */   {
/* 16 */     super(parent);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 22 */     return new String("FACE: " + getIndCount() / 3 + " face(s)");
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectFACE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
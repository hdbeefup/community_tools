/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.myutil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectFLYZ
/*    */   extends sect
/*    */ {
/*    */   public sectFLYZ(sect parent)
/*    */   {
/* 15 */     super(parent);
/* 16 */     this.sectList = null;
/* 17 */     this.sdata = null;
/*    */   }
/*    */   
/*    */   public boolean loadData(byte[] data, int offset)
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 28 */     return new String("FLYZ");
/*    */   }
/*    */   
/*    */   public int toBytes(byte[] dest, int offset)
/*    */   {
/* 33 */     System.arraycopy(getTitle().getBytes(), 0, dest, offset, 4);
/* 34 */     myutil.putInt(0, dest, offset + 4);
/* 35 */     return 8;
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 40 */     return 8;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectFLYZ.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.Unknowndata;
/*    */ import java4d.sections.data.sectData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectUnknown
/*    */   extends sect
/*    */ {
/*    */   private byte[] title;
/*    */   
/*    */   public sectUnknown(sect parent)
/*    */   {
/* 21 */     super(parent);
/* 22 */     this.title = new byte[4];
/* 23 */     this.sdata = new Unknowndata(this);
/* 24 */     this.sectList = null;
/*    */   }
/*    */   
/*    */   public boolean loadData(byte[] data, int offset)
/*    */   {
/*    */     try
/*    */     {
/* 31 */       System.arraycopy(data, offset, this.title, 0, 4);
/* 32 */       this.sdata.loadData(data, offset + 4);
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 45 */     return new String(this.title);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectUnknown.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
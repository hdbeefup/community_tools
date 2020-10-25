/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java.util.LinkedList;
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
/*    */ public class MTLSdata
/*    */   extends sectData
/*    */ {
/*    */   public MTLSdata(sect owner)
/*    */   {
/* 19 */     super(owner);
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 24 */     return 4;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 29 */     byte[] ret = new byte[4];
/* 30 */     myutil.putInt(this.owner.getChildren() != null ? this.owner.getChildren().size() : 0, ret, 0);
/* 31 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 36 */     int loaded = 4;
/*    */     
/* 38 */     loaded += 4;
/*    */     
/*    */ 
/* 41 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/MTLSdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
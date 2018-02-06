/*    */ package java4d.sections.data;
/*    */ 
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
/*    */ public class PONTdata
/*    */   extends sectData
/*    */ {
/*    */   public float maxDist;
/*    */   public float constantAtt;
/*    */   public float lineartAtt;
/*    */   public float quadraticAtt;
/*    */   
/*    */   public PONTdata(sect owner)
/*    */   {
/* 24 */     super(owner);
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 29 */     return 16;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 34 */     byte[] ret = new byte[16];
/* 35 */     myutil.putFloat(this.maxDist, ret, 0);
/* 36 */     myutil.putFloat(this.constantAtt, ret, 4);
/* 37 */     myutil.putFloat(this.lineartAtt, ret, 8);
/* 38 */     myutil.putFloat(this.quadraticAtt, ret, 12);
/* 39 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 44 */     int loaded = 4;
/*    */     
/* 46 */     this.maxDist = myutil.getFloat(data, offset + loaded + 0);
/* 47 */     this.constantAtt = myutil.getFloat(data, offset + loaded + 4);
/* 48 */     this.lineartAtt = myutil.getFloat(data, offset + loaded + 8);
/* 49 */     this.quadraticAtt = myutil.getFloat(data, offset + loaded + 12);
/* 50 */     loaded += 16;
/*    */     
/* 52 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/PONTdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
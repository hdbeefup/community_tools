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
/*    */ public class SPOTdata
/*    */   extends sectData
/*    */ {
/*    */   public float coneLen;
/*    */   public float constantAtt;
/*    */   public float lineartAtt;
/*    */   public float quadraticAtt;
/*    */   public float spotExp;
/*    */   public float spotCutoff;
/*    */   
/*    */   public SPOTdata(sect owner)
/*    */   {
/* 26 */     super(owner);
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 31 */     return 24;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 36 */     byte[] ret = new byte[24];
/* 37 */     myutil.putFloat(this.coneLen, ret, 0);
/* 38 */     myutil.putFloat(this.constantAtt, ret, 4);
/* 39 */     myutil.putFloat(this.lineartAtt, ret, 8);
/* 40 */     myutil.putFloat(this.quadraticAtt, ret, 12);
/* 41 */     myutil.putFloat(this.spotExp, ret, 16);
/* 42 */     myutil.putFloat(this.spotCutoff, ret, 20);
/* 43 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 48 */     int loaded = 4;
/*    */     
/* 50 */     this.coneLen = myutil.getFloat(data, offset + loaded + 0);
/* 51 */     this.constantAtt = myutil.getFloat(data, offset + loaded + 4);
/* 52 */     this.lineartAtt = myutil.getFloat(data, offset + loaded + 8);
/* 53 */     this.quadraticAtt = myutil.getFloat(data, offset + loaded + 12);
/* 54 */     this.spotExp = myutil.getFloat(data, offset + loaded + 16);
/* 55 */     this.spotCutoff = myutil.getFloat(data, offset + loaded + 20);
/* 56 */     loaded += 24;
/*    */     
/* 58 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/SPOTdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
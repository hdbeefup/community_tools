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
/*    */ public class MATEdata
/*    */   extends sectData
/*    */ {
/*    */   public int indiCount;
/*    */   public int vertStart;
/*    */   public int vertStop;
/*    */   
/*    */   public MATEdata(sect owner)
/*    */   {
/* 23 */     super(owner);
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 28 */     return 12;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 33 */     byte[] ret = new byte[12];
/* 34 */     myutil.putInt(this.indiCount, ret, 0);
/* 35 */     myutil.putInt(this.vertStart, ret, 4);
/* 36 */     myutil.putInt(this.vertStop, ret, 8);
/* 37 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 42 */     int loaded = 4;
/*    */     
/* 44 */     this.indiCount = myutil.getInt(data, offset + loaded);
/* 45 */     loaded += 4;
/*    */     
/* 47 */     this.vertStart = myutil.getInt(data, offset + loaded);
/* 48 */     loaded += 4;
/*    */     
/* 50 */     this.vertStop = myutil.getInt(data, offset + loaded);
/* 51 */     loaded += 4;
/*    */     
/* 53 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/MATEdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
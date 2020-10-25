/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.sections.sect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SCENdata
/*    */   extends sectData
/*    */ {
/*    */   private byte[] ver;
/*    */   
/*    */   public SCENdata(sect owner)
/*    */   {
/* 19 */     super(owner);
/* 20 */     this.ver = new byte[4];
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 25 */     return 4;
/*    */   }
/*    */   
/*    */ 
/*    */   public byte[] getData()
/*    */   {
/* 31 */     return this.ver;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/*    */     try
/*    */     {
/* 39 */       System.arraycopy(data, offset + 4, this.ver, 0, 4);
/*    */     }
/*    */     catch (ArrayIndexOutOfBoundsException ex) {}
/*    */     
/* 43 */     return 4;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getVersionInt()
/*    */   {
/* 52 */     this.ver[0] = 49;
/* 53 */     int v = Integer.decode(new String(this.ver)).intValue();
/* 54 */     this.ver[0] = 118;
/* 55 */     return v - 1000;
/*    */   }
/*    */   
/*    */   public String getVersionStr()
/*    */   {
/* 60 */     return new String(this.ver);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/SCENdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
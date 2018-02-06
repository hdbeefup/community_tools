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
/*    */ public class Unknowndata
/*    */   extends sectData
/*    */ {
/*    */   public byte[] rawdata;
/*    */   
/*    */   public Unknowndata(sect owner)
/*    */   {
/* 20 */     super(owner);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getSize()
/*    */   {
/* 26 */     return this.rawdata.length;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 31 */     return this.rawdata;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 36 */     int loaded = 0;
/*    */     try
/*    */     {
/* 39 */       loaded = myutil.getInt(data, offset);
/* 40 */       this.rawdata = new byte[loaded];
/* 41 */       System.arraycopy(data, offset + 4, this.rawdata, 0, this.rawdata.length);
/*    */     }
/*    */     catch (ArrayIndexOutOfBoundsException ex) {}
/*    */     
/* 45 */     return loaded;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/Unknowndata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
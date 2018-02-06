/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.infoLabel;
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
/*    */ public class SSQEdata
/*    */   extends sectData
/*    */ {
/*    */   public infoLabel desc;
/*    */   public byte[] unkdata;
/*    */   
/*    */   public SSQEdata(sect owner)
/*    */   {
/* 22 */     super(owner);
/* 23 */     this.desc = new infoLabel();
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 28 */     return this.desc.dataSize() + this.unkdata.length;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 33 */     byte[] ret = new byte[this.desc.dataSize() + 24];
/* 34 */     this.desc.toBytes(ret, 0);
/* 35 */     System.arraycopy(this.unkdata, 0, ret, this.desc.dataSize(), 24);
/* 36 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 41 */     int loaded = 4;
/*    */     
/* 43 */     this.desc.getFrom(data, offset + loaded);
/* 44 */     loaded += this.desc.dataSize();
/*    */     
/* 46 */     this.unkdata = new byte[24];
/* 47 */     System.arraycopy(data, offset + loaded, this.unkdata, 0, 24);
/* 48 */     loaded += 24;
/*    */     
/* 50 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/SSQEdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
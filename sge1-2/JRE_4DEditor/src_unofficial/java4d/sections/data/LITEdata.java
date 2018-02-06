/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.vector3f;
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
/*    */ public class LITEdata
/*    */   extends MESHdata
/*    */ {
/*    */   public String version;
/*    */   public vector3f lightColor;
/*    */   public float lightMult;
/*    */   
/*    */   public LITEdata(sect owner)
/*    */   {
/* 24 */     super(owner);
/* 25 */     this.lightColor = new vector3f();
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 30 */     return super.getSize() + this.lightColor.dataSize() + 8;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 35 */     byte[] ret = new byte[getSize()];
/* 36 */     int loaded = 0;
/*    */     
/* 38 */     System.arraycopy(super.getData(), 0, ret, 0, loaded += super.getSize());
/*    */     
/* 40 */     System.arraycopy(this.version.getBytes(), 0, ret, loaded, 4);
/* 41 */     loaded += 4;
/*    */     
/* 43 */     this.lightColor.toBytes(ret, loaded);
/* 44 */     loaded += this.lightColor.dataSize();
/*    */     
/* 46 */     myutil.putFloat(this.lightMult, ret, loaded);
/*    */     
/* 48 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 53 */     int loaded = 0;
/* 54 */     loaded += super.loadData(data, offset + loaded);
/*    */     
/* 56 */     loaded += 4;
/*    */     
/* 58 */     this.version = new String(data, offset + loaded, 4);
/* 59 */     loaded += this.version.length();
/*    */     
/* 61 */     this.lightColor.getFrom(data, offset + loaded);
/* 62 */     loaded += this.lightColor.dataSize();
/*    */     
/* 64 */     this.lightMult = myutil.getFloat(data, offset + loaded);
/* 65 */     loaded += 4;
/*    */     
/* 67 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/LITEdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
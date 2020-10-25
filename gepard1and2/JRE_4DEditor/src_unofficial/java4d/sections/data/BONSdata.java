/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.bone;
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
/*    */ public class BONSdata
/*    */   extends sectData
/*    */ {
/*    */   public bone[] bones;
/*    */   
/*    */   public BONSdata(sect owner)
/*    */   {
/* 22 */     super(owner);
/* 23 */     this.bones = new bone[0];
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 28 */     return 4 + this.bones.length * this.bones[0].dataSize();
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 33 */     byte[] ret = new byte[getSize()];
/* 34 */     myutil.putInt(this.bones.length, ret, 0);
/* 35 */     for (int i = 0; i < this.bones.length; i++)
/* 36 */       this.bones[i].toBytes(ret, i * this.bones[0].dataSize() + 4);
/* 37 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 42 */     int loaded = 4;
/*    */     
/* 44 */     this.bones = new bone[myutil.getInt(data, offset + loaded)];
/* 45 */     loaded += 4;
/*    */     
/* 47 */     for (int i = 0; i < this.bones.length; i++)
/*    */     {
/* 49 */       this.bones[i] = new bone();
/* 50 */       this.bones[i].getFrom(data, offset + loaded);
/* 51 */       loaded += this.bones[0].dataSize();
/*    */     }
/*    */     
/* 54 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/BONSdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
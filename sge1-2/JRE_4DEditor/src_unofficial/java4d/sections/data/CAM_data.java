/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.vector3f;
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
/*    */ public class CAM_data
/*    */   extends MESHdata
/*    */ {
/*    */   public vector3f fov;
/*    */   
/*    */   public CAM_data(sect owner)
/*    */   {
/* 21 */     super(owner);
/* 22 */     this.fov = new vector3f();
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 27 */     return super.getSize() + this.fov.dataSize();
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 32 */     byte[] ret = new byte[getSize()];
/* 33 */     int offset = 0;
/*    */     
/* 35 */     System.arraycopy(super.getData(), 0, ret, 0, offset += super.getSize());
/*    */     
/* 37 */     this.fov.toBytes(ret, offset);
/*    */     
/* 39 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 44 */     int loaded = 0;
/* 45 */     loaded += super.loadData(data, offset + loaded);
/*    */     
/* 47 */     loaded += 4;
/*    */     
/* 49 */     this.fov.getFrom(data, offset + loaded);
/* 50 */     loaded += this.fov.dataSize();
/*    */     
/* 52 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/CAM_data.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
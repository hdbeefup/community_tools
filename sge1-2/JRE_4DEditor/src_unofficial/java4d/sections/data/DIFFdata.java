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
/*    */ public class DIFFdata
/*    */   extends sectData
/*    */ {
/*    */   public infoLabel desc;
/*    */   
/*    */   public DIFFdata(sect owner)
/*    */   {
/* 21 */     super(owner);
/* 22 */     this.desc = new infoLabel();
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 27 */     return this.desc.dataSize();
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 32 */     return this.desc.toBytes();
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 37 */     int loaded = 4;
/*    */     
/* 39 */     this.desc.getFrom(data, offset + loaded);
/* 40 */     loaded += this.desc.dataSize();
/*    */     
/* 42 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/DIFFdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
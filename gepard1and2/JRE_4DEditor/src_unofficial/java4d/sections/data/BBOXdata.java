/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.myBox;
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
/*    */ public class BBOXdata
/*    */   extends sectData
/*    */ {
/*    */   public myBox box;
/*    */   
/*    */   public BBOXdata(sect owner)
/*    */   {
/* 21 */     super(owner);
/* 22 */     this.box = new myBox();
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 27 */     return this.box.dataSize();
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 32 */     return this.box.toBytes();
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 37 */     int loaded = 4;
/*    */     
/* 39 */     this.box.getFrom(data, offset + loaded);
/* 40 */     loaded += this.box.dataSize();
/*    */     
/* 42 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/BBOXdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
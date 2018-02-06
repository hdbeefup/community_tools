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
/*    */ public class AMBIdata
/*    */   extends sectData
/*    */ {
/*    */   public vector3f vectAMBI;
/*    */   
/*    */   public AMBIdata(sect owner)
/*    */   {
/* 21 */     super(owner);
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 26 */     return this.vectAMBI.dataSize();
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 31 */     return this.vectAMBI.toBytes();
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 36 */     this.vectAMBI = new vector3f(data, offset + 4);
/* 37 */     return this.vectAMBI.dataSize();
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/AMBIdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.datatypes;
/*    */ 
/*    */ import java.awt.Component;
/*    */ 
/*    */ public abstract class myDataType
/*    */   implements Cloneable
/*    */ {
/*    */   public abstract int dataSize();
/*    */   
/*    */   public abstract void toBytes(byte[] paramArrayOfByte, int paramInt);
/*    */   
/*    */   public abstract void getFrom(byte[] paramArrayOfByte, int paramInt);
/*    */   
/*    */   public byte[] toBytes()
/*    */   {
/* 16 */     byte[] ret = new byte[dataSize()];
/* 17 */     toBytes(ret, 0);
/* 18 */     return ret;
/*    */   }
/*    */   
/*    */   public abstract myDataType clone();
/*    */   
/*    */   public abstract Component getEditor();
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/myDataType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
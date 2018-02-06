/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.myutil;
/*    */ import java4d.sections.sect;
/*    */ import java4d.sections.sectINDI;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class INDIdata
/*    */   extends sectData
/*    */ {
/*    */   public int[] ind;
/*    */   
/*    */   public INDIdata(sect owner)
/*    */   {
/* 21 */     super(owner);
/* 22 */     this.ind = null;
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 27 */     return this.ind.length * 2 + 4;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 32 */     byte[] ret = new byte[this.ind.length * 2 + 4];
/* 33 */     myutil.putInt(this.owner.getClass() == sectINDI.class ? this.ind.length : this.ind.length / 3, ret, 0);
/* 34 */     for (int i = 0; i < this.ind.length; i++)
/* 35 */       myutil.putShort(this.ind[i], ret, 4 + i * 2);
/* 36 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 41 */     int loaded = 4;
/*    */     
/* 43 */     int indlen = myutil.getInt(data, offset + loaded);
/* 44 */     this.ind = new int[this.owner.getClass() == sectINDI.class ? indlen : indlen * 3];
/* 45 */     loaded += 4;
/*    */     
/* 47 */     for (int i = 0; i < this.ind.length; i++)
/* 48 */       this.ind[i] = myutil.getShort(data, offset + loaded + i * 2);
/* 49 */     loaded += this.ind.length * 2;
/*    */     
/* 51 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/INDIdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
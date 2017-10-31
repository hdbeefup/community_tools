/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.INDIdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectINDI
/*    */   extends sect
/*    */ {
/*    */   protected INDIdata sdatacasted;
/*    */   
/*    */   public sectINDI(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new INDIdata(this);
/* 22 */     this.sdatacasted = ((INDIdata)this.sdata);
/*    */   }
/*    */   
/*    */   public sectINDI(sectMESH parent, int numIndices)
/*    */   {
/* 27 */     this(parent);
/* 28 */     this.sdatacasted.ind = new int[numIndices];
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 34 */     return new String("INDI: " + getIndCount() + " index(es)");
/*    */   }
/*    */   
/*    */   public int getIndCount()
/*    */   {
/* 39 */     return this.sdatacasted.ind.length;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectINDI.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.datatypes.infoLabel;
/*    */ import java4d.sections.data.DIFFdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectDIFF
/*    */   extends sect
/*    */ {
/*    */   protected DIFFdata sdatacasted;
/*    */   
/*    */   public sectDIFF(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new DIFFdata(this);
/* 22 */     this.sdatacasted = ((DIFFdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("DIFF: " + this.sdatacasted.desc.val);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectDIFF.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
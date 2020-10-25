/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.datatypes.infoLabel;
/*    */ import java4d.sections.data.DIFFdata;
/*    */ import java4d.sections.data.REFLdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectREFL
/*    */   extends sectDIFF
/*    */ {
/*    */   public sectREFL(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new REFLdata(this);
/* 22 */     this.sdatacasted = ((REFLdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("REFL: " + this.sdatacasted.desc.val);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectREFL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
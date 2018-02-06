/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.datatypes.infoLabel;
/*    */ import java4d.sections.data.SSQEdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectSSQE
/*    */   extends sect
/*    */ {
/*    */   protected SSQEdata sdatacasted;
/*    */   
/*    */   public sectSSQE(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new SSQEdata(this);
/* 22 */     this.sdatacasted = ((SSQEdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("SSQE: " + this.sdatacasted.desc.val);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectSSQE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
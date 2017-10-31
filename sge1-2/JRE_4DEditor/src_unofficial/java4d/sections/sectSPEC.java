/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.datatypes.infoLabel;
/*    */ import java4d.sections.data.DIFFdata;
/*    */ import java4d.sections.data.SPECdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectSPEC
/*    */   extends sectDIFF
/*    */ {
/*    */   public sectSPEC(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new SPECdata(this);
/* 22 */     this.sdatacasted = ((SPECdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("REFL: " + this.sdatacasted.desc.val);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectSPEC.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
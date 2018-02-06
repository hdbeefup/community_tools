/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.MATEdata;
/*    */ import java4d.sections.data.STRPdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectSTRP
/*    */   extends sectMATE
/*    */ {
/*    */   public sectSTRP(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new STRPdata(this);
/* 22 */     this.sdatacasted = ((STRPdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("STRP on " + this.sdatacasted.indiCount + " index(es)");
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectSTRP.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
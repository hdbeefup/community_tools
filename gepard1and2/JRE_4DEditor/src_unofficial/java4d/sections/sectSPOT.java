/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.SPOTdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectSPOT
/*    */   extends sect
/*    */ {
/*    */   protected SPOTdata sdatacasted;
/*    */   
/*    */   public sectSPOT(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new SPOTdata(this);
/* 22 */     this.sdatacasted = ((SPOTdata)this.sdata);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectSPOT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
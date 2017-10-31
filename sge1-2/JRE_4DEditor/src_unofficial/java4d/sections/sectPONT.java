/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.PONTdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectPONT
/*    */   extends sect
/*    */ {
/*    */   protected PONTdata sdatacasted;
/*    */   
/*    */   public sectPONT(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new PONTdata(this);
/* 22 */     this.sdatacasted = ((PONTdata)this.sdata);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectPONT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
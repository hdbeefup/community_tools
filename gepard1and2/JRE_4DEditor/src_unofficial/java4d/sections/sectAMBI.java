/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.AMBIdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectAMBI
/*    */   extends sect
/*    */ {
/*    */   private AMBIdata sdatacasted;
/*    */   
/*    */   public sectAMBI(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new AMBIdata(this);
/* 22 */     this.sdatacasted = ((AMBIdata)this.sdata);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectAMBI.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
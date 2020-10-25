/*    */ package java4d.sections;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java4d.sections.data.SSQSdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectSSQS
/*    */   extends sect
/*    */ {
/*    */   protected SSQSdata sdatacasted;
/*    */   
/*    */   public sectSSQS(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new SSQSdata(this);
/* 22 */     this.sdatacasted = ((SSQSdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("SSQS (" + this.sectList.size() + " anims)");
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectSSQS.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
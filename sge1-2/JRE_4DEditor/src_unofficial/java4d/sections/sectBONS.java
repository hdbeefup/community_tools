/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.BONSdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectBONS
/*    */   extends sect
/*    */ {
/*    */   protected BONSdata sdatacasted;
/*    */   
/*    */   public sectBONS(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new BONSdata(this);
/* 22 */     this.sdatacasted = ((BONSdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 28 */     return new String("BONS: " + this.sdatacasted.bones.length + " bones");
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectBONS.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
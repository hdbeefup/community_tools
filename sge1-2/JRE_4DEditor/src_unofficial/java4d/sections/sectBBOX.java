/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.BBOXdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectBBOX
/*    */   extends sect
/*    */ {
/*    */   protected BBOXdata sdatacasted;
/*    */   
/*    */   public sectBBOX(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new BBOXdata(this);
/* 22 */     this.sdatacasted = ((BBOXdata)this.sdata);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectBBOX.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.CAM_data;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectCAM_
/*    */   extends sectMESH
/*    */ {
/*    */   public sectCAM_(sect parent)
/*    */   {
/* 18 */     super(parent);
/* 19 */     this.sdata = new CAM_data(this);
/* 20 */     this.sdatacasted = ((CAM_data)this.sdata);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectCAM_.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
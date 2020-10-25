/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.sections.data.DUMYdata;
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
/*    */ 
/*    */ public class sectDUMY
/*    */   extends sectMESH
/*    */ {
/*    */   public sectDUMY(sect parent)
/*    */   {
/* 20 */     super(parent);
/* 21 */     this.sdata = new DUMYdata(this);
/* 22 */     this.sdatacasted = ((DUMYdata)this.sdata);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectDUMY.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
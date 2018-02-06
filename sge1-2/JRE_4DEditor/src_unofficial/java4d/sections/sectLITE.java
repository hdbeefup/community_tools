/*    */ package java4d.sections;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java4d.sections.data.LITEdata;
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
/*    */ public class sectLITE
/*    */   extends sectMESH
/*    */ {
/*    */   public sectLITE(sect parent)
/*    */   {
/* 21 */     super(parent);
/* 22 */     this.sdata = new LITEdata(this);
/* 23 */     this.sdatacasted = ((LITEdata)this.sdata);
/*    */   }
/*    */   
/*    */   public void setSpot(sectSPOT spot)
/*    */   {
/* 28 */     this.sectList = new LinkedList();
/* 29 */     this.sectList.add(spot);
/*    */   }
/*    */   
/*    */   public void setPont(sectPONT pont)
/*    */   {
/* 34 */     this.sectList = new LinkedList();
/* 35 */     this.sectList.add(pont);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectLITE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
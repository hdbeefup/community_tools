/*    */ package java4d.sections;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java4d.sections.data.MTLSdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectMTLS
/*    */   extends sect
/*    */ {
/*    */   protected MTLSdata sdatacasted;
/*    */   
/*    */   public sectMTLS(sect parent)
/*    */   {
/* 21 */     super(parent);
/* 22 */     this.sdata = new MTLSdata(this);
/* 23 */     this.sdatacasted = ((MTLSdata)this.sdata);
/*    */   }
/*    */   
/*    */   public void setMaterial(sectMATE mate)
/*    */   {
/* 28 */     this.sectList = new LinkedList();
/* 29 */     this.sectList.add(mate);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectMTLS.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.sections;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java4d.sections.data.MATEdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectMATE
/*    */   extends sect
/*    */ {
/*    */   protected MATEdata sdatacasted;
/*    */   
/*    */   public sectMATE(sect parent)
/*    */   {
/* 21 */     super(parent);
/* 22 */     this.sdata = new MATEdata(this);
/* 23 */     this.sdatacasted = ((MATEdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 29 */     return new String("MATE on " + this.sdatacasted.indiCount + " triangle(s)");
/*    */   }
/*    */   
/*    */   public void addDiff(sectDIFF d)
/*    */   {
/* 34 */     if (this.sectList == null) this.sectList = new LinkedList();
/* 35 */     if (getChildrenTypeCount(sectDIFF.class) > 0)
/* 36 */       this.sectList.remove(getChildrenType(sectDIFF.class).get(0));
/* 37 */     this.sectList.add(d);
/* 38 */     getEventListener().structureChanged();
/*    */   }
/*    */   
/*    */   public void addSpec(sectDIFF d) {
/* 42 */     if (this.sectList == null) this.sectList = new LinkedList();
/* 43 */     if (getChildrenTypeCount(sectSPEC.class) > 0)
/* 44 */       this.sectList.remove(getChildrenType(sectSPEC.class).get(0));
/* 45 */     this.sectList.add(d);
/* 46 */     getEventListener().structureChanged();
/*    */   }
/*    */   
/*    */   public void addRefl(sectDIFF d) {
/* 50 */     if (this.sectList == null) this.sectList = new LinkedList();
/* 51 */     if (getChildrenTypeCount(sectREFL.class) > 0)
/* 52 */       this.sectList.remove(getChildrenType(sectREFL.class).get(0));
/* 53 */     this.sectList.add(d);
/* 54 */     getEventListener().structureChanged();
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectMATE.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
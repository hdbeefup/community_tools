/*    */ package java4d.sections;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java4d.datatypes.infoLabel;
/*    */ import java4d.sections.data.MESHdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectMESH
/*    */   extends sect
/*    */ {
/*    */   protected MESHdata sdatacasted;
/*    */   
/*    */   public sectMESH(sect parent)
/*    */   {
/* 21 */     super(parent);
/* 22 */     this.sdata = new MESHdata(this);
/* 23 */     this.sdatacasted = ((MESHdata)this.sdata);
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 29 */     String parentEntityName = new String("none");
/* 30 */     if (this.sdatacasted.parentEntityId != -1)
/*    */     {
/* 32 */       LinkedList<sect> l = this.parent.getChildrenTypeAndDerived(sectMESH.class);
/* 33 */       parentEntityName = ((sectMESH)l.get(this.sdatacasted.parentEntityId)).sdatacasted.desc.val;
/*    */     }
/*    */     
/* 36 */     return new String(getClass().getSimpleName().substring(4) + " " + this.sdatacasted.desc.val + " - Parent entity: " + parentEntityName);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 41 */     return this.sdatacasted.desc.val;
/*    */   }
/*    */   
/*    */   public boolean isStripe() {
/* 45 */     sect t = (sect)getChildrenType(sectMTLS.class).get(0);
/* 46 */     return ((sectMTLS)t).getChildrenType(sectSTRP.class) != null;
/*    */   }
/*    */   
/*    */   public void setSubSections(sectBBOX b, sectVERT v, sectINDI i, sectMTLS mtls)
/*    */   {
/* 51 */     if (getClass() == sectMESH.class)
/*    */     {
/* 53 */       this.sectList = new LinkedList();
/* 54 */       this.sectList.add(b);
/* 55 */       this.sectList.add(v);
/* 56 */       this.sectList.add(i);
/* 57 */       this.sectList.add(mtls);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectMESH.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
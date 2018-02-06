/*    */ package java4d.sections;
/*    */ 
/*    */ import java4d.datatypes.myVertex;
/*    */ import java4d.sections.data.Unknowndata;
/*    */ import java4d.sections.data.VERTdata;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectVERT
/*    */   extends sect
/*    */ {
/* 18 */   protected VERTdata sdatacasted = null;
/*    */   
/*    */   public sectVERT(sect parent)
/*    */   {
/* 22 */     super(parent);
/* 23 */     if (parent.getClass() == sectMESH.class)
/*    */     {
/* 25 */       this.sdata = new VERTdata(this);
/* 26 */       this.sdatacasted = ((VERTdata)this.sdata);
/*    */     } else {
/* 28 */       this.sdata = new Unknowndata(this);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public sectVERT(sectMESH parent, int numVertices)
/*    */   {
/* 35 */     this(parent);
/* 36 */     this.sdatacasted.vert = new myVertex[numVertices];
/* 37 */     for (int i = 0; i < this.sdatacasted.vert.length; i++)
/*    */     {
/* 39 */       this.sdatacasted.vert[i] = new myVertex();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTipDetails()
/*    */   {
/* 46 */     return new String("VERT: " + getVertCount() + " vertex(es)");
/*    */   }
/*    */   
/*    */   public int getVertCount()
/*    */   {
/* 51 */     return this.sdatacasted != null ? this.sdatacasted.vert.length : -1;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectVERT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package utilities;
/*    */ 
/*    */ import java4d.sections.sect;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class myNode
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private sect obj;
/*    */   
/*    */   public myNode()
/*    */   {
/* 21 */     this.obj = null;
/*    */   }
/*    */   
/*    */   public myNode(String s) {
/* 25 */     super(s);
/* 26 */     this.obj = null;
/*    */   }
/*    */   
/*    */   public void setSect(sect s) {
/* 30 */     this.obj = s;
/*    */   }
/*    */   
/*    */   public sect getSect() {
/* 34 */     return this.obj;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/utilities/myNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package utilities;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java4d.sections.sect;
/*    */ import javax.swing.JTree;
/*    */ import javax.swing.tree.DefaultTreeModel;
/*    */ import javax.swing.tree.TreeModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectJTreeBuilder
/*    */ {
/*    */   public static void draw(sect root, JTree t)
/*    */   {
/* 15 */     t.setRootVisible(true);
/* 16 */     ((DefaultTreeModel)t.getModel()).setRoot(null);
/* 17 */     t.setModel(new DefaultTreeModel(new myNode("Root")));
/*    */     
/* 19 */     if (root != null) {
/* 20 */       myNode tree = new myNode(root.getTitle());
/* 21 */       ((myNode)t.getModel().getRoot()).add(tree);
/* 22 */       recAdd(root, tree);
/* 23 */       t.expandRow(0);
/* 24 */       t.expandRow(1);
/*    */     }
/*    */     
/* 27 */     t.setRootVisible(false);
/*    */   }
/*    */   
/*    */   private static void recAdd(sect s, myNode n)
/*    */   {
/* 32 */     n.setSect(s);
/* 33 */     n.setUserObject(s.getTitle() + "  ");
/*    */     
/* 35 */     if (s.getChildren() != null) {
/* 36 */       for (int i = 0; i < s.getChildren().size(); i++) {
/* 37 */         myNode k = new myNode();
/* 38 */         n.add(k);
/* 39 */         recAdd((sect)s.getChildren().get(i), k);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/utilities/sectJTreeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
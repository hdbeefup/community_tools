/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.Rectangle;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.sectSCEN;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectMaker
/*    */   extends JFrame
/*    */ {
/*    */   sectSCEN parent;
/*    */   
/*    */   public sectMaker(sectSCEN s_parent)
/*    */   {
/* 21 */     this.parent = s_parent;
/* 22 */     setLocation(myutil.screen.width / 2 - getWidth() / 2, myutil.screen.height / 2 - getHeight() / 2);
/*    */   }
/*    */   
/*    */   public static int getTargetPosition(sectSCEN parent_s)
/*    */   {
/* 27 */     int ret = -1;
/*    */     try {
/* 29 */       int max = parent_s.getLastObjectIndex() - parent_s.getFirstObjectIndex();
/* 30 */       String val = JOptionPane.showInputDialog("Insert the object's position into the list (0 - " + max + ")");
/* 31 */       if (val != null) {
/* 32 */         ret = Integer.decode(val).intValue();
/*    */       }
/*    */     }
/*    */     catch (NumberFormatException ex) {
/* 36 */       ret = -1;
/*    */     }
/* 38 */     return ret;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/sectMaker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
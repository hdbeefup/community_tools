/*    */ package utilities;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.basic.BasicTreeUI;
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
/*    */ 
/*    */ public class myTreeUI
/*    */   extends BasicTreeUI
/*    */ {
/*    */   public boolean lineTypeDashed;
/*    */   
/*    */   public void setHashColor2(Color color)
/*    */   {
/* 26 */     super.setHashColor(color);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void paintVerticalLine(Graphics g, JComponent c, int x, int top, int bottom)
/*    */   {
/* 35 */     if (this.lineTypeDashed) {
/* 36 */       drawDashedVerticalLine(g, x, top, bottom);
/*    */     } else {
/* 38 */       g.drawLine(x, top, x, bottom);
/* 39 */       g.drawLine(x + 1, top, x + 1, bottom);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void paintHorizontalLine(Graphics g, JComponent c, int y, int left, int right)
/*    */   {
/* 50 */     if (this.lineTypeDashed) {
/* 51 */       drawDashedHorizontalLine(g, y, left, right);
/*    */     } else {
/* 53 */       g.drawLine(left, y, right, y);
/* 54 */       g.drawLine(left, y + 1, right, y + 1);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/utilities/myTreeUI.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
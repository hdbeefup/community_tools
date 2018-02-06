/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java4d.sections.data.sectData;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
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
/*    */ public class DUMYeditor
/*    */   extends MESHeditor
/*    */ {
/*    */   public DUMYeditor(sectData toEdit)
/*    */   {
/* 24 */     super(toEdit);
/*    */   }
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
/*    */   private void initComponents()
/*    */   {
/* 38 */     setDefaultCloseOperation(3);
/*    */     
/* 40 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 41 */     getContentPane().setLayout(layout);
/* 42 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, 32767));
/*    */     
/*    */ 
/*    */ 
/* 46 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, 32767));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 51 */     pack();
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/DUMYeditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
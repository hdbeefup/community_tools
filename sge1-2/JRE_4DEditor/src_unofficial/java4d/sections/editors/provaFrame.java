/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import java4d.sections.data.sectData;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.GroupLayout.SequentialGroup;
/*    */ import javax.swing.JButton;
/*    */ 
/*    */ 
/*    */ public class provaFrame
/*    */   extends sectEditor
/*    */ {
/*    */   private ButtonGroup buttonGroup1;
/*    */   private JButton jButton1;
/*    */   
/*    */   public provaFrame(sectData toEdit)
/*    */   {
/* 25 */     super(toEdit);
/* 26 */     initComponents();
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
/* 40 */     this.buttonGroup1 = new ButtonGroup();
/* 41 */     this.jButton1 = new JButton();
/*    */     
/* 43 */     setDefaultCloseOperation(2);
/* 44 */     addWindowListener(new WindowAdapter() {
/*    */       public void windowClosed(WindowEvent evt) {
/* 46 */         provaFrame.this.formWindowClosed(evt);
/*    */       }
/*    */       
/* 49 */     });
/* 50 */     this.jButton1.setText("jButton1");
/* 51 */     this.jButton1.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 53 */         provaFrame.this.jButton1ActionPerformed(evt);
/*    */       }
/*    */       
/* 56 */     });
/* 57 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 58 */     getContentPane().setLayout(layout);
/* 59 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(284, 32767).addComponent(this.jButton1).addContainerGap()));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 66 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(228, 32767).addComponent(this.jButton1).addContainerGap()));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 74 */     pack();
/*    */   }
/*    */   
/*    */   private void jButton1ActionPerformed(ActionEvent evt)
/*    */   {
/* 79 */     dispose();
/*    */   }
/*    */   
/*    */   private void formWindowClosed(WindowEvent evt) {}
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/provaFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
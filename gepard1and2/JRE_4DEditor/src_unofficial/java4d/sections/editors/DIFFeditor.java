/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.data.DIFFdata;
/*    */ import java4d.sections.data.sectData;
/*    */ import javax.swing.BoxLayout;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.GroupLayout.SequentialGroup;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class DIFFeditor extends sectEditor
/*    */ {
/*    */   DIFFdata diffdata;
/*    */   private JButton jButton1;
/*    */   private JPanel jPanel1;
/*    */   
/*    */   public DIFFeditor(sectData toEdit)
/*    */   {
/* 26 */     super(toEdit);
/* 27 */     initComponents();
/* 28 */     this.diffdata = ((DIFFdata)toEdit);
/* 29 */     this.jPanel1.add(this.diffdata.desc.getEditor());
/* 30 */     setBounds(0, 400, 230, 150);
/* 31 */     setLocation(myutil.screen.width / 2 - getWidth() / 2, myutil.screen.height / 2 - getHeight() / 2);
/*    */   }
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
/* 43 */     this.jPanel1 = new JPanel();
/* 44 */     this.jButton1 = new JButton();
/*    */     
/* 46 */     setDefaultCloseOperation(2);
/*    */     
/* 48 */     this.jPanel1.setLayout(new BoxLayout(this.jPanel1, 2));
/*    */     
/* 50 */     this.jButton1.setText("Ok");
/* 51 */     this.jButton1.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 53 */         DIFFeditor.this.jButton1ActionPerformed(evt);
/*    */       }
/*    */       
/* 56 */     });
/* 57 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 58 */     getContentPane().setLayout(layout);
/* 59 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -2, 81, -2).addComponent(this.jPanel1, -1, 316, 32767)).addContainerGap()));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 68 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 60, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addContainerGap(-1, 32767)));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 78 */     pack();
/*    */   }
/*    */   
/*    */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 82 */     dispose();
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/DIFFeditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
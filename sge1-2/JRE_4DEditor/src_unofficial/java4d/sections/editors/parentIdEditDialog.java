/*     */ package java4d.sections.editors;
/*     */ 
/*     */ import java.awt.Frame;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java4d.myutil;
/*     */ import java4d.sections.data.MESHdata;
/*     */ import java4d.sections.sect;
/*     */ import java4d.sections.sectMESH;
/*     */ import java4d.sections.sectSCEN;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.ListModel;
/*     */ 
/*     */ public class parentIdEditDialog extends JDialog
/*     */ {
/*     */   MESHdata sdata;
/*     */   java.util.LinkedList<sectMESH> meshlist;
/*  29 */   private boolean cancelled = false;
/*     */   private JButton jButton1;
/*     */   
/*  32 */   private parentIdEditDialog(Frame parent, boolean modal) { super(parent, modal);
/*  33 */     initComponents();
/*  34 */     setLocation(myutil.screen.width / 2 - getWidth() / 2, myutil.screen.height / 2 - getHeight() / 2);
/*     */   }
/*     */   
/*     */   public parentIdEditDialog(Frame parent, boolean modal, MESHdata s_data) {
/*  38 */     this(parent, modal);
/*  39 */     this.sdata = s_data;
/*  40 */     sectSCEN scen = (sectSCEN)this.sdata.getOwner().getParent();
/*     */     
/*  42 */     this.meshlist = ((sectSCEN)this.sdata.getOwner().getParent()).getValidParents((sectMESH)this.sdata.getOwner());
/*  43 */     this.jList1.setModel(new DefaultListModel());
/*     */     
/*  45 */     ((DefaultListModel)this.jList1.getModel()).addElement("- No parent id -");
/*     */     
/*  47 */     for (sectMESH m : this.meshlist)
/*     */     {
/*  49 */       ((DefaultListModel)this.jList1.getModel()).addElement(m);
/*  50 */       if (scen.getEntityId(m) == this.sdata.parentEntityId)
/*     */       {
/*  52 */         this.jList1.setSelectedIndex(this.jList1.getModel().getSize() - 1);
/*     */       }
/*     */     }
/*  55 */     if (this.jList1.getSelectedIndex() == -1) {
/*  56 */       this.jList1.setSelectedIndex(0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private JButton jButton2;
/*     */   
/*     */   private JLabel jLabel1;
/*     */   
/*     */   private JList jList1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private void initComponents()
/*     */   {
/*  69 */     this.jLabel1 = new JLabel();
/*  70 */     this.jScrollPane1 = new JScrollPane();
/*  71 */     this.jList1 = new JList();
/*  72 */     this.jButton1 = new JButton();
/*  73 */     this.jButton2 = new JButton();
/*     */     
/*  75 */     setDefaultCloseOperation(0);
/*  76 */     setModal(true);
/*     */     
/*  78 */     this.jLabel1.setText("Select a parent entity for this object:");
/*     */     
/*  80 */     this.jList1.setSelectionMode(0);
/*  81 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */     
/*  83 */     this.jButton1.setText("Ok");
/*  84 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  86 */         parentIdEditDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  89 */     });
/*  90 */     this.jButton2.setText("Cancel");
/*  91 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  93 */         parentIdEditDialog.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  96 */     });
/*  97 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  98 */     getContentPane().setLayout(layout);
/*  99 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 311, 32767).addComponent(this.jLabel1).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton1, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 80, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 153, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 130 */     if (this.jList1.getSelectedIndex() == 0)
/*     */     {
/* 132 */       this.sdata.parentEntityId = -1;
/*     */     }
/*     */     else {
/* 135 */       sectMESH sel = (sectMESH)this.jList1.getModel().getElementAt(this.jList1.getSelectedIndex());
/* 136 */       this.sdata.parentEntityId = ((sectSCEN)sel.getParent()).getEntityId(sel);
/*     */     }
/* 138 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 143 */     this.cancelled = true;
/* 144 */     dispose();
/*     */   }
/*     */   
/*     */   public boolean hasCancelled()
/*     */   {
/* 149 */     return this.cancelled;
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/parentIdEditDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
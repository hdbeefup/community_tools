/*     */ package java4d.sections.editors;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java4d.sections.data.MESHdata;
/*     */ import java4d.sections.data.sectData;
/*     */ import java4d.sections.sect;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ 
/*     */ public class MESHeditor extends sectEditor
/*     */ {
/*     */   MESHdata meshdata;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   protected JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   public MESHeditor(sectData toEdit)
/*     */   {
/*  26 */     super(toEdit);
/*  27 */     initComponents();
/*  28 */     this.meshdata = ((MESHdata)this.sdata);
/*  29 */     this.jPanel1.add(this.meshdata.desc.getEditor());
/*  30 */     this.jPanel1.add(this.meshdata.space.getEditor());
/*  31 */     setTitle(this.meshdata.getOwner().getTipDetails());
/*  32 */     setBounds(getX() - getWidth() / 2, getY() - getHeight() / 2, 350, 350);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  44 */     this.jButton1 = new JButton();
/*  45 */     this.jButton2 = new JButton();
/*  46 */     this.jScrollPane1 = new JScrollPane();
/*  47 */     this.jPanel1 = new JPanel();
/*     */     
/*  49 */     setDefaultCloseOperation(2);
/*     */     
/*  51 */     this.jButton1.setText("Ok");
/*  52 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  54 */         MESHeditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  57 */     });
/*  58 */     this.jButton2.setText("Select Parent Entity...");
/*  59 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  61 */         MESHeditor.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  64 */     });
/*  65 */     this.jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  67 */         MESHeditor.this.jPanel1PropertyChange(evt);
/*     */       }
/*  69 */     });
/*  70 */     this.jPanel1.setLayout(new javax.swing.BoxLayout(this.jPanel1, 3));
/*  71 */     this.jScrollPane1.setViewportView(this.jPanel1);
/*     */     
/*  73 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  74 */     getContentPane().setLayout(layout);
/*  75 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 347, 32767).addComponent(this.jButton2, -2, 182, -2).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -2, 96, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  85 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 186, 32767).addGap(11, 11, 11).addComponent(this.jButton1).addContainerGap()));
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
/*  97 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 101 */     dispose();
/*     */   }
/*     */   
/*     */   private void jPanel1PropertyChange(PropertyChangeEvent evt) {
/* 105 */     if (evt.getPropertyName().matches("renderer"))
/*     */     {
/* 107 */       if (this.sdata.getOwner().getEventListener() != null)
/* 108 */         this.sdata.getOwner().getEventListener().dataChanged();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 113 */     parentIdEditDialog ed1 = new parentIdEditDialog(this, true, this.meshdata);
/* 114 */     ed1.setVisible(true);
/* 115 */     if (this.sdata.getOwner().getEventListener() != null)
/* 116 */       this.sdata.getOwner().getEventListener().dataChanged();
/* 117 */     setTitle(this.meshdata.getOwner().getTipDetails());
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/MESHeditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
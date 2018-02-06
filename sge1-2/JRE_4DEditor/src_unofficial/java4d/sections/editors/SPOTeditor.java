/*     */ package java4d.sections.editors;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JSpinner;
/*     */ 
/*     */ public class SPOTeditor extends sectEditor
/*     */ {
/*     */   java4d.sections.data.SPOTdata data;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JSpinner jSpinner1;
/*     */   private JSpinner jSpinner2;
/*     */   private JSpinner jSpinner3;
/*     */   private JSpinner jSpinner4;
/*     */   private JSpinner jSpinner5;
/*     */   private JSpinner jSpinner6;
/*     */   
/*     */   public SPOTeditor(java4d.sections.data.sectData toEdit)
/*     */   {
/*  28 */     super(toEdit);
/*  29 */     initComponents();
/*  30 */     this.data = ((java4d.sections.data.SPOTdata)toEdit);
/*  31 */     this.jSpinner1.setValue(Float.valueOf(this.data.coneLen));
/*  32 */     this.jSpinner2.setValue(Float.valueOf((int)(this.data.spotCutoff * 180.0F / 3.1415927F)));
/*  33 */     this.jSpinner3.setValue(Float.valueOf(this.data.constantAtt));
/*  34 */     this.jSpinner4.setValue(Float.valueOf(this.data.lineartAtt * 100.0F));
/*  35 */     this.jSpinner5.setValue(Float.valueOf(this.data.quadraticAtt * 10000.0F));
/*  36 */     this.jSpinner6.setValue(Float.valueOf(this.data.spotExp));
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
/*  48 */     this.jButton1 = new javax.swing.JButton();
/*  49 */     this.jSpinner1 = new JSpinner();
/*  50 */     this.jLabel1 = new javax.swing.JLabel();
/*  51 */     this.jSpinner2 = new JSpinner();
/*  52 */     this.jLabel2 = new javax.swing.JLabel();
/*  53 */     this.jPanel1 = new javax.swing.JPanel();
/*  54 */     this.jLabel3 = new javax.swing.JLabel();
/*  55 */     this.jLabel4 = new javax.swing.JLabel();
/*  56 */     this.jLabel5 = new javax.swing.JLabel();
/*  57 */     this.jSpinner3 = new JSpinner();
/*  58 */     this.jSpinner4 = new JSpinner();
/*  59 */     this.jSpinner5 = new JSpinner();
/*  60 */     this.jLabel6 = new javax.swing.JLabel();
/*  61 */     this.jSpinner6 = new JSpinner();
/*     */     
/*  63 */     setDefaultCloseOperation(2);
/*  64 */     setResizable(false);
/*     */     
/*  66 */     this.jButton1.setText("Ok");
/*  67 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  69 */         SPOTeditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  72 */     });
/*  73 */     this.jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), null, Float.valueOf(1.0F)));
/*  74 */     this.jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/*  76 */         SPOTeditor.this.jSpinner1StateChanged(evt);
/*     */       }
/*     */       
/*  79 */     });
/*  80 */     this.jLabel1.setText("Cone length:");
/*     */     
/*  82 */     this.jSpinner2.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0F), Float.valueOf(0.0F), Float.valueOf(89.0F), Float.valueOf(1.0F)));
/*  83 */     this.jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/*  85 */         SPOTeditor.this.jSpinner2StateChanged(evt);
/*     */       }
/*     */       
/*  88 */     });
/*  89 */     this.jLabel2.setText("Cone angle:");
/*     */     
/*  91 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Attenuations"));
/*     */     
/*  93 */     this.jLabel3.setText("Constant:");
/*     */     
/*  95 */     this.jLabel4.setText("Linear:");
/*     */     
/*  97 */     this.jLabel5.setText("Quadratic:");
/*     */     
/*  99 */     this.jSpinner3.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), null, Float.valueOf(0.01F)));
/* 100 */     this.jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 102 */         SPOTeditor.this.jSpinner3StateChanged(evt);
/*     */       }
/*     */       
/* 105 */     });
/* 106 */     this.jSpinner4.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), null, Float.valueOf(0.01F)));
/* 107 */     this.jSpinner4.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 109 */         SPOTeditor.this.jSpinner4StateChanged(evt);
/*     */       }
/*     */       
/* 112 */     });
/* 113 */     this.jSpinner5.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), null, Float.valueOf(0.01F)));
/* 114 */     this.jSpinner5.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 116 */         SPOTeditor.this.jSpinner5StateChanged(evt);
/*     */       }
/*     */       
/* 119 */     });
/* 120 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 121 */     this.jPanel1.setLayout(jPanel1Layout);
/* 122 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jSpinner3, -2, 75, -2).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jSpinner4, -2, 75, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jSpinner5, -2, 75, -2)).addContainerGap(17, 32767)));
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
/*     */ 
/*     */ 
/*     */ 
/* 139 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel5).addComponent(this.jLabel4)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jSpinner3, -2, -1, -2).addComponent(this.jSpinner4, -2, -1, -2).addComponent(this.jSpinner5, -2, -1, -2)).addContainerGap(24, 32767)));
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
/*     */ 
/*     */ 
/* 155 */     this.jLabel6.setText("Concentration:");
/*     */     
/* 157 */     this.jSpinner6.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), null, Float.valueOf(0.05F)));
/* 158 */     this.jSpinner6.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 160 */         SPOTeditor.this.jSpinner6StateChanged(evt);
/*     */       }
/*     */       
/* 163 */     });
/* 164 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 165 */     getContentPane().setLayout(layout);
/* 166 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jSpinner1, -2, 72, -2).addComponent(this.jLabel1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jSpinner2, -2, 75, -2).addComponent(this.jLabel2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.jSpinner6, -2, 72, -2))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(21, 32767)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(201, 32767).addComponent(this.jButton1, -2, 96, -2).addContainerGap()));
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
/* 192 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jSpinner1, -2, -1, -2).addComponent(this.jSpinner2, -2, -1, -2).addComponent(this.jSpinner6, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addContainerGap(-1, 32767)));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 212 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 216 */     dispose();
/*     */   }
/*     */   
/*     */   private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {
/* 220 */     this.data.coneLen = ((Float)((javax.swing.SpinnerNumberModel)this.jSpinner1.getModel()).getValue()).floatValue();
/* 221 */     this.data.getOwner().getEventListener().dataChanged();
/*     */   }
/*     */   
/*     */   private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt)
/*     */   {
/* 226 */     this.data.spotCutoff = (((Float)((javax.swing.SpinnerNumberModel)this.jSpinner2.getModel()).getValue()).floatValue() / 180.0F * 3.1415927F);
/* 227 */     this.data.getOwner().getEventListener().dataChanged();
/*     */   }
/*     */   
/*     */   private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {
/* 231 */     this.data.constantAtt = ((Float)((javax.swing.SpinnerNumberModel)this.jSpinner3.getModel()).getValue()).floatValue();
/*     */   }
/*     */   
/*     */   private void jSpinner4StateChanged(javax.swing.event.ChangeEvent evt) {
/* 235 */     this.data.lineartAtt = (((Float)((javax.swing.SpinnerNumberModel)this.jSpinner4.getModel()).getValue()).floatValue() / 100.0F);
/*     */   }
/*     */   
/*     */   private void jSpinner5StateChanged(javax.swing.event.ChangeEvent evt) {
/* 239 */     this.data.quadraticAtt = (((Float)((javax.swing.SpinnerNumberModel)this.jSpinner5.getModel()).getValue()).floatValue() / 10000.0F);
/*     */   }
/*     */   
/*     */   private void jSpinner6StateChanged(javax.swing.event.ChangeEvent evt) {
/* 243 */     this.data.spotExp = ((Float)((javax.swing.SpinnerNumberModel)this.jSpinner6.getModel()).getValue()).floatValue();
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/SPOTeditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package java4d.sections.editors;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java4d.sections.sectLITE;
/*     */ import java4d.sections.sectSCEN;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class LITEmaker extends sectMaker
/*     */ {
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JRadioButton jRadioButton1;
/*     */   private JRadioButton jRadioButton2;
/*     */   private JSpinner jSpinner1;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   
/*     */   public LITEmaker(sectSCEN s_parent)
/*     */   {
/*  33 */     super(s_parent);
/*  34 */     initComponents();
/*     */   }
/*     */   
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
/*  47 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  48 */     this.jLabel1 = new JLabel();
/*  49 */     this.jTextField1 = new javax.swing.JTextField();
/*  50 */     this.jButton1 = new JButton();
/*  51 */     this.jPanel1 = new JPanel();
/*  52 */     this.jRadioButton1 = new JRadioButton();
/*  53 */     this.jRadioButton2 = new JRadioButton();
/*  54 */     this.jButton2 = new JButton();
/*  55 */     this.jButton3 = new JButton();
/*  56 */     this.jLabel2 = new JLabel();
/*  57 */     this.jSpinner1 = new JSpinner();
/*     */     
/*  59 */     setDefaultCloseOperation(2);
/*  60 */     setTitle("New LITE object");
/*  61 */     setResizable(false);
/*     */     
/*  63 */     this.jLabel1.setText("Description:");
/*     */     
/*  65 */     this.jTextField1.setText("new_lite");
/*     */     
/*  67 */     this.jButton1.setText("Select Light color");
/*  68 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  70 */         LITEmaker.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  73 */     });
/*  74 */     this.jPanel1.setBackground(new java.awt.Color(255, 255, 255));
/*  75 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
/*     */     
/*  77 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  78 */     this.jPanel1.setLayout(jPanel1Layout);
/*  79 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 22, 32767));
/*     */     
/*     */ 
/*     */ 
/*  83 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 19, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  88 */     this.buttonGroup1.add(this.jRadioButton1);
/*  89 */     this.jRadioButton1.setSelected(true);
/*  90 */     this.jRadioButton1.setText("Spot Light (cone)");
/*     */     
/*  92 */     this.buttonGroup1.add(this.jRadioButton2);
/*  93 */     this.jRadioButton2.setText("Omnidirectional Light (ball)");
/*  94 */     this.jRadioButton2.setEnabled(false);
/*     */     
/*  96 */     this.jButton2.setText("Ok");
/*  97 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  99 */         LITEmaker.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 102 */     });
/* 103 */     this.jButton3.setText("Cancel");
/* 104 */     this.jButton3.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 106 */         LITEmaker.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */       
/* 109 */     });
/* 110 */     this.jLabel2.setText("Light intensity:");
/*     */     
/* 112 */     this.jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(5.0F), Float.valueOf(0.05F)));
/* 113 */     this.jSpinner1.setValue(Float.valueOf(1.0F));
/*     */     
/* 115 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 116 */     getContentPane().setLayout(layout);
/* 117 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton2).addComponent(this.jRadioButton1).addComponent(this.jTextField1, -1, 231, 32767).addComponent(this.jLabel1).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton1, -1, 199, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 69, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jSpinner1, GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap()));
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
/* 139 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSpinner1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRadioButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRadioButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton3)).addContainerGap()));
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
/* 165 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 172 */     sectLITE section = new sectLITE(this.parent);
/* 173 */     java4d.sections.data.LITEdata data = new java4d.sections.data.LITEdata(section);
/* 174 */     data.desc.val = this.jTextField1.getText();
/* 175 */     data.space.versors[0].val[0] = 1.0F;
/* 176 */     data.space.versors[1].val[1] = 1.0F;
/* 177 */     data.space.versors[2].val[2] = 1.0F;
/* 178 */     data.lightColor.val[0] = this.jPanel1.getBackground().getRGBComponents(null)[0];
/* 179 */     data.lightColor.val[1] = this.jPanel1.getBackground().getRGBComponents(null)[1];
/* 180 */     data.lightColor.val[2] = this.jPanel1.getBackground().getRGBComponents(null)[2];
/* 181 */     data.lightMult = ((Float)((javax.swing.SpinnerNumberModel)this.jSpinner1.getModel()).getValue()).floatValue();
/* 182 */     data.version = new String("v100");
/*     */     
/* 184 */     parentIdEditDialog ed1 = new parentIdEditDialog(this, true, data);
/* 185 */     ed1.setVisible(true);
/* 186 */     if (ed1.hasCancelled()) return;
/* 187 */     if (this.jRadioButton1.isSelected())
/*     */     {
/* 189 */       section.setSpot(new java4d.sections.sectSPOT(section));
/*     */     } else {
/* 191 */       section.setPont(new java4d.sections.sectPONT(section));
/*     */     }
/* 193 */     section.getSectionData().copyFrom(data);
/* 194 */     int targetpos = getTargetPosition(this.parent);
/*     */     
/* 196 */     if (targetpos < 0) return;
/* 197 */     this.parent.addObjectAt(section, targetpos);
/* 198 */     this.parent.getEventListener().structureChanged();
/* 199 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 204 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 208 */     this.jPanel1.setBackground(javax.swing.JColorChooser.showDialog(this, "Choose a color", this.jPanel1.getBackground()));
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/LITEmaker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package java4d.sections.editors;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java4d.sections.data.LITEdata;
/*     */ import java4d.sections.data.sectData;
/*     */ import java4d.sections.sect;
/*     */ import java4d.sections.sectEventListener;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JColorChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LITEeditor
/*     */   extends MESHeditor
/*     */ {
/*     */   LITEdata litedata;
/*     */   
/*     */   public LITEeditor(sectData toEdit)
/*     */   {
/*  38 */     super(toEdit);
/*     */     
/*  40 */     this.litedata = ((LITEdata)this.sdata);
/*  41 */     JPanel p = new JPanel();
/*  42 */     JPanel p1 = new JPanel();
/*  43 */     p.setLayout(new BoxLayout(p, 1));
/*  44 */     p1.setLayout(new BoxLayout(p1, 3));
/*     */     
/*     */ 
/*  47 */     this.jPanel1.add(new JLabel("Light color:"));
/*     */     
/*  49 */     JButton selcolorBtn = new JButton("Select light color");
/*  50 */     this.jPanel1.add(selcolorBtn);
/*     */     
/*  52 */     selcolorBtn.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  54 */         Color curcolor = new Color(LITEeditor.this.litedata.lightColor.val[0], LITEeditor.this.litedata.lightColor.val[1], LITEeditor.this.litedata.lightColor.val[2]);
/*  55 */         curcolor = JColorChooser.showDialog(LITEeditor.this.jPanel1, null, curcolor);
/*  56 */         if (curcolor != null)
/*     */         {
/*  58 */           LITEeditor.this.litedata.lightColor.val = curcolor.getRGBColorComponents(null);
/*  59 */           LITEeditor.this.sdata.getOwner().getEventListener().dataChanged();
/*     */         }
/*     */       }
/*  62 */     });
/*  63 */     JLabel l = new JLabel("Light intensity:");
/*  64 */     l.setMinimumSize(new Dimension(10000, 16));
/*     */     
/*  66 */     p1.add(l);
/*  67 */     final JSpinner jSpinner1 = new JSpinner();
/*  68 */     jSpinner1.setModel(new SpinnerNumberModel(Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(5.0F), Float.valueOf(0.05F)));
/*  69 */     jSpinner1.setValue(Float.valueOf(this.litedata.lightMult));
/*  70 */     jSpinner1.setMaximumSize(new Dimension(150, (int)jSpinner1.getMinimumSize().getHeight()));
/*  71 */     jSpinner1.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/*  73 */         LITEeditor.this.litedata.lightMult = ((Float)((SpinnerNumberModel)jSpinner1.getModel()).getValue()).floatValue();
/*     */       }
/*     */       
/*  76 */     });
/*  77 */     p1.add(jSpinner1);
/*     */     
/*     */ 
/*  80 */     p.add(p1);
/*  81 */     this.jPanel1.add(p);
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
/*  93 */     setDefaultCloseOperation(2);
/*     */     
/*  95 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  96 */     getContentPane().setLayout(layout);
/*  97 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 323, 32767));
/*     */     
/*     */ 
/*     */ 
/* 101 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 246, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 106 */     pack();
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/LITEeditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package pakfile;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsDevice;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java4d.myutil;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class NewJFrame extends JFrame
/*     */ {
/*     */   pakFileList l;
/*     */   NewJDialog pan;
/*     */   pakFileListener ls;
/*  30 */   final Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   
/*  34 */   public NewJFrame() { initComponents();
/*  35 */     this.pan = new NewJDialog(this, true);
/*  36 */     this.pan.setVisible(false);
/*  37 */     this.ls = new pakFileListener()
/*     */     {
/*     */ 
/*     */       public void writeIsAdvancing(long val)
/*     */       {
/*  42 */         NewJFrame.this.pan.setValue(val, "Writing file...");
/*     */       }
/*     */       
/*     */ 
/*     */       public void readIsAdvancing(long val)
/*     */       {
/*  48 */         NewJFrame.this.pan.setValue(val, "Reading files...");
/*     */       }
/*     */       
/*     */ 
/*     */       public void writeStarted()
/*     */       {
/*  54 */         NewJFrame.this.pan.setValue(0L, "Writing file...");
/*  55 */         NewJFrame.this.pan.setVisible(true);
/*     */       }
/*     */       
/*     */       public void writeStopped()
/*     */       {
/*  60 */         NewJFrame.this.pan.setVisible(false);
/*     */       }
/*     */       
/*     */       public void readStarted()
/*     */       {
/*  65 */         NewJFrame.this.pan.setValue(0L, "Reading files...");
/*  66 */         NewJFrame.this.pan.setVisible(true);
/*     */       }
/*     */       
/*     */       public void readStopped()
/*     */       {
/*  71 */         NewJFrame.this.pan.setVisible(false);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JLabel jLabel1;
/*     */   
/*     */ 
/*     */   private JLabel jLabel2;
/*     */   
/*     */   private JPanel jPanel1;
/*     */   
/*     */   private void initComponents()
/*     */   {
/*  87 */     this.jButton1 = new JButton();
/*  88 */     this.jButton2 = new JButton();
/*  89 */     this.jPanel1 = new JPanel();
/*  90 */     this.jLabel1 = new JLabel();
/*  91 */     this.jLabel2 = new JLabel();
/*     */     
/*  93 */     setDefaultCloseOperation(3);
/*  94 */     setResizable(false);
/*     */     
/*  96 */     this.jButton1.setText("Open directory");
/*  97 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  99 */         NewJFrame.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 102 */     });
/* 103 */     this.jButton2.setText("Write PAK file");
/* 104 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 106 */         NewJFrame.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 109 */     });
/* 110 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 112 */     this.jLabel1.setText("-");
/*     */     
/* 114 */     this.jLabel2.setText("-");
/*     */     
/* 116 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 117 */     this.jPanel1.setLayout(jPanel1Layout);
/* 118 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, 249, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 249, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 138 */     getContentPane().setLayout(layout);
/* 139 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton1, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jButton2, -2, 126, -2))).addContainerGap()));
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
/* 151 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
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
/* 163 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 168 */     JFileChooser chooser = new JFileChooser();
/* 169 */     chooser.setFileSelectionMode(1);
/* 170 */     int returnVal = chooser.showOpenDialog(this);
/*     */     
/*     */ 
/*     */ 
/* 174 */     if (returnVal == 0) {
/* 175 */       this.l = new pakFileList(chooser.getSelectedFile(), this.ls);
/*     */       
/* 177 */       long size = this.l.getFilesDataSize();
/* 178 */       this.jLabel1.setText("Record count: " + this.l.getRecordCount());
/* 179 */       this.jLabel2.setText("Total size: " + (this.l.getNamesSize() + this.l.getFilesDataSize() + 16L));
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 185 */     if (this.l != null) {
/* 186 */       File fout = myutil.fileSave(this, "Stormregion Pack Files", "pak");
/* 187 */       this.l.writeFile(fout);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 197 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 199 */         new NewJFrame().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/pakfile/NewJFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
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
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class NewJFrame
/*     */   extends JFrame
/*     */ {
/*  31 */   String lastpathload = null;
/*     */   pakFileList l;
/*     */   NewJDialog pan;
/*     */   pakFileListener ls;
/*  35 */   final Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   
/*  39 */   public NewJFrame() { initComponents();
/*  40 */     this.pan = new NewJDialog(this, true);
/*  41 */     this.pan.setVisible(false);
/*  42 */     this.ls = new pakFileListener()
/*     */     {
/*     */       public void writeIsAdvancing(long val, String msg)
/*     */       {
/*  46 */         NewJFrame.this.pan.setValue(val, msg);
/*     */       }
/*     */       
/*     */ 
/*     */       public void readIsAdvancing(long val, String msg)
/*     */       {
/*  52 */         NewJFrame.this.pan.setValue(val, msg);
/*     */       }
/*     */       
/*     */ 
/*     */       public void writeStarted()
/*     */       {
/*  58 */         NewJFrame.this.pan.setValue(0L, "Writing file...");
/*  59 */         NewJFrame.this.pan.setButtonEnabled(false);
/*  60 */         NewJFrame.this.pan.setVisible(true);
/*     */       }
/*     */       
/*     */       public void writeStopped()
/*     */       {
/*  65 */         NewJFrame.this.pan.setValue(100L, "File write completed!");
/*  66 */         NewJFrame.this.pan.setButtonEnabled(true);
/*     */       }
/*     */       
/*     */ 
/*     */       public void readStarted()
/*     */       {
/*  72 */         NewJFrame.this.pan.setValue(0L, "Reading files...");
/*  73 */         NewJFrame.this.pan.setButtonEnabled(false);
/*  74 */         NewJFrame.this.pan.setVisible(true);
/*     */       }
/*     */       
/*     */       public void readStopped()
/*     */       {
/*  79 */         NewJFrame.this.pan.setValue(100L, "File read completed!");
/*  80 */         NewJFrame.this.pan.setButtonEnabled(true);
/*     */       }
/*     */       
/*     */       public void aborted(String msg)
/*     */       {
/*  85 */         NewJFrame.this.pan.setValue(0L, msg);
/*  86 */         NewJFrame.this.pan.setButtonEnabled(true);
/*     */       }
/*     */       
/*  89 */     };
/*  90 */     setIconImage(IconFactory.getIcon("icona1.png").getImage());
/*  91 */     setLocation(this.screen.width / 2 - getWidth() / 2, this.screen.height / 2 - getHeight() / 2);
/*     */   }
/*     */   
/*     */ 
/*     */   private JButton jButton3;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JTextField jTextField1;
/*     */   private void initComponents()
/*     */   {
/* 103 */     this.jButton1 = new JButton();
/* 104 */     this.jButton2 = new JButton();
/* 105 */     this.jPanel1 = new JPanel();
/* 106 */     this.jLabel1 = new JLabel();
/* 107 */     this.jLabel2 = new JLabel();
/* 108 */     this.jTextField1 = new JTextField();
/* 109 */     this.jCheckBox1 = new JCheckBox();
/* 110 */     this.jButton3 = new JButton();
/*     */     
/* 112 */     setDefaultCloseOperation(3);
/* 113 */     setTitle("Panzers Packer v1.3");
/* 114 */     setResizable(false);
/*     */     
/* 116 */     this.jButton1.setText("Open directory");
/* 117 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 119 */         NewJFrame.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 122 */     });
/* 123 */     this.jButton2.setText("Write PAK file");
/* 124 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 126 */         NewJFrame.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 129 */     });
/* 130 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*     */     
/* 132 */     this.jLabel1.setText("-");
/*     */     
/* 134 */     this.jLabel2.setText("-");
/*     */     
/* 136 */     this.jTextField1.setEditable(false);
/* 137 */     this.jTextField1.setText("-");
/*     */     
/* 139 */     this.jCheckBox1.setText("Use Encryption");
/* 140 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 142 */         NewJFrame.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */       
/* 145 */     });
/* 146 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 147 */     this.jPanel1.setLayout(jPanel1Layout);
/* 148 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCheckBox1).addComponent(this.jLabel1, -1, 249, 32767).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING, -1, 249, 32767).addComponent(this.jTextField1, -1, 249, 32767)).addContainerGap()));
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
/* 159 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jTextField1, -2, -1, -2).addGap(11, 11, 11).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.jCheckBox1).addContainerGap()));
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
/* 173 */     this.jButton3.setText("Decrypt a PAK file...");
/* 174 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 176 */         NewJFrame.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */       
/* 179 */     });
/* 180 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 181 */     getContentPane().setLayout(layout);
/* 182 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jButton2, -2, 126, -2)).addComponent(this.jButton3, GroupLayout.Alignment.LEADING, -2, 166, -2)).addContainerGap()));
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
/* 195 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3).addContainerGap()));
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
/* 209 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 214 */     if (this.l != null) {
/* 215 */       int choice = JOptionPane.showOptionDialog(this, "Discard current loaded directory?", "Confirm", 0, 2, null, null, null);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 220 */       if (choice != 0) {
/* 221 */         return;
/*     */       }
/*     */     }
/* 224 */     JFileChooser chooser = new JFileChooser();
/* 225 */     chooser.setFileSelectionMode(1);
/* 226 */     chooser.setCurrentDirectory(this.lastpathload != null ? new File(this.lastpathload) : null);
/* 227 */     int returnVal = chooser.showOpenDialog(this);
/*     */     
/* 229 */     if (returnVal == 0) {
/* 230 */       this.lastpathload = chooser.getSelectedFile().getPath();
/* 231 */       this.l = new pakFileList(chooser.getSelectedFile(), this.ls);
/* 232 */       this.jTextField1.setText(chooser.getSelectedFile().getPath());
/* 233 */       this.jLabel1.setText(String.format("Record count: %,d", new Object[] { Integer.valueOf(this.l.getRecordCount()) }));
/* 234 */       this.jLabel2.setText(String.format("Data size: %,d", new Object[] { Long.valueOf(this.l.getFilesDataSize() / 1024L) }) + " KB");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/* 241 */     if (this.l != null) {
/* 242 */       File fout = myutil.fileSave(this, "Stormregion Pack Files", "pak");
/* 243 */       this.l.writeFile(fout, this.jCheckBox1.isSelected());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 255 */     File fout = myutil.fileOpen(this, "Stormregion Pack Files", "pak");
/* 256 */     if (fout != null) {
/* 257 */       pakFileList.decryptFile(fout, this.ls);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 266 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 268 */         new NewJFrame().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/NewJFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
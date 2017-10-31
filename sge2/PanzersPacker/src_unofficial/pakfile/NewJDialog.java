/*     */ package pakfile;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class NewJDialog extends JDialog
/*     */ {
/*  23 */   private final Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   
/*  27 */   public NewJDialog(Frame parent, boolean modal) { super(parent, modal);
/*  28 */     initComponents();
/*  29 */     this.jProgressBar1.setMaximum(100);
/*  30 */     setLocation(this.screen.width / 2 - getWidth() / 2, this.screen.height / 2 - getHeight() / 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValue(long val, String msg)
/*     */   {
/*  37 */     this.jLabel1.setText(msg);
/*     */     
/*  39 */     this.jProgressBar1.setValue((int)val);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setButtonEnabled(boolean val)
/*     */   {
/*  45 */     this.jButton1.setEnabled(val);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JPanel jPanel1;
/*     */   
/*     */ 
/*     */   private JProgressBar jProgressBar1;
/*     */   
/*     */   private void initComponents()
/*     */   {
/*  57 */     this.jPanel1 = new JPanel();
/*  58 */     this.jLabel1 = new JLabel();
/*  59 */     this.jProgressBar1 = new JProgressBar();
/*  60 */     this.jButton1 = new JButton();
/*     */     
/*  62 */     setDefaultCloseOperation(0);
/*  63 */     setUndecorated(true);
/*     */     
/*  65 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(0));
/*  66 */     this.jPanel1.setName("");
/*     */     
/*  68 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/*  69 */     this.jLabel1.setHorizontalAlignment(0);
/*  70 */     this.jLabel1.setText("Writing file...");
/*     */     
/*  72 */     this.jProgressBar1.setFont(new Font("Tahoma", 1, 11));
/*  73 */     this.jProgressBar1.setStringPainted(true);
/*     */     
/*  75 */     this.jButton1.setLabel("Close");
/*  76 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  78 */         NewJDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  81 */     });
/*  82 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  83 */     this.jPanel1.setLayout(jPanel1Layout);
/*  84 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jProgressBar1, -1, 375, 32767).addComponent(this.jLabel1, -1, 375, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jButton1, -2, 103, -2).addGap(147, 147, 147)))));
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
/*  98 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jProgressBar1, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addContainerGap(-1, 32767)));
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
/* 110 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 111 */     getContentPane().setLayout(layout);
/* 112 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 116 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 121 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 125 */     setVisible(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 132 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 134 */         NewJDialog dialog = new NewJDialog(new javax.swing.JFrame(), true);
/* 135 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(WindowEvent e) {
/* 137 */             System.exit(0);
/*     */           }
/* 139 */         });
/* 140 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/NewJDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package pakfile;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class NewJDialog extends JDialog
/*     */ {
/*  23 */   private final Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
/*     */   private JLabel jLabel1;
/*     */   
/*     */   public NewJDialog(Frame parent, boolean modal) {
/*  27 */     super(parent, modal);
/*  28 */     initComponents();
/*  29 */     this.jProgressBar1.setMaximum(100);
/*  30 */     setLocation(this.screen.width / 2 - getWidth() / 2, this.screen.height / 2 - getHeight() / 2);
/*     */   }
/*     */   
/*     */ 
/*     */   public void setValue(long val, String msg)
/*     */   {
/*  36 */     this.jLabel1.setText(msg);
/*     */     
/*  38 */     this.jProgressBar1.setValue((int)val);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private JPanel jPanel1;
/*     */   
/*     */ 
/*     */   private JProgressBar jProgressBar1;
/*     */   
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  52 */     this.jPanel1 = new JPanel();
/*  53 */     this.jLabel1 = new JLabel();
/*  54 */     this.jProgressBar1 = new JProgressBar();
/*     */     
/*  56 */     setDefaultCloseOperation(0);
/*  57 */     setUndecorated(true);
/*     */     
/*  59 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(0));
/*  60 */     this.jPanel1.setName("");
/*     */     
/*  62 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/*  63 */     this.jLabel1.setHorizontalAlignment(0);
/*  64 */     this.jLabel1.setText("Writing file...");
/*     */     
/*  66 */     this.jProgressBar1.setFont(new Font("Tahoma", 1, 11));
/*  67 */     this.jProgressBar1.setStringPainted(true);
/*     */     
/*  69 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  70 */     this.jPanel1.setLayout(jPanel1Layout);
/*  71 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jProgressBar1, GroupLayout.Alignment.LEADING, -1, 375, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 375, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  80 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 22, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jProgressBar1, -2, 28, -2).addContainerGap(23, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  91 */     getContentPane().setLayout(layout);
/*  92 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*  96 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 101 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 108 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 110 */         NewJDialog dialog = new NewJDialog(new JFrame(), true);
/* 111 */         dialog.addWindowListener(new WindowAdapter() {
/*     */           public void windowClosing(WindowEvent e) {
/* 113 */             System.exit(0);
/*     */           }
/* 115 */         });
/* 116 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/pakfile/NewJDialog.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
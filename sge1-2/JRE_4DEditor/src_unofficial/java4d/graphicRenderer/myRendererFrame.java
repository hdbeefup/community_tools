/*     */ package java4d.graphicRenderer;
/*     */ 
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ 
/*     */ public class myRendererFrame extends javax.swing.JFrame
/*     */ {
/*     */   private com.sun.opengl.util.Animator anim;
/*     */   private myGlEventListener listener;
/*     */   private int axtmp;
/*     */   private int aytmp;
/*     */   private int axstart;
/*     */   private int aystart;
/*     */   private int txtmp;
/*     */   private int tytmp;
/*     */   private int txstart;
/*     */   private int tystart;
/*     */   private javax.media.opengl.GLJPanel gLJPanel1;
/*     */   private JCheckBoxMenuItem jCheckBoxMenuItem1;
/*     */   private JCheckBoxMenuItem jCheckBoxMenuItem2;
/*     */   private JCheckBoxMenuItem jCheckBoxMenuItem3;
/*     */   private javax.swing.JMenu jMenu1;
/*     */   
/*     */   public myRendererFrame()
/*     */   {
/*  26 */     initComponents();
/*  27 */     this.listener = new myGlEventListener(this);
/*  28 */     this.gLJPanel1.addGLEventListener(this.listener);
/*  29 */     this.anim = new com.sun.opengl.util.Animator(this.gLJPanel1);
/*     */   }
/*     */   
/*     */   public void startAnimator()
/*     */   {
/*  34 */     this.anim.start();
/*     */   }
/*     */   
/*     */   public void stopAnimator()
/*     */   {
/*  39 */     this.anim.stop();
/*     */   }
/*     */   
/*     */   public myGlEventListener getGlEventListener()
/*     */   {
/*  44 */     return this.listener;
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
/*  56 */     this.jMenu1 = new javax.swing.JMenu();
/*  57 */     this.jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
/*  58 */     this.jCheckBoxMenuItem2 = new JCheckBoxMenuItem();
/*  59 */     this.jCheckBoxMenuItem3 = new JCheckBoxMenuItem();
/*  60 */     this.gLJPanel1 = new javax.media.opengl.GLJPanel();
/*     */     
/*  62 */     this.jMenu1.setText("jMenu1");
/*     */     
/*  64 */     this.jCheckBoxMenuItem1.setSelected(true);
/*  65 */     this.jCheckBoxMenuItem1.setText("MESH objects");
/*  66 */     this.jCheckBoxMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/iconMESH.png")));
/*  67 */     this.jCheckBoxMenuItem1.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/*  69 */         myRendererFrame.this.jCheckBoxMenuItem1ItemStateChanged(evt);
/*     */       }
/*  71 */     });
/*  72 */     this.jMenu1.add(this.jCheckBoxMenuItem1);
/*     */     
/*  74 */     this.jCheckBoxMenuItem2.setSelected(true);
/*  75 */     this.jCheckBoxMenuItem2.setText("DUMY objects");
/*  76 */     this.jCheckBoxMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/iconDUMY.png")));
/*  77 */     this.jCheckBoxMenuItem2.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/*  79 */         myRendererFrame.this.jCheckBoxMenuItem2ItemStateChanged(evt);
/*     */       }
/*  81 */     });
/*  82 */     this.jMenu1.add(this.jCheckBoxMenuItem2);
/*     */     
/*  84 */     this.jCheckBoxMenuItem3.setSelected(true);
/*  85 */     this.jCheckBoxMenuItem3.setText("LITE objects");
/*  86 */     this.jCheckBoxMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/iconLITE.png")));
/*  87 */     this.jCheckBoxMenuItem3.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/*  89 */         myRendererFrame.this.jCheckBoxMenuItem3ItemStateChanged(evt);
/*     */       }
/*  91 */     });
/*  92 */     this.jMenu1.add(this.jCheckBoxMenuItem3);
/*     */     
/*  94 */     setDefaultCloseOperation(3);
/*     */     
/*  96 */     this.gLJPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
/*  97 */     this.gLJPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
/*     */       public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
/*  99 */         myRendererFrame.this.gLJPanel1MouseWheelMoved(evt);
/*     */       }
/* 101 */     });
/* 102 */     this.gLJPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 104 */         myRendererFrame.this.gLJPanel1MouseClicked(evt);
/*     */       }
/*     */       
/* 107 */       public void mousePressed(MouseEvent evt) { myRendererFrame.this.gLJPanel1MousePressed(evt);
/*     */       }
/* 109 */     });
/* 110 */     this.gLJPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 112 */         myRendererFrame.this.gLJPanel1MouseDragged(evt);
/*     */       }
/*     */       
/* 115 */     });
/* 116 */     javax.swing.GroupLayout gLJPanel1Layout = new javax.swing.GroupLayout(this.gLJPanel1);
/* 117 */     this.gLJPanel1.setLayout(gLJPanel1Layout);
/* 118 */     gLJPanel1Layout.setHorizontalGroup(gLJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 529, 32767));
/*     */     
/*     */ 
/*     */ 
/* 122 */     gLJPanel1Layout.setVerticalGroup(gLJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 372, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 127 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 128 */     getContentPane().setLayout(layout);
/* 129 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.gLJPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/* 133 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.gLJPanel1, -1, -1, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 138 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void gLJPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt)
/*     */   {
/* 150 */     this.listener.dist += evt.getWheelRotation() * 50;
/*     */   }
/*     */   
/*     */   private void gLJPanel1MouseDragged(MouseEvent evt)
/*     */   {
/* 155 */     if (evt.getModifiers() == 16)
/*     */     {
/* 157 */       this.listener.anglex = ((this.axtmp + (this.axstart - evt.getX())) % 360);
/* 158 */       this.listener.angley = ((this.aytmp + (this.aystart - evt.getY())) % 360);
/*     */     }
/* 160 */     if (evt.getModifiers() == 4)
/*     */     {
/* 162 */       this.listener.transpx = (this.txtmp + (this.txstart - evt.getX()));
/* 163 */       this.listener.transpy = (this.tytmp + (this.tystart - evt.getY()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void gLJPanel1MousePressed(MouseEvent evt)
/*     */   {
/* 170 */     this.txstart = (this.axstart = evt.getX());
/* 171 */     this.tystart = (this.aystart = evt.getY());
/* 172 */     this.axtmp = this.listener.anglex;
/* 173 */     this.aytmp = this.listener.angley;
/* 174 */     this.txtmp = this.listener.transpx;
/* 175 */     this.tytmp = this.listener.transpy;
/*     */   }
/*     */   
/*     */   private void jCheckBoxMenuItem1ItemStateChanged(java.awt.event.ItemEvent evt) {
/* 179 */     if (evt.getStateChange() == 1) {
/* 180 */       this.listener.paintmesh = true;
/*     */     } else {
/* 182 */       this.listener.paintmesh = false;
/*     */     }
/* 184 */     this.listener.updateRendering();
/*     */   }
/*     */   
/*     */   private void jCheckBoxMenuItem2ItemStateChanged(java.awt.event.ItemEvent evt) {
/* 188 */     if (evt.getStateChange() == 1) {
/* 189 */       this.listener.paintdumy = true;
/*     */     } else {
/* 191 */       this.listener.paintdumy = false;
/*     */     }
/* 193 */     this.listener.updateRendering();
/*     */   }
/*     */   
/*     */   private void jCheckBoxMenuItem3ItemStateChanged(java.awt.event.ItemEvent evt) {
/* 197 */     if (evt.getStateChange() == 1) {
/* 198 */       this.listener.paintlite = true;
/*     */     } else {
/* 200 */       this.listener.paintlite = false;
/*     */     }
/* 202 */     this.listener.updateRendering();
/*     */   }
/*     */   
/*     */   private void gLJPanel1MouseClicked(MouseEvent evt) {
/* 206 */     if (evt.getButton() == 3)
/*     */     {
/* 208 */       this.jMenu1.getPopupMenu().show(this, evt.getXOnScreen() - getX(), evt.getYOnScreen() - getY());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 219 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 221 */         new myRendererFrame().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/graphicRenderer/myRendererFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
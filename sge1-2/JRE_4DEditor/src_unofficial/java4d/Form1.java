/*     */ package java4d;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.logging.Logger;
/*     */ import java4d.graphicRenderer.myRendererFrame;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JTree;
/*     */ import utilities.myNode;
/*     */ 
/*     */ public class Form1 extends javax.swing.JFrame
/*     */ {
/*     */   java4d.sections.sect s;
/*     */   myRendererFrame k;
/*     */   public JButton jButton1;
/*     */   public JButton jButton4;
/*     */   public JButton jButton5;
/*     */   public javax.swing.JLabel jLabel1;
/*     */   public javax.swing.JLabel jLabel2;
/*     */   public javax.swing.JMenu jMenu1;
/*     */   public javax.swing.JMenu jMenu3;
/*     */   public javax.swing.JMenuItem jMenuItem1;
/*     */   public javax.swing.JMenuItem jMenuItem2;
/*     */   public javax.swing.JScrollPane jScrollPane1;
/*     */   public javax.swing.JToggleButton jToggleButton1;
/*     */   public JTree jTree1;
/*     */   
/*     */   public Form1()
/*     */   {
/*  33 */     initComponents();
/*  34 */     utilities.myTreeUI ui = new utilities.myTreeUI();
/*  35 */     this.jTree1.setCellRenderer(new utilities.myTreeCellRenderer());
/*  36 */     this.jTree1.setUI(ui);
/*  37 */     ui.setCollapsedIcon(utilities.IconFactory.getIcon("java4d/images/open.png"));
/*  38 */     ui.setExpandedIcon(utilities.IconFactory.getIcon("java4d/images/open2.png"));
/*  39 */     ui.setLeftChildIndent(12);
/*  40 */     ui.setRightChildIndent(20);
/*  41 */     ui.setHashColor2(java.awt.Color.decode("0xa7abf5"));
/*  42 */     ui.lineTypeDashed = true;
/*     */     
/*  44 */     this.k = new myRendererFrame();
/*  45 */     this.k.setVisible(true);
/*  46 */     this.k.startAnimator();
/*  47 */     setLocation(this.k.getX() + this.k.getWidth() + 2, 8);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkSaved()
/*     */   {
/*  53 */     if (this.s != null)
/*     */     {
/*  55 */       int choice = javax.swing.JOptionPane.showConfirmDialog(null, "Do you want to save current file?");
/*  56 */       if ((choice == 2) || (choice == -1)) {
/*  57 */         return false;
/*     */       }
/*  59 */       if (choice == 0) {
/*  60 */         java.io.File t = myutil.fileSave(this, "Stormregion 4D Files", "4d");
/*  61 */         if (t != null) {
/*  62 */           java4d.my4dfile.my4dFileManager.saveFile(t, this.s);
/*     */         } else {
/*  64 */           return true;
/*     */         }
/*     */       }
/*  67 */       this.s = null;
/*  68 */       this.k.getGlEventListener().setScene(null);
/*  69 */       this.k.getGlEventListener().updateRendering();
/*     */       
/*  71 */       return true;
/*     */     }
/*     */     
/*  74 */     return true;
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
/*  87 */     this.jMenu1 = new javax.swing.JMenu();
/*  88 */     this.jMenu3 = new javax.swing.JMenu();
/*  89 */     this.jMenuItem1 = new javax.swing.JMenuItem();
/*  90 */     this.jMenuItem2 = new javax.swing.JMenuItem();
/*  91 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  92 */     this.jTree1 = new JTree(new myNode(""));
/*  93 */     this.jButton1 = new JButton();
/*  94 */     this.jButton4 = new JButton();
/*  95 */     this.jToggleButton1 = new javax.swing.JToggleButton();
/*  96 */     this.jButton5 = new JButton();
/*  97 */     this.jLabel1 = new javax.swing.JLabel();
/*  98 */     this.jLabel2 = new javax.swing.JLabel();
/*     */     
/* 100 */     this.jMenu1.setText("Edit");
/*     */     
/* 102 */     this.jMenu3.setText("File");
/*     */     
/* 104 */     this.jMenuItem1.setText("jMenuItem1");
/* 105 */     this.jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 107 */         Form1.this.jMenuItem1ActionPerformed(evt);
/*     */       }
/* 109 */     });
/* 110 */     this.jMenu3.add(this.jMenuItem1);
/*     */     
/* 112 */     this.jMenuItem2.setText("jMenuItem2");
/* 113 */     this.jMenu3.add(this.jMenuItem2);
/*     */     
/* 115 */     this.jMenu1.add(this.jMenu3);
/*     */     
/* 117 */     setDefaultCloseOperation(3);
/* 118 */     setTitle("4D EDITOR");
/*     */     
/* 120 */     this.jTree1.setBackground(new java.awt.Color(233, 227, 255));
/* 121 */     javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
/* 122 */     this.jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
/* 123 */     this.jTree1.setRootVisible(false);
/* 124 */     this.jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 126 */         Form1.this.jTree1MouseClicked(evt);
/*     */       }
/* 128 */     });
/* 129 */     this.jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
/*     */       public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
/* 131 */         Form1.this.jTree1ValueChanged(evt);
/*     */       }
/* 133 */     });
/* 134 */     this.jScrollPane1.setViewportView(this.jTree1);
/*     */     
/* 136 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/iconMTLS.png")));
/* 137 */     this.jButton1.setText("Save 4d file");
/* 138 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 140 */         Form1.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 143 */     });
/* 144 */     this.jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/open2.png")));
/* 145 */     this.jButton4.setText("Open 4d file");
/* 146 */     this.jButton4.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 148 */         Form1.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */       
/* 151 */     });
/* 152 */     this.jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/iconSPOT.png")));
/* 153 */     this.jToggleButton1.setSelected(true);
/* 154 */     this.jToggleButton1.setText("View model");
/* 155 */     this.jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 157 */         Form1.this.jToggleButton1ItemStateChanged(evt);
/*     */       }
/*     */       
/* 160 */     });
/* 161 */     this.jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java4d/images/objects.png")));
/* 162 */     this.jButton5.setText("New 4d file");
/* 163 */     this.jButton5.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 165 */         Form1.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */       
/* 168 */     });
/* 169 */     this.jLabel1.setText("v0.1");
/*     */     
/* 171 */     this.jLabel2.setText("written by jaNo744");
/*     */     
/* 173 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 174 */     getContentPane().setLayout(layout);
/* 175 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jButton5, -1, 121, 32767).addComponent(this.jToggleButton1, -1, 121, 32767).addComponent(this.jButton4, javax.swing.GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton1, -1, 121, 32767)).addGap(20, 20, 20)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.jScrollPane1, -2, 403, -2).addContainerGap()));
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
/* 197 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jButton5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jToggleButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, 32767).addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 315, 32767))).addGap(20, 20, 20)));
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
/* 220 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 224 */     if (this.s == null) return;
/* 225 */     java.io.File t = myutil.fileSave(this, "Stormregion 4D Files", "4d");
/* 226 */     if (t != null) { java4d.my4dfile.my4dFileManager.saveFile(t, this.s);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 236 */     if (!checkSaved()) return;
/*     */     try {
/* 238 */       this.k.stopAnimator();
/* 239 */       java.io.File t = myutil.fileOpen(this, "Stormregion 4D Files", "4d");
/*     */       
/* 241 */       if (t != null) {
/* 242 */         this.s = java4d.my4dfile.my4dFileManager.loadFile(t);
/* 243 */         utilities.sectJTreeBuilder.draw(this.s, this.jTree1);
/*     */         
/* 245 */         if (this.s.getClass() == java4d.sections.sectSCEN.class) {
/* 246 */           ((java4d.sections.sectSCEN)this.s).setEventListener(new java4d.sections.sectEventListener()
/*     */           {
/*     */             public void structureChanged() {
/* 249 */               utilities.sectJTreeBuilder.draw(Form1.this.s, Form1.this.jTree1);
/* 250 */               dataChanged();
/*     */             }
/*     */             
/*     */             public void dataChanged() {
/* 254 */               Form1.this.k.getGlEventListener().updateRendering();
/*     */             }
/* 256 */           });
/* 257 */           this.k.getGlEventListener().setScene(this.s);
/* 258 */           setTitle("4D EDITOR: " + t.getName());
/*     */         }
/*     */         
/* 261 */         y = this.s.getSize();
/*     */       }
/*     */     } catch (java4d.my4dfile.SizeMismatchException ex) {
/*     */       int y;
/* 265 */       javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Load error", 0);
/* 266 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (java4d.my4dfile.Not4dFileException ex) {
/* 268 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 269 */       javax.swing.JOptionPane.showMessageDialog(this, "Not a 4d Stormregion file", "Header error", 0);
/*     */     } catch (java4d.my4dfile.InvalidDataException ex) {
/* 271 */       javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid data", 0);
/* 272 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     catch (Exception ex) {
/* 275 */       javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 0);
/* 276 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } finally {
/* 278 */       this.k.startAnimator();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {
/* 283 */     if (evt.getNewLeadSelectionPath() != null)
/*     */     {
/* 285 */       myNode n = (myNode)evt.getNewLeadSelectionPath().getLastPathComponent();
/* 286 */       if (!n.isRoot())
/*     */       {
/* 288 */         this.k.getGlEventListener().setHighlightedObject(n.getSect());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jTree1MouseClicked(MouseEvent evt)
/*     */   {
/* 301 */     javax.swing.tree.TreePath p = this.jTree1.getPathForLocation(evt.getX(), evt.getY());
/*     */     
/* 303 */     if ((evt.getClickCount() == 2) && (evt.getButton() == 1) && (p != null))
/*     */     {
/* 305 */       myNode n = (myNode)p.getLastPathComponent();
/* 306 */       if (java4d.sections.sectMESH.class.isInstance(n.getSect()))
/*     */       {
/*     */ 
/*     */ 
/* 310 */         java4d.sections.sectMESH m = (java4d.sections.sectMESH)n.getSect();
/* 311 */         ((java4d.sections.sectSCEN)this.s).addObjectAt(m, 1);
/* 312 */         utilities.sectJTreeBuilder.draw(this.s, this.jTree1);
/* 313 */         this.k.getGlEventListener().updateRendering();
/*     */ 
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */     }
/* 321 */     else if ((evt.getButton() == 3) && (p != null))
/*     */     {
/* 323 */       this.jTree1.setSelectionPath(p);
/* 324 */       myNode n = (myNode)p.getLastPathComponent();
/* 325 */       n.getSect().getEditMenu().getPopupMenu().show(this, evt.getXOnScreen() - getX(), evt.getYOnScreen() - getY());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jMenuItem1ActionPerformed(ActionEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt)
/*     */   {
/* 340 */     if (evt.getStateChange() == 1)
/*     */     {
/* 342 */       this.k.setVisible(true);
/* 343 */       this.k.startAnimator();
/*     */     } else {
/* 345 */       this.k.setVisible(false);
/* 346 */       this.k.stopAnimator();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt)
/*     */   {
/* 353 */     if (!checkSaved()) return;
/* 354 */     utilities.sectJTreeBuilder.draw(this.s, this.jTree1);
/* 355 */     java.io.InputStream input = utilities.IconFactory.class.getClassLoader().getResourceAsStream("java4d/empty.4d");
/*     */     try
/*     */     {
/* 358 */       byte[] data = new byte[input.available()];
/* 359 */       input.read(data);
/* 360 */       this.s = java4d.my4dfile.sectListManager.getSect(data, 0, new String("SCEN"), null);
/* 361 */       utilities.sectJTreeBuilder.draw(this.s, this.jTree1);
/* 362 */       ((java4d.sections.sectSCEN)this.s).setEventListener(new java4d.sections.sectEventListener()
/*     */       {
/*     */         public void structureChanged() {
/* 365 */           utilities.sectJTreeBuilder.draw(Form1.this.s, Form1.this.jTree1);
/* 366 */           dataChanged();
/*     */         }
/*     */         
/*     */         public void dataChanged() {
/* 370 */           Form1.this.k.getGlEventListener().updateRendering();
/*     */         }
/* 372 */       });
/* 373 */       this.k.getGlEventListener().setScene(this.s);
/* 374 */       setTitle("4D EDITOR: new file");
/*     */     } catch (java4d.my4dfile.SizeMismatchException ex) {
/* 376 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (java.io.IOException ex) {
/* 378 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (Exception ex) {
/* 380 */       Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 390 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 392 */         new Form1().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/Form1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
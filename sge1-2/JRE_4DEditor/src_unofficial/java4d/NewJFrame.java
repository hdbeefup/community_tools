/*     */ package java4d;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
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
/*     */ public class NewJFrame
/*     */   extends JFrame
/*     */ {
/*     */   private JButton jButton1;
/*     */   
/*     */   public NewJFrame()
/*     */   {
/*  74 */     initComponents();
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
/*  87 */     this.jButton1 = new JButton();
/*     */     
/*  89 */     setDefaultCloseOperation(3);
/*     */     
/*  91 */     this.jButton1.setText("jButton1");
/*  92 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  94 */         NewJFrame.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  97 */     });
/*  98 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  99 */     getContentPane().setLayout(layout);
/* 100 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(86, 86, 86).addComponent(this.jButton1).addContainerGap(369, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 107 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(165, 32767).addComponent(this.jButton1).addGap(140, 140, 140)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 119 */     ObjectOutputStream out = null;
/*     */     try {
/* 121 */       prova c = new prova(12, "ciao", 1134);
/*     */       
/* 123 */       FileOutputStream fo = new FileOutputStream("c.out");
/* 124 */       fo.write("MESH".getBytes());
/*     */       
/* 126 */       out = new ObjectOutputStream(fo);
/* 127 */       out.writeObject("c storage\n");
/* 128 */       out.writeObject(c);
/* 129 */       out.close();
/* 130 */       FileInputStream fi = new FileInputStream("c.out");
/* 131 */       fi.skip(4L);
/*     */       
/*     */ 
/* 134 */       ObjectInputStream in = new ObjectInputStream(fi);
/* 135 */       String s = (String)in.readObject();
/* 136 */       prova w2 = (prova)in.readObject();
/* 137 */       System.out.print(s + "w2 = " + w2);
/* 138 */     } catch (ClassNotFoundException ex) { ex = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */         ex;Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     catch (IOException ex)
/*     */     {
/* 140 */       ex = 
/*     */       
/*     */ 
/*     */ 
/* 144 */         ex;Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     finally {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 153 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 155 */         new NewJFrame().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/NewJFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
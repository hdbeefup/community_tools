/*    */ package java4d.datatypes;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Dimension;
/*    */ import java4d.myutil;
/*    */ import javax.swing.BoxLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.event.CaretEvent;
/*    */ import javax.swing.event.CaretListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class infoLabel
/*    */   extends myDataType
/*    */ {
/*    */   public String val;
/*    */   
/*    */   public infoLabel()
/*    */   {
/* 25 */     this.val = new String();
/*    */   }
/*    */   
/*    */   public infoLabel(byte[] source, int offset) {
/* 29 */     this();
/* 30 */     getFrom(source, offset);
/*    */   }
/*    */   
/*    */   public int dataSize() {
/* 34 */     return this.val.length() + 2;
/*    */   }
/*    */   
/*    */   public void toBytes(byte[] dest, int offset) {
/* 38 */     myutil.putShort(this.val.length(), dest, offset);
/* 39 */     System.arraycopy(this.val.getBytes(), 0, dest, offset + 2, this.val.length());
/*    */   }
/*    */   
/*    */   public void getFrom(byte[] source, int offset) {
/* 43 */     int len = myutil.getShort(source, offset);
/* 44 */     this.val = new String(source, offset + 2, len);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 49 */     return new String(this.val);
/*    */   }
/*    */   
/*    */ 
/*    */   public infoLabel clone()
/*    */   {
/* 55 */     infoLabel copy = new infoLabel();
/* 56 */     copy.val = new String(this.val);
/* 57 */     return copy;
/*    */   }
/*    */   
/*    */   public Component getEditor()
/*    */   {
/* 62 */     JPanel p = new JPanel();
/* 63 */     p.setLayout(new BoxLayout(p, 1));
/*    */     
/* 65 */     JLabel l = new JLabel("Description:");
/* 66 */     p.add(l);
/*    */     
/* 68 */     l.setMinimumSize(new Dimension(10000, 16));
/* 69 */     final JTextField t = new JTextField();
/* 70 */     p.add(t);
/*    */     
/* 72 */     t.setText(this.val);
/*    */     
/* 74 */     t.addCaretListener(new CaretListener() {
/*    */       public void caretUpdate(CaretEvent evt) {
/* 76 */         infoLabel.this.val = t.getText();
/*    */       }
/*    */       
/* 79 */     });
/* 80 */     myutil.packPanel(p, 200);
/* 81 */     return p;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/infoLabel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
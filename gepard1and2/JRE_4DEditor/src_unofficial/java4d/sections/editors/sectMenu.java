/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import java4d.sections.data.sectData;
/*    */ import java4d.sections.sect;
/*    */ import java4d.sections.sectEventListener;
/*    */ import java4d.sections.sectSCEN;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JOptionPane;
/*    */ import utilities.IconFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectMenu
/*    */ {
/*    */   protected JMenu edit;
/*    */   protected JMenu menu;
/*    */   protected sect owner;
/*    */   
/*    */   public sectMenu(sect s_owner)
/*    */   {
/* 28 */     this.owner = s_owner;
/* 29 */     this.edit = new JMenu("Edit");
/* 30 */     this.edit.add(this.menu = new JMenu("-"));
/*    */     
/*    */ 
/* 33 */     this.menu.setText(this.owner.getTitle());
/* 34 */     ImageIcon j = IconFactory.getIcon("java4d/images/icon" + this.owner.getTitle() + ".png");
/* 35 */     if (j == null) {
/* 36 */       j = IconFactory.getIcon("java4d/images/iconUnknown.png");
/*    */     }
/*    */     
/* 39 */     this.menu.setIcon(j);
/*    */     
/*    */ 
/* 42 */     if ((this.owner.getParent() != null) && (this.owner.getParent().getClass() == sectSCEN.class)) {
/* 43 */       final sect cur = this.owner;
/* 44 */       final sectSCEN curscen = (sectSCEN)cur.getParent();
/* 45 */       JMenuItem mnu_del = new JMenuItem("Delete this");
/* 46 */       mnu_del.addActionListener(new ActionListener()
/*    */       {
/*    */         public void actionPerformed(ActionEvent evt) {
/* 49 */           int i = JOptionPane.showOptionDialog(null, "This operation will delete all hierarchically-linked children (if any).\nAre you sure?", "Confirm", 0, 2, null, null, null);
/* 50 */           if (i == 1) return;
/* 51 */           curscen.deleteChild(cur);
/* 52 */           if (sectMenu.this.owner.getEventListener() != null) {
/* 53 */             sectMenu.this.owner.getEventListener().structureChanged();
/*    */           }
/*    */           
/*    */         }
/* 57 */       });
/* 58 */       this.menu.add(mnu_del);
/*    */     }
/*    */     
/*    */ 
/* 62 */     JMenuItem ed = null;
/*    */     try {
/* 64 */       Class.forName("java4d.sections.editors." + this.owner.getTitle() + "editor").getConstructor(new Class[] { sectData.class });
/* 65 */       ed = new JMenuItem("Open " + this.owner.getTitle() + " editor");
/* 66 */       ed.addActionListener(new ActionListener() {
/*    */         public void actionPerformed(ActionEvent evt) {
/* 68 */           sectMenu.this.owner.showEditor();
/*    */         }
/*    */       });
/*    */     } catch (NoSuchMethodException ex) {
/* 72 */       Logger.getLogger(sectMenu.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (SecurityException ex) {
/* 74 */       Logger.getLogger(sectMenu.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     catch (ClassNotFoundException ex) {}
/*    */     
/* 78 */     if (ed != null) {
/* 79 */       this.menu.add(ed);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public JMenu getMenu()
/*    */   {
/* 87 */     return this.edit;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/sectMenu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
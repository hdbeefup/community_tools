/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java4d.sections.data.DIFFdata;
/*    */ import java4d.sections.sect;
/*    */ import java4d.sections.sectDIFF;
/*    */ import java4d.sections.sectMATE;
/*    */ import java4d.sections.sectREFL;
/*    */ import java4d.sections.sectSPEC;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MATEmenu
/*    */   extends sectMenu
/*    */ {
/*    */   public MATEmenu(sect s_owner)
/*    */   {
/* 23 */     super(s_owner);
/* 24 */     JMenuItem addDiff = new JMenuItem("Add DIFF material", null);
/* 25 */     this.menu.add(addDiff);
/* 26 */     addDiff.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 28 */         sectDIFF newdiff = new sectDIFF(MATEmenu.this.owner);
/* 29 */         ((sectMATE)MATEmenu.this.owner).addDiff(newdiff);
/* 30 */         ((DIFFdata)newdiff.getSectionData()).desc.val = "new_diff.tga";
/*    */       }
/* 32 */     });
/* 33 */     JMenuItem addRefl = new JMenuItem("Add REFL material", null);
/* 34 */     this.menu.add(addRefl);
/* 35 */     addRefl.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 37 */         sectREFL newrefl = new sectREFL(MATEmenu.this.owner);
/* 38 */         ((sectMATE)MATEmenu.this.owner).addRefl(newrefl);
/* 39 */         ((DIFFdata)newrefl.getSectionData()).desc.val = "new_refl.tga";
/*    */       }
/* 41 */     });
/* 42 */     JMenuItem addSpec = new JMenuItem("Add SPEC material", null);
/* 43 */     this.menu.add(addSpec);
/* 44 */     addSpec.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 46 */         sectSPEC newspec = new sectSPEC(MATEmenu.this.owner);
/* 47 */         ((sectMATE)MATEmenu.this.owner).addSpec(newspec);
/* 48 */         ((DIFFdata)newspec.getSectionData()).desc.val = "new_spec.tga";
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/MATEmenu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
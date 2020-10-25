/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.File;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.data.DUMYdata;
/*    */ import java4d.sections.data.sectData;
/*    */ import java4d.sections.sect;
/*    */ import java4d.sections.sectDUMY;
/*    */ import java4d.sections.sectEventListener;
/*    */ import java4d.sections.sectMESH;
/*    */ import java4d.sections.sectSCEN;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuItem;
/*    */ import net.java.joglutils.model.geometry.Model;
/*    */ import net.java.joglutils.model.loader.MaxLoader;
/*    */ import utilities.IconFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SCENmenu
/*    */   extends sectMenu
/*    */ {
/*    */   private Model mod3ds;
/*    */   
/*    */   public SCENmenu(sect s_owner)
/*    */   {
/* 29 */     super(s_owner);
/* 30 */     JMenuItem addlite = new JMenuItem("Add LITE object", IconFactory.getIcon("java4d/images/iconLITE.png"));
/* 31 */     this.menu.add(addlite);
/* 32 */     addlite.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 34 */         new LITEmaker((sectSCEN)SCENmenu.this.owner).setVisible(true);
/*    */       }
/*    */       
/* 37 */     });
/* 38 */     JMenuItem adddumy = new JMenuItem("Add DUMY object", IconFactory.getIcon("java4d/images/iconDUMY.png"));
/* 39 */     this.menu.add(adddumy);
/* 40 */     adddumy.addActionListener(new ActionListener()
/*    */     {
/*    */       public void actionPerformed(ActionEvent evt)
/*    */       {
/* 44 */         sectDUMY section = new sectDUMY(SCENmenu.this.owner);
/* 45 */         DUMYdata data = new DUMYdata(section);
/* 46 */         data.desc.val = new String("new_dumy");
/* 47 */         data.space.versors[0].val[0] = 1.0F;
/* 48 */         data.space.versors[1].val[1] = 1.0F;
/* 49 */         data.space.versors[2].val[2] = 1.0F;
/* 50 */         parentIdEditDialog ed1 = new parentIdEditDialog(null, true, data);
/* 51 */         ed1.setVisible(true);
/* 52 */         if (ed1.hasCancelled()) return;
/* 53 */         int targetpos = sectMaker.getTargetPosition((sectSCEN)SCENmenu.this.owner);
/*    */         
/* 55 */         if (targetpos < 0) return;
/* 56 */         section.getSectionData().copyFrom(data);
/* 57 */         ((sectSCEN)SCENmenu.this.owner).addObjectAt(section, targetpos);
/* 58 */         SCENmenu.this.owner.getEventListener().structureChanged();
/*    */       }
/* 60 */     });
/* 61 */     JMenuItem importmesh = new JMenuItem("Import MESH object", IconFactory.getIcon("java4d/images/iconMESH.png"));
/* 62 */     this.menu.add(importmesh);
/* 63 */     importmesh.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 65 */         SCENmenu.this.doImportMesh();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void doImportMesh()
/*    */   {
/* 75 */     File fi = myutil.fileOpen(null, "3D Studio Max 3ds files ", "3ds");
/* 76 */     if (fi != null)
/*    */     {
/* 78 */       MaxLoader loader = new MaxLoader();
/*    */       
/* 80 */       this.mod3ds = loader.load(fi.getPath());
/*    */       
/* 82 */       sectMESH m = new sectMESH(this.owner);
/* 83 */       MESHimporter importer = new MESHimporter(null, true, m, this.mod3ds);
/* 84 */       importer.setVisible(true);
/* 85 */       if (!importer.isJobDone()) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/SCENmenu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
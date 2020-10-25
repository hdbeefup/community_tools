/*     */ package java4d.sections.editors;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Frame;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java4d.myutil;
/*     */ import java4d.sections.data.INDIdata;
/*     */ import java4d.sections.data.MATEdata;
/*     */ import java4d.sections.data.MESHdata;
/*     */ import java4d.sections.data.VERTdata;
/*     */ import java4d.sections.sectBBOX;
/*     */ import java4d.sections.sectEventListener;
/*     */ import java4d.sections.sectINDI;
/*     */ import java4d.sections.sectMATE;
/*     */ import java4d.sections.sectMESH;
/*     */ import java4d.sections.sectMTLS;
/*     */ import java4d.sections.sectSCEN;
/*     */ import java4d.sections.sectVERT;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import net.java.joglutils.model.geometry.Mesh;
/*     */ import net.java.joglutils.model.geometry.Model;
/*     */ import net.java.joglutils.model.geometry.TexCoord;
/*     */ import net.java.joglutils.model.geometry.Vec4;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MESHimporter
/*     */   extends sectMaker
/*     */ {
/*     */   private sectMESH curmesh;
/*  43 */   private boolean jobdone = false;
/*     */   private Model curmod;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   
/*  48 */   public MESHimporter(Frame parent, boolean modal, sectMESH target, Model threeDSmodel) { super((sectSCEN)target.getParent());
/*  49 */     this.curmesh = target;
/*  50 */     this.curmod = threeDSmodel;
/*  51 */     initComponents();
/*     */     
/*  53 */     setLocation(myutil.screen.width / 2 - getWidth() / 2, myutil.screen.height / 2 - getHeight() / 2);
/*     */     
/*  55 */     this.jList1.setModel(new DefaultListModel());
/*     */     
/*     */ 
/*  58 */     for (int i = 0; i < this.curmod.getNumberOfMeshes(); i++)
/*     */     {
/*     */ 
/*  61 */       ((DefaultListModel)this.jList1.getModel()).addElement(this.curmod.getMesh(i).name);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isJobDone()
/*     */   {
/*  68 */     return this.jobdone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JLabel jLabel1;
/*     */   
/*     */   private JList jList1;
/*     */   
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   private void initComponents()
/*     */   {
/*  81 */     this.jScrollPane1 = new JScrollPane();
/*  82 */     this.jList1 = new JList();
/*  83 */     this.jLabel1 = new JLabel();
/*  84 */     this.jButton1 = new JButton();
/*  85 */     this.jButton2 = new JButton();
/*     */     
/*  87 */     setDefaultCloseOperation(2);
/*     */     
/*  89 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */     
/*  91 */     this.jLabel1.setText("Select the object to import:");
/*     */     
/*  93 */     this.jButton1.setText("Import");
/*  94 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  96 */         MESHimporter.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  99 */     });
/* 100 */     this.jButton2.setText("Cancel");
/* 101 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 103 */         MESHimporter.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 106 */     });
/* 107 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 108 */     getContentPane().setLayout(layout);
/* 109 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 253, 32767).addComponent(this.jLabel1).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1))).addContainerGap()));
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
/* 122 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(-1, 32767)));
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
/* 136 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 140 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 144 */     if (this.jList1.getSelectedIndex() < 0)
/*     */     {
/* 146 */       JOptionPane.showMessageDialog(this, "Nothing selected", "Error", 0);
/* 147 */       return;
/*     */     }
/* 149 */     Mesh curobj = this.curmod.getMesh(this.jList1.getSelectedIndex());
/* 150 */     if (curobj.numOfFaces > 21485)
/*     */     {
/* 152 */       JOptionPane.showMessageDialog(this, "The selected object has too many faces (limit: 21485) for Panzers", "Error", 0);
/* 153 */       return;
/*     */     }
/*     */     
/*     */ 
/* 157 */     sectVERT sectvert = new sectVERT(this.curmesh, curobj.numOfVerts);
/* 158 */     sectINDI sectindi = new sectINDI(this.curmesh, curobj.numOfFaces * 3);
/* 159 */     VERTdata vdata = (VERTdata)sectvert.getSectionData();
/* 160 */     INDIdata idata = (INDIdata)sectindi.getSectionData();
/*     */     
/* 162 */     for (int i = 0; i < curobj.vertices.length; i++)
/*     */     {
/* 164 */       vdata.vert[i].coord.val[0] = curobj.vertices[i].x;
/* 165 */       vdata.vert[i].coord.val[1] = curobj.vertices[i].y;
/* 166 */       vdata.vert[i].coord.val[2] = curobj.vertices[i].z;
/*     */       
/* 168 */       vdata.vert[i].normal.val[0] = (-curobj.normals[i].x);
/* 169 */       vdata.vert[i].normal.val[1] = (-curobj.normals[i].y);
/* 170 */       vdata.vert[i].normal.val[2] = (-curobj.normals[i].z);
/* 171 */       if (curobj.hasTexture)
/*     */       {
/* 173 */         vdata.vert[i].textureCoord.val[0] = curobj.texCoords[i].u;
/* 174 */         vdata.vert[i].textureCoord.val[1] = curobj.texCoords[i].v;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 186 */     for (int i = 0; i < curobj.numOfFaces; i++)
/*     */     {
/* 188 */       idata.ind[(i * 3)] = curobj.faces[i].vertIndex[0];
/* 189 */       idata.ind[(i * 3 + 1)] = curobj.faces[i].vertIndex[1];
/* 190 */       idata.ind[(i * 3 + 2)] = curobj.faces[i].vertIndex[2];
/*     */     }
/*     */     
/* 193 */     sectMTLS mtls = new sectMTLS(this.curmesh);
/* 194 */     sectMATE material = new sectMATE(mtls);
/* 195 */     mtls.setMaterial(material);
/* 196 */     ((MATEdata)material.getSectionData()).indiCount = (idata.ind.length / 3);
/* 197 */     ((MATEdata)material.getSectionData()).vertStart = 0;
/* 198 */     ((MATEdata)material.getSectionData()).vertStop = (vdata.vert.length - 1);
/*     */     
/* 200 */     MESHdata curmeshdata = (MESHdata)this.curmesh.getSectionData();
/*     */     
/* 202 */     this.curmesh.setSubSections(new sectBBOX(this.curmesh), sectvert, sectindi, mtls);
/* 203 */     curmeshdata.space.versors[0].val[0] = 1.0F;
/* 204 */     curmeshdata.space.versors[1].val[1] = 1.0F;
/* 205 */     curmeshdata.space.versors[2].val[2] = 1.0F;
/* 206 */     curmeshdata.desc.val = "new_Mesh";
/*     */     
/* 208 */     parentIdEditDialog ed1 = new parentIdEditDialog(this, true, (MESHdata)this.curmesh.getSectionData());
/* 209 */     ed1.setVisible(true);
/*     */     
/* 211 */     int targetpos = getTargetPosition(this.parent);
/*     */     
/* 213 */     if (targetpos < 0) return;
/* 214 */     this.parent.addObjectAt(this.curmesh, targetpos);
/*     */     
/* 216 */     this.parent.getEventListener().structureChanged();
/* 217 */     dispose();
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/MESHimporter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
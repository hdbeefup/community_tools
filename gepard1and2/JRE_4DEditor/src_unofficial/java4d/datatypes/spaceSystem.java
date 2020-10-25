/*     */ package java4d.datatypes;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java4d.myutil;
/*     */ import javax.swing.BoxLayout;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerModel;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ public class spaceSystem
/*     */   extends myDataType
/*     */ {
/*     */   public vector3f[] versors;
/*     */   public vector3f coord;
/*     */   protected float[] tmpmatr;
/*     */   private JSpinner cx;
/*     */   private JSpinner cy;
/*     */   private JSpinner cz;
/*     */   private JSpinner ax;
/*     */   private JSpinner ay;
/*     */   private JSpinner az;
/*     */   
/*     */   public spaceSystem()
/*     */   {
/*  31 */     this.versors = new vector3f[3];
/*  32 */     for (int i = 0; i < this.versors.length; i++)
/*  33 */       this.versors[i] = new vector3f();
/*  34 */     this.coord = new vector3f();
/*     */   }
/*     */   
/*     */   public spaceSystem(byte[] source, int offset) {
/*  38 */     this();
/*  39 */     getFrom(source, offset);
/*     */   }
/*     */   
/*     */   public int dataSize() {
/*  43 */     return this.coord.dataSize() * 4;
/*     */   }
/*     */   
/*     */   public void toBytes(byte[] dest, int offset)
/*     */   {
/*  48 */     for (int i = 0; i < this.versors.length; i++)
/*  49 */       this.versors[i].toBytes(dest, offset + i * this.coord.dataSize());
/*  50 */     this.coord.toBytes(dest, offset + this.coord.dataSize() * this.versors.length);
/*     */   }
/*     */   
/*     */   public void getFrom(byte[] source, int offset)
/*     */   {
/*  55 */     for (int i = 0; i < this.versors.length; i++)
/*  56 */       this.versors[i].getFrom(source, offset + i * this.coord.dataSize());
/*  57 */     this.coord.getFrom(source, offset + this.coord.dataSize() * this.versors.length);
/*     */   }
/*     */   
/*     */   public float[] getTransformMatrix()
/*     */   {
/*  62 */     float[] matr = new float[16];
/*  63 */     for (int i = 0; i < 3; i++)
/*     */     {
/*  65 */       matr[(4 * i)] = this.versors[i].val[0];
/*  66 */       matr[(4 * i + 1)] = this.versors[i].val[1];
/*  67 */       matr[(4 * i + 2)] = this.versors[i].val[2];
/*  68 */       matr[(12 + i)] = this.coord.val[i];
/*     */     }
/*  70 */     matr[15] = 1.0F;
/*  71 */     return matr;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setTransformMatrix(float[] matr)
/*     */   {
/*  77 */     for (int i = 0; i < 3; i++)
/*     */     {
/*  79 */       this.versors[i].val[0] = matr[(4 * i)];
/*  80 */       this.versors[i].val[1] = matr[(4 * i + 1)];
/*  81 */       this.versors[i].val[2] = matr[(4 * i + 2)];
/*  82 */       this.coord.val[i] = matr[(12 + i)];
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  88 */     String ret = new String();
/*  89 */     for (vector3f v : this.versors)
/*  90 */       ret = ret + v.toString() + " ";
/*  91 */     ret = ret + " -  " + this.coord.toString();
/*  92 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   public spaceSystem clone()
/*     */   {
/*  98 */     spaceSystem copy = new spaceSystem();
/*  99 */     for (int i = 0; i < this.versors.length; i++)
/* 100 */       copy.versors[i] = this.versors[i].clone();
/* 101 */     copy.coord = this.coord.clone();
/* 102 */     return copy;
/*     */   }
/*     */   
/*     */   public Component getEditor()
/*     */   {
/* 107 */     this.tmpmatr = ((float[])getTransformMatrix().clone());
/*     */     
/* 109 */     final JPanel p = new JPanel();
/* 110 */     JPanel p1 = new JPanel();
/* 111 */     JPanel p2 = new JPanel();
/*     */     
/* 113 */     p.setLayout(new BoxLayout(p, 1));
/* 114 */     p1.setLayout(new BoxLayout(p1, 2));
/* 115 */     p2.setLayout(new BoxLayout(p2, 2));
/*     */     
/*     */ 
/* 118 */     Dimension exp1 = new Dimension(10000, 16);
/* 119 */     JLabel l1 = new JLabel("Coordinates (x,y,z):");
/* 120 */     l1.setMinimumSize(exp1);
/* 121 */     p.add(l1);
/*     */     
/* 123 */     this.cx = new JSpinner(new SpinnerNumberModel(Float.valueOf(0.0F), null, null, Float.valueOf(1.0F)));
/* 124 */     this.cy = new JSpinner(new SpinnerNumberModel(Float.valueOf(0.0F), null, null, Float.valueOf(1.0F)));
/* 125 */     this.cz = new JSpinner(new SpinnerNumberModel(Float.valueOf(0.0F), null, null, Float.valueOf(1.0F)));
/*     */     
/* 127 */     this.cx.getModel().setValue(Float.valueOf(this.coord.val[0]));
/* 128 */     this.cy.getModel().setValue(Float.valueOf(this.coord.val[1]));
/* 129 */     this.cz.getModel().setValue(Float.valueOf(this.coord.val[2]));
/*     */     
/* 131 */     this.cx.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 133 */         spaceSystem.this.changePosition();
/* 134 */         if (p.getParent() != null)
/* 135 */           p.getParent().firePropertyChange("renderer", 0L, 1L);
/*     */       }
/* 137 */     });
/* 138 */     this.cy.addChangeListener(this.cx.getChangeListeners()[0]);
/* 139 */     this.cz.addChangeListener(this.cx.getChangeListeners()[0]);
/*     */     
/* 141 */     p1.add(this.cx);
/* 142 */     p1.add(this.cy);
/* 143 */     p1.add(this.cz);
/*     */     
/* 145 */     p.add(p1);
/*     */     
/* 147 */     JLabel l2 = new JLabel("Axis rotation (x,y,z):");
/* 148 */     l1.setMinimumSize(exp1);
/* 149 */     p.add(l2);
/*     */     
/* 151 */     this.ax = new JSpinner(new SpinnerNumberModel(Float.valueOf(0.0F), null, null, Float.valueOf(1.0F)));
/* 152 */     this.ax.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 154 */         spaceSystem.this.changeRotation();
/* 155 */         if (p.getParent() != null)
/* 156 */           p.getParent().firePropertyChange("renderer", 0L, 1L);
/*     */       }
/* 158 */     });
/* 159 */     this.ay = new JSpinner(new SpinnerNumberModel(Float.valueOf(0.0F), null, null, Float.valueOf(1.0F)));
/* 160 */     this.ay.addChangeListener(this.ax.getChangeListeners()[0]);
/* 161 */     this.az = new JSpinner(new SpinnerNumberModel(Float.valueOf(0.0F), null, null, Float.valueOf(1.0F)));
/* 162 */     this.az.addChangeListener(this.ax.getChangeListeners()[0]);
/*     */     
/* 164 */     p2.add(this.ax);
/* 165 */     p2.add(this.ay);
/* 166 */     p2.add(this.az);
/*     */     
/* 168 */     p.add(p2);
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
/* 183 */     myutil.packPanel(p, 350);
/*     */     
/* 185 */     return p;
/*     */   }
/*     */   
/*     */   private void changeRotation()
/*     */   {
/* 190 */     float[] rotx = new float[16];
/* 191 */     rotx[5] = (rotx[15] = 1.0F);
/* 192 */     rotx[0] = (rotx[10] = (float)Math.cos(((Float)((SpinnerNumberModel)this.ax.getModel()).getValue()).floatValue() * 3.141592653589793D / 180.0D));
/* 193 */     rotx[8] = ((float)Math.sin(((Float)((SpinnerNumberModel)this.ax.getModel()).getValue()).floatValue() * 3.141592653589793D / 180.0D));
/* 194 */     rotx[2] = (-rotx[8]);
/* 195 */     float[] roty = new float[16];
/* 196 */     roty[0] = (roty[15] = 1.0F);
/* 197 */     roty[5] = (roty[10] = (float)Math.cos(((Float)(Float)((SpinnerNumberModel)this.ay.getModel()).getValue()).floatValue() * 3.141592653589793D / 180.0D));
/* 198 */     roty[6] = ((float)Math.sin(((Float)((SpinnerNumberModel)this.ay.getModel()).getValue()).floatValue() * 3.141592653589793D / 180.0D));
/* 199 */     roty[9] = (-roty[6]);
/* 200 */     float[] rotz = new float[16];
/* 201 */     rotz[10] = (rotz[15] = 1.0F);
/* 202 */     rotz[0] = (rotz[5] = (float)Math.cos(((Float)(Float)((SpinnerNumberModel)this.az.getModel()).getValue()).floatValue() * 3.141592653589793D / 180.0D));
/* 203 */     rotz[1] = ((float)Math.sin(((Float)((SpinnerNumberModel)this.az.getModel()).getValue()).floatValue() * 3.141592653589793D / 180.0D));
/* 204 */     rotz[4] = (-rotz[1]);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 213 */     setTransformMatrix(myutil.mat4x4Mult(myutil.mat4x4Mult(myutil.mat4x4Mult(this.tmpmatr, rotx), roty), rotz));
/* 214 */     changePosition();
/*     */   }
/*     */   
/*     */   private void changePosition()
/*     */   {
/* 219 */     this.coord.val[0] = ((Float)((SpinnerNumberModel)this.cx.getModel()).getValue()).floatValue();
/* 220 */     this.coord.val[1] = ((Float)((SpinnerNumberModel)this.cy.getModel()).getValue()).floatValue();
/* 221 */     this.coord.val[2] = ((Float)((SpinnerNumberModel)this.cz.getModel()).getValue()).floatValue();
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/spaceSystem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
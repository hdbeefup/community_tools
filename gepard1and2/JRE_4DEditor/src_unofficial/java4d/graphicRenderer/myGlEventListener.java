/*     */ package java4d.graphicRenderer;
/*     */ 
/*     */ import com.sun.opengl.util.GLUT;
/*     */ import java.util.LinkedList;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java4d.datatypes.myVertex;
/*     */ import java4d.datatypes.vector3f;
/*     */ import java4d.sections.data.INDIdata;
/*     */ import java4d.sections.data.LITEdata;
/*     */ import java4d.sections.data.MESHdata;
/*     */ import java4d.sections.data.PONTdata;
/*     */ import java4d.sections.data.SPOTdata;
/*     */ import java4d.sections.data.VERTdata;
/*     */ import java4d.sections.sect;
/*     */ import java4d.sections.sectDUMY;
/*     */ import java4d.sections.sectFACE;
/*     */ import java4d.sections.sectFLYZ;
/*     */ import java4d.sections.sectINDI;
/*     */ import java4d.sections.sectLITE;
/*     */ import java4d.sections.sectMESH;
/*     */ import java4d.sections.sectPONT;
/*     */ import java4d.sections.sectSKIN;
/*     */ import java4d.sections.sectSPOT;
/*     */ import java4d.sections.sectVERT;
/*     */ import javax.media.opengl.GL;
/*     */ import javax.media.opengl.GLAutoDrawable;
/*     */ import javax.media.opengl.glu.GLU;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class myGlEventListener implements javax.media.opengl.GLEventListener
/*     */ {
/*  34 */   private sect scen = null;
/*  35 */   private GLU glu = new GLU();
/*     */   private JFrame owner;
/*  37 */   private Lock myLock = new java.util.concurrent.locks.ReentrantLock();
/*  38 */   private GLUT glut = new GLUT();
/*  39 */   int transpx; int transpy; int anglex = -20; int angley = -20; int dist = 2000;
/*     */   private sect hlobject;
/*     */   private boolean flyz;
/*  42 */   private boolean updated = false;
/*     */   
/*  44 */   public boolean paintmesh = true; public boolean paintdumy = true; public boolean paintlite = true;
/*     */   
/*     */   public myGlEventListener(JFrame parent)
/*     */   {
/*  48 */     this.owner = parent;
/*     */   }
/*     */   
/*     */   public void updateRendering()
/*     */   {
/*  53 */     this.updated = false;
/*     */   }
/*     */   
/*     */   public void setHighlightedObject(sect h)
/*     */   {
/*  58 */     this.hlobject = h;
/*  59 */     updateRendering();
/*     */   }
/*     */   
/*     */   public void init(GLAutoDrawable drawable) {
/*  63 */     GL gl = drawable.getGL();
/*     */     
/*  65 */     gl.glClearColor(0.9137255F, 0.8901961F, 1.0F, 0.0F);
/*  66 */     gl.glClearDepth(1.0D);
/*     */     
/*  68 */     gl.glDepthFunc(515);
/*  69 */     gl.glEnable(2929);
/*  70 */     gl.glEnable(2884);
/*  71 */     initLighting(gl);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initLighting(GL gl)
/*     */   {
/*  79 */     float[] LightAmbient = { 0.5F, 0.5F, 0.5F, 1.0F };
/*  80 */     float[] LightDiffuse = { 0.7F, 0.7F, 0.7F, 1.0F };
/*  81 */     float[] LightSpecular = { 0.8F, 0.8F, 0.8F, 1.0F };
/*  82 */     float[] LightPosition = { 5.0F, 5.0F, 20.0F, 1.0F };
/*  83 */     gl.glLightfv(16384, 4608, LightAmbient, 0);
/*  84 */     gl.glLightfv(16384, 4609, LightDiffuse, 0);
/*  85 */     gl.glLightfv(16384, 4610, LightSpecular, 0);
/*  86 */     gl.glLightfv(16384, 4611, LightPosition, 0);
/*  87 */     gl.glEnable(16384);
/*  88 */     gl.glEnable(2896);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
/*     */   {
/*  95 */     GL gl = drawable.getGL();
/*  96 */     int[] curmode = new int[1];
/*  97 */     gl.glGetIntegerv(2976, curmode, 0);
/*     */     
/*  99 */     gl.glMatrixMode(5889);
/* 100 */     gl.glLoadIdentity();
/* 101 */     float aspect = width / height;
/*     */     
/* 103 */     this.glu.gluPerspective(45.0D, aspect, 0.009999999776482582D, -1.0D);
/* 104 */     gl.glViewport(x, y, width, height);
/*     */     
/*     */ 
/* 107 */     gl.glMatrixMode(curmode[0]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void display(GLAutoDrawable drawable)
/*     */   {
/* 115 */     GL gl = drawable.getGL();
/* 116 */     gl.glClear(16640);
/*     */     
/* 118 */     gl.glPushMatrix();
/*     */     
/* 120 */     gl.glTranslatef(-this.transpx * 5, this.transpy * 5, -this.dist);
/*     */     
/* 122 */     gl.glRotatef(-this.angley, 1.0F, 0.0F, 0.0F);
/* 123 */     gl.glRotatef(-this.anglex, 0.0F, 1.0F, 0.0F);
/*     */     
/* 125 */     gl.glPushMatrix();
/*     */     
/* 127 */     drawAxis(gl, this.dist * 50);
/*     */     
/* 129 */     if ((!this.updated) && (this.scen != null)) {
/* 130 */       this.myLock.lock();
/*     */       try {
/* 132 */         gl.glDeleteLists(1, 3);
/* 133 */         if (this.paintmesh) drawMESH(gl);
/* 134 */         if (this.paintdumy) drawDUMY(gl, 0.5F);
/* 135 */         if (this.paintlite) drawLITE(gl, 1.0F);
/*     */       } finally {
/* 137 */         this.flyz = (this.scen.getChildrenType(sectFLYZ.class) != null);
/*     */         
/* 139 */         this.myLock.unlock();
/*     */       }
/*     */     }
/*     */     
/* 143 */     this.updated = true;
/*     */     
/* 145 */     gl.glMaterialf(1028, 5633, 15.0F);
/* 146 */     gl.glEnable(2903);
/*     */     
/* 148 */     if (this.flyz) gl.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 149 */     gl.glColorMaterial(1028, 5634);
/*     */     
/* 151 */     if (gl.glIsList(1))
/*     */     {
/* 153 */       float[] mat_spec_mesh = { 0.3F, 0.9F, 0.9F, 1.0F };
/* 154 */       float[] mat_ambi_mesh = { 0.0F, 0.0F, 0.0F, 1.0F };
/* 155 */       gl.glMaterialfv(1028, 5634, mat_ambi_mesh, 0);
/* 156 */       gl.glMaterialfv(1028, 4610, mat_spec_mesh, 0);
/* 157 */       gl.glCallList(1);
/*     */     }
/*     */     
/* 160 */     if (gl.glIsList(2))
/*     */     {
/* 162 */       float[] mat_spec_dumy = { 0.9F, 0.5F, 0.3F, 1.0F };
/* 163 */       float[] mat_ambi_dumy = { 0.2F, 0.2F, 0.2F, 1.0F };
/* 164 */       gl.glMaterialfv(1028, 5634, mat_ambi_dumy, 0);
/* 165 */       gl.glMaterialfv(1028, 4610, mat_spec_dumy, 0);
/* 166 */       gl.glCallList(2);
/*     */     }
/*     */     
/* 169 */     if (gl.glIsList(3))
/*     */     {
/* 171 */       float[] mat_spec_lite = { 0.0F, 0.0F, 0.0F, 0.0F };
/* 172 */       float[] mat_diff_lite = { 0.7F, 0.7F, 0.7F, 1.0F };
/* 173 */       float[] mat_ambi_lite = { 0.5F, 0.5F, 0.5F, 1.0F };
/* 174 */       gl.glMaterialfv(1028, 4608, mat_ambi_lite, 0);
/* 175 */       gl.glMaterialfv(1028, 4609, mat_diff_lite, 0);
/* 176 */       gl.glMaterialfv(1028, 4610, mat_spec_lite, 0);
/* 177 */       gl.glMaterialf(1028, 5633, 0.0F);
/* 178 */       gl.glCallList(3);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 183 */     gl.glPopMatrix();
/* 184 */     gl.glPopMatrix();
/*     */     
/* 186 */     gl.glFlush();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void drawPontLamp(GL gl, float size, float maxDist)
/*     */   {
/* 193 */     gl.glBlendFunc(770, 771);
/* 194 */     gl.glHint(3154, 4354);
/*     */     
/* 196 */     gl.glEnable(3042);
/* 197 */     gl.glPushMatrix();
/* 198 */     gl.glScalef(1.0F, 1.0F, 0.8F);
/* 199 */     gl.glTranslatef(0.0F, 0.0F, 25.0F * size);
/* 200 */     gl.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 201 */     this.glut.glutSolidCone(10.0F * size, 25.0F * size, 8, 1);
/* 202 */     gl.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
/* 203 */     this.glut.glutSolidCone(10.0F * size, 4.0F * size, 8, 1);
/* 204 */     gl.glTranslatef(0.0F, 0.0F, -25.0F * size);
/* 205 */     gl.glPopMatrix();
/* 206 */     this.glut.glutSolidSphere(maxDist, 80, 80);
/* 207 */     gl.glDisable(3042);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void draw3Cones(GL gl, float size)
/*     */   {
/* 215 */     gl.glPushMatrix();
/* 216 */     this.glut.glutSolidCone(15.0F * size, 40.0F * size, 8, 1);
/* 217 */     gl.glTranslatef(5.0F * size, 0.0F, 10.0F * size);
/* 218 */     gl.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 219 */     this.glut.glutSolidCone(6.0F * size, 20.0F * size, 8, 1);
/* 220 */     gl.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
/* 221 */     gl.glTranslatef(-5.0F * size, 0.0F, 10.0F * size);
/* 222 */     gl.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 223 */     this.glut.glutSolidCone(6.0F * size, 20.0F * size, 8, 1);
/* 224 */     gl.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void drawConeRobot(GL gl, float size)
/*     */   {
/* 232 */     gl.glPushMatrix();
/* 233 */     gl.glScalef(1.0F, 1.0F, 0.8F);
/* 234 */     gl.glTranslatef(0.0F, 0.0F, 25.0F * size);
/* 235 */     gl.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 236 */     this.glut.glutSolidCone(10.0F * size, 25.0F * size, 8, 1);
/* 237 */     gl.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
/* 238 */     this.glut.glutSolidCone(10.0F * size, 4.0F * size, 8, 1);
/* 239 */     gl.glTranslatef(0.0F, 0.0F, -25.0F * size);
/*     */     
/* 241 */     gl.glTranslatef(2.0F * size, 0.0F, 10.0F * size);
/* 242 */     gl.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
/* 243 */     this.glut.glutSolidCone(3.0F * size, 14.0F * size, 8, 1);
/* 244 */     gl.glRotatef(-100.0F, 0.0F, 1.0F, 0.0F);
/* 245 */     gl.glTranslatef(-4.0F * size, 0.0F, 0.0F);
/* 246 */     gl.glRotatef(-100.0F, 0.0F, 1.0F, 0.0F);
/* 247 */     this.glut.glutSolidCone(3.0F * size, 14.0F * size, 8, 1);
/*     */     
/*     */ 
/* 250 */     gl.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
/* 251 */     gl.glTranslatef(2.0F * size, 0.0F, 8.0F * size);
/* 252 */     gl.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 253 */     this.glut.glutSolidCone(4.0F * size, 20.0F * size, 8, 1);
/* 254 */     gl.glPopMatrix();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void drawSpotLight(GL gl, float size, float spotCutoff, float maxDist)
/*     */   {
/* 262 */     gl.glBlendFunc(770, 771);
/* 263 */     gl.glHint(3154, 4354);
/*     */     
/* 265 */     gl.glEnable(3042);
/* 266 */     gl.glPushMatrix();
/* 267 */     this.glut.glutSolidCylinder(8.0F * size, 0.0D, 50, 15);
/* 268 */     gl.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 269 */     this.glut.glutSolidCylinder(8.0F * size, 8.0F * size, 50, 15);
/* 270 */     gl.glTranslatef(0.0F, 0.0F, 15.0F * size);
/*     */     
/* 272 */     this.glut.glutSolidCone(15.0F * size, 0.0D, 40, 15);
/* 273 */     gl.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 274 */     this.glut.glutSolidCone(15.0F * size, 15.0F * size, 40, 15);
/* 275 */     gl.glTranslatef(0.0F, 0.0F, 15.0F * size - maxDist);
/* 276 */     this.glut.glutSolidCone(Math.tan(spotCutoff) * maxDist / 2.0D, maxDist, 50, 5);
/* 277 */     gl.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 278 */     this.glut.glutSolidCone(Math.tan(spotCutoff) * maxDist / 2.0D, 0.10000000149011612D, 50, 5);
/* 279 */     gl.glPopMatrix();
/* 280 */     gl.glDisable(3042);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void drawAxis(GL gl, float len)
/*     */   {
/* 288 */     float[] mat_diff = { 1.0F, 1.0F, 1.0F, 1.0F };
/* 289 */     gl.glMaterialfv(1028, 5634, mat_diff, 0);
/*     */     
/* 291 */     gl.glEnable(2903);
/* 292 */     gl.glColorMaterial(1028, 5634);
/*     */     
/* 294 */     gl.glLineWidth(1.0F);
/*     */     
/* 296 */     gl.glBlendFunc(770, 771);
/* 297 */     gl.glHint(3154, 4354);
/*     */     
/*     */ 
/*     */ 
/* 301 */     gl.glBegin(1);
/* 302 */     gl.glColor3f(1.0F, 0.0F, 0.0F);
/* 303 */     gl.glVertex3f(-len, 0.0F, 0.0F);
/* 304 */     gl.glVertex3f(len, 0.0F, 0.0F);
/* 305 */     gl.glColor3f(0.0F, 1.0F, 0.0F);
/* 306 */     gl.glVertex3f(0.0F, -len, 0.0F);
/* 307 */     gl.glVertex3f(0.0F, len, 0.0F);
/* 308 */     gl.glColor3f(0.0F, 0.0F, 1.0F);
/* 309 */     gl.glVertex3f(0.0F, 0.0F, -len);
/* 310 */     gl.glVertex3f(0.0F, 0.0F, len);
/* 311 */     gl.glEnd();
/* 312 */     gl.glDisable(3042);
/* 313 */     gl.glDisable(2848);
/*     */   }
/*     */   
/*     */ 
/*     */   private void transformMatrix(sect s, GL gl)
/*     */   {
/*     */     try
/*     */     {
/* 321 */       int parentEnt = s.getSectionData().getClass().getField("parentEntityId").getInt(s.getSectionData());
/*     */       
/* 323 */       if (parentEnt != -1) {
/* 324 */         Class[] arg = { sectMESH.class, sectDUMY.class, sectLITE.class, java4d.sections.sectBSP_.class, java4d.sections.sectSKVS.class, sectSKIN.class };
/*     */         
/* 326 */         transformMatrix((sect)s.getParent().getChildrenType(arg).get(parentEnt), gl);
/*     */       }
/* 328 */       gl.glMultMatrixf(((MESHdata)s.getSectionData()).space.getTransformMatrix(), 0);
/*     */     } catch (IllegalArgumentException ex) {
/* 330 */       Logger.getLogger(myGlEventListener.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 332 */       Logger.getLogger(myGlEventListener.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (NoSuchFieldException ex) {
/* 334 */       Logger.getLogger(myGlEventListener.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (SecurityException ex) {
/* 336 */       Logger.getLogger(myGlEventListener.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized void setScene(sect Scene)
/*     */   {
/* 344 */     this.myLock.lock();
/*     */     try {
/* 346 */       this.scen = Scene;
/*     */     } finally {
/* 348 */       this.myLock.unlock();
/*     */     }
/* 350 */     updateRendering();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void drawMESH(GL gl)
/*     */   {
/* 357 */     if (this.scen != null) {
/* 358 */       LinkedList l = this.scen.getChildrenType(sectMESH.class);
/* 359 */       gl.glNewList(1, 4864);
/* 360 */       for (int i = 0; (l != null) && (i < l.size()); i++) {
/* 361 */         sectMESH m = (sectMESH)l.get(i);
/* 362 */         VERTdata vdata = (VERTdata)((sectVERT)m.getChildrenType(sectVERT.class).get(0)).getSectionData();
/*     */         INDIdata idata;
/* 364 */         INDIdata idata; if (m.getChildrenTypeCount(sectINDI.class) > 0) {
/* 365 */           idata = (INDIdata)((sectINDI)m.getChildrenType(sectINDI.class).get(0)).getSectionData();
/*     */         } else {
/* 367 */           idata = (INDIdata)((sectFACE)m.getChildrenType(sectFACE.class).get(0)).getSectionData();
/*     */         }
/*     */         
/* 370 */         gl.glColor4f(0.5F, 0.5F, 0.5F, 0.3F);
/* 371 */         if (m == this.hlobject) {
/* 372 */           gl.glColor4f(0.0F, 0.5F, 0.9F, 0.3F);
/*     */         }
/* 374 */         gl.glPushMatrix();
/*     */         
/* 376 */         transformMatrix(m, gl);
/*     */         
/* 378 */         if (m.isStripe()) {
/* 379 */           gl.glBegin(5);
/*     */         } else {
/* 381 */           gl.glBegin(4);
/*     */         }
/*     */         
/* 384 */         for (int j = 0; j < idata.ind.length; j++) {
/* 385 */           gl.glNormal3fv(vdata.vert[idata.ind[j]].normal.val, 0);
/* 386 */           gl.glVertex3fv(vdata.vert[idata.ind[j]].coord.val, 0);
/*     */         }
/* 388 */         gl.glEnd();
/* 389 */         gl.glPopMatrix();
/*     */       }
/* 391 */       gl.glEndList();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void drawDUMY(GL gl, float dumysize)
/*     */   {
/* 399 */     if (this.scen != null) {
/* 400 */       LinkedList l = this.scen.getChildrenType(sectDUMY.class);
/* 401 */       gl.glNewList(2, 4864);
/* 402 */       for (int i = 0; (l != null) && (i < l.size()); i++) {
/* 403 */         sectDUMY d = (sectDUMY)l.get(i);
/*     */         
/*     */ 
/* 406 */         gl.glColor4f(0.5F, 0.35F, 0.2F, 0.3F);
/*     */         
/* 408 */         gl.glPushMatrix();
/*     */         
/* 410 */         transformMatrix(d, gl);
/*     */         
/* 412 */         if (d == this.hlobject)
/*     */         {
/* 414 */           gl.glColor4f(0.9F, 0.1F, 0.0F, 0.3F);
/* 415 */           drawConeRobot(gl, dumysize * 3.0F);
/*     */         }
/*     */         else {
/* 418 */           drawConeRobot(gl, dumysize);
/*     */         }
/* 420 */         gl.glPopMatrix();
/*     */       }
/* 422 */       gl.glEndList();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void drawLITE(GL gl, float litesize)
/*     */   {
/* 430 */     if (this.scen != null) {
/* 431 */       LinkedList l = this.scen.getChildrenType(sectLITE.class);
/* 432 */       gl.glNewList(3, 4864);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 437 */       for (int i = 0; (l != null) && (i < l.size()); i++) {
/* 438 */         sectLITE lt = (sectLITE)l.get(i);
/* 439 */         LITEdata ltdata = (LITEdata)lt.getSectionData();
/*     */         
/*     */ 
/*     */ 
/* 443 */         gl.glColorMaterial(1032, 5634);
/* 444 */         gl.glColor4f(ltdata.lightColor.val[0], ltdata.lightColor.val[1], ltdata.lightColor.val[2], 0.3F);
/*     */         
/*     */ 
/*     */ 
/* 448 */         gl.glPushMatrix();
/*     */         
/* 450 */         transformMatrix(lt, gl);
/*     */         
/* 452 */         if (lt.getChildrenTypeCount(sectSPOT.class) > 0)
/*     */         {
/* 454 */           SPOTdata spdata = (SPOTdata)((sect)lt.getChildren().get(0)).getSectionData();
/* 455 */           if (lt == this.hlobject) {
/* 456 */             gl.glColor4f(ltdata.lightColor.val[0] * 1.3F, ltdata.lightColor.val[1] * 1.3F, ltdata.lightColor.val[2] * 1.3F, 0.8F);
/*     */             
/*     */ 
/* 459 */             drawSpotLight(gl, litesize * 1.7F, spdata.spotCutoff, spdata.coneLen);
/*     */           } else {
/* 461 */             drawSpotLight(gl, litesize, spdata.spotCutoff, spdata.coneLen);
/*     */           }
/* 463 */         } else if (lt.getChildrenTypeCount(sectPONT.class) > 0)
/*     */         {
/* 465 */           PONTdata ptdata = (PONTdata)((sect)lt.getChildren().get(0)).getSectionData();
/* 466 */           if (lt == this.hlobject) {
/* 467 */             gl.glColor4f(ltdata.lightColor.val[0] * 1.3F, ltdata.lightColor.val[1] * 1.3F, ltdata.lightColor.val[2] * 1.3F, 0.8F);
/*     */             
/*     */ 
/* 470 */             drawPontLamp(gl, litesize * 1.7F, ptdata.maxDist);
/*     */           } else {
/* 472 */             drawPontLamp(gl, litesize * 1.7F, ptdata.maxDist);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 477 */         gl.glPopMatrix();
/*     */       }
/* 479 */       gl.glEndList();
/*     */     }
/*     */   }
/*     */   
/*     */   public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/graphicRenderer/myGlEventListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
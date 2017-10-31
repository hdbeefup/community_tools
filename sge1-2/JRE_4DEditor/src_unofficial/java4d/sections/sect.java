/*     */ package java4d.sections;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import java4d.my4dfile.SizeMismatchException;
/*     */ import java4d.my4dfile.sectListManager;
/*     */ import java4d.myutil;
/*     */ import java4d.sections.data.sectData;
/*     */ import java4d.sections.editors.sectEditor;
/*     */ import java4d.sections.editors.sectMenu;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class sect
/*     */ {
/*     */   protected LinkedList<sect> sectList;
/*     */   protected sectData sdata;
/*     */   protected sect parent;
/*     */   protected sectEventListener listener;
/*     */   
/*     */   public sect(sect myparent)
/*     */   {
/*  30 */     this.parent = myparent;
/*  31 */     this.sectList = null;
/*     */   }
/*     */   
/*     */   public sect getParent()
/*     */   {
/*  36 */     return this.parent;
/*     */   }
/*     */   
/*     */   public int getVersion()
/*     */   {
/*  41 */     return this.parent.getVersion();
/*     */   }
/*     */   
/*     */   public sectEventListener getEventListener()
/*     */   {
/*  46 */     if (this.parent == null) {
/*  47 */       return this.listener;
/*     */     }
/*  49 */     return this.parent.getEventListener();
/*     */   }
/*     */   
/*     */   public void setEventListener(sectEventListener l)
/*     */   {
/*  54 */     if (this.parent == null) {
/*  55 */       this.listener = l;
/*     */     } else {
/*  57 */       this.parent.setEventListener(l);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTitle()
/*     */   {
/*  63 */     return getClass().getSimpleName().substring(4);
/*     */   }
/*     */   
/*     */   public String getTipDetails()
/*     */   {
/*  68 */     return getTitle();
/*     */   }
/*     */   
/*     */   public int getSize()
/*     */   {
/*  73 */     int ret = 8;
/*  74 */     ret += this.sdata.getSize();
/*  75 */     if (this.sectList != null)
/*  76 */       for (int i = 0; i < this.sectList.size(); i++)
/*  77 */         ret += ((sect)this.sectList.get(i)).getSize();
/*  78 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   public int toBytes(byte[] dest, int offset)
/*     */   {
/*  84 */     int written = 0;
/*  85 */     if (getSize() <= dest.length - offset)
/*     */     {
/*  87 */       System.arraycopy(getTitle().getBytes(), 0, dest, offset, 4);
/*  88 */       myutil.putInt(getSize() - 8, dest, offset + 4);
/*     */       
/*  90 */       System.arraycopy(this.sdata.getData(), 0, dest, offset + 8, this.sdata.getSize());
/*  91 */       written += this.sdata.getSize() + 8;
/*  92 */       if (this.sectList != null)
/*  93 */         for (int i = 0; i < this.sectList.size(); i++)
/*     */         {
/*  95 */           ((sect)this.sectList.get(i)).toBytes(dest, offset + written);
/*  96 */           written += ((sect)this.sectList.get(i)).getSize();
/*     */         }
/*     */     }
/*  99 */     return written;
/*     */   }
/*     */   
/*     */   public sectData getSectionData() {
/* 103 */     return this.sdata;
/*     */   }
/*     */   
/*     */   public boolean loadData(byte[] data, int offset) throws SizeMismatchException, Exception
/*     */   {
/* 108 */     int tsize = myutil.getInt(data, offset + 4);
/* 109 */     int consumed = this.sdata.loadData(data, offset + 4);
/* 110 */     if (tsize - consumed > 0) {
/* 111 */       this.sectList = sectListManager.getList(data, offset + 8 + consumed, tsize - consumed, this);
/*     */     }
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   public LinkedList<sect> getChildren()
/*     */   {
/* 118 */     return this.sectList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LinkedList<sect> getChildrenType(Class type)
/*     */   {
/* 128 */     LinkedList<sect> ret = null;
/* 129 */     if (this.sectList != null) {
/* 130 */       ret = new LinkedList();
/* 131 */       for (int i = 0; i < this.sectList.size(); i++) {
/* 132 */         if (((sect)this.sectList.get(i)).getClass() == type) {
/* 133 */           ret.add(this.sectList.get(i));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 138 */       if (ret.size() == 0) {
/* 139 */         ret = null;
/*     */       }
/*     */     }
/*     */     
/* 143 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LinkedList<sect> getChildrenTypeAndDerived(Class type)
/*     */   {
/* 153 */     LinkedList<sect> ret = null;
/* 154 */     if (this.sectList != null) {
/* 155 */       ret = new LinkedList();
/* 156 */       for (int i = 0; i < this.sectList.size(); i++) {
/* 157 */         if (type.isInstance(this.sectList.get(i)))
/*     */         {
/* 159 */           ret.add(this.sectList.get(i));
/*     */         }
/*     */       }
/*     */       
/* 163 */       if (ret.size() == 0) {
/* 164 */         ret = null;
/*     */       }
/*     */     }
/*     */     
/* 168 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LinkedList<sect> getChildrenType(Class[] type)
/*     */   {
/* 178 */     LinkedList<sect> ret = null;
/* 179 */     if (this.sectList != null) {
/* 180 */       ret = new LinkedList();
/* 181 */       for (int i = 0; i < this.sectList.size(); i++) {
/* 182 */         for (int j = 0; j < type.length; j++) {
/* 183 */           if (((sect)this.sectList.get(i)).getClass() == type[j]) {
/* 184 */             ret.add(this.sectList.get(i));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 191 */       if (ret.size() == 0) {
/* 192 */         ret = null;
/*     */       }
/*     */     }
/*     */     
/* 196 */     return ret;
/*     */   }
/*     */   
/*     */   public int getChildrenTypeCount(Class type)
/*     */   {
/* 201 */     int ret = 0;
/* 202 */     if (this.sectList != null) {
/* 203 */       for (int i = 0; i < this.sectList.size(); i++) {
/* 204 */         ret += (((sect)this.sectList.get(i)).getClass() == type ? 1 : 0);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 210 */     return ret;
/*     */   }
/*     */   
/*     */   public int getChildrenTypeCount(Class[] type)
/*     */   {
/* 215 */     int ret = 0;
/* 216 */     if (this.sectList != null) {
/* 217 */       for (int i = 0; i < this.sectList.size(); i++) {
/* 218 */         for (int j = 0; j < type.length; j++) {
/* 219 */           ret += (((sect)this.sectList.get(i)).getClass() == type[j] ? 1 : 0);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 227 */     return ret;
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
/*     */   public void showEditor()
/*     */   {
/* 270 */     Thread t = new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 238 */         sectData bak = sect.this.getSectionData().clone();
/*     */         
/* 240 */         sectEditor editor = sect.this.getEditFrame();
/* 241 */         if (editor == null) {
/* 242 */           return;
/*     */         }
/*     */         
/* 245 */         int choice = 2;
/*     */         do {
/* 247 */           editor.setVisible(true);
/*     */           try {
/* 249 */             Thread.currentThread().join();
/*     */           } catch (InterruptedException ex) {
/* 251 */             choice = JOptionPane.showConfirmDialog(null, "Confirm changes?");
/*     */           }
/*     */           
/* 254 */         } while ((choice == 2) || (choice == -1));
/*     */         
/* 256 */         if (choice != 0)
/*     */         {
/*     */ 
/*     */ 
/* 260 */           sect.this.sdata = bak;
/*     */         }
/*     */         
/* 263 */         if (sect.this.getEventListener() != null) {
/* 264 */           sect.this.getEventListener().dataChanged();
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/* 270 */     });
/* 271 */     t.setName("editorLoaderThread");
/* 272 */     t.start();
/*     */   }
/*     */   
/*     */   protected sectEditor getEditFrame()
/*     */   {
/* 277 */     sectEditor ret = null;
/*     */     try {
/* 279 */       ret = (sectEditor)Class.forName("java4d.sections.editors." + getTitle() + "editor").getConstructor(new Class[] { sectData.class }).newInstance(new Object[] { getSectionData() });
/*     */     }
/*     */     catch (InstantiationException ex)
/*     */     {
/* 283 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 285 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalArgumentException ex) {
/* 287 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InvocationTargetException ex) {
/* 289 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (NoSuchMethodException ex) {
/* 291 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (SecurityException ex) {
/* 293 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     catch (ClassNotFoundException ex) {}
/*     */     
/* 297 */     return ret;
/*     */   }
/*     */   
/*     */   public JMenu getEditMenu() {
/* 301 */     sectMenu ret = null;
/*     */     
/*     */     try
/*     */     {
/* 305 */       ret = (sectMenu)Class.forName("java4d.sections.editors." + getTitle() + "menu").getConstructor(new Class[] { sect.class }).newInstance(new Object[] { this });
/*     */     }
/*     */     catch (InvocationTargetException ex) {
/* 308 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (NoSuchMethodException ex) {
/* 310 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (SecurityException ex) {
/* 312 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalArgumentException ex) {
/* 314 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 316 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 318 */       Logger.getLogger(sect.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 322 */       ret = new sectMenu(this);
/*     */     }
/* 324 */     return ret.getMenu();
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
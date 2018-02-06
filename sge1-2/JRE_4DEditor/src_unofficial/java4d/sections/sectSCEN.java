/*     */ package java4d.sections;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java4d.sections.data.MESHdata;
/*     */ import java4d.sections.data.SCENdata;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class sectSCEN
/*     */   extends sect
/*     */ {
/*     */   private SCENdata sdatacasted;
/*     */   
/*     */   public sectSCEN(sect parent)
/*     */   {
/*  22 */     super(null);
/*  23 */     this.sdata = new SCENdata(this);
/*  24 */     this.sdatacasted = ((SCENdata)this.sdata);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getVersion()
/*     */   {
/*  30 */     return this.sdatacasted.getVersionInt();
/*     */   }
/*     */   
/*     */   public String getVersionStr()
/*     */   {
/*  35 */     return this.sdatacasted.getVersionStr();
/*     */   }
/*     */   
/*     */ 
/*     */   public String getTipDetails()
/*     */   {
/*  41 */     return new String("SCEN - Version: " + this.sdatacasted.getVersionStr());
/*     */   }
/*     */   
/*     */   public void deleteChild(sect cursect)
/*     */   {
/*  46 */     if (sectMESH.class.isInstance(cursect))
/*     */     {
/*  48 */       deleteHierarchy((sectMESH)cursect);
/*     */     } else {
/*  50 */       this.sectList.remove(cursect);
/*     */     }
/*     */   }
/*     */   
/*     */   private void deleteHierarchy(sectMESH cursect)
/*     */   {
/*  56 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/*  57 */     int curId = l.indexOf(cursect);
/*  58 */     if (curId != -1)
/*     */     {
/*  60 */       for (sect s : l)
/*     */       {
/*  62 */         if (((sectMESH)s).sdatacasted.parentEntityId == curId)
/*  63 */           deleteHierarchy((sectMESH)s);
/*  64 */         sectMESH k = (sectMESH)s;
/*  65 */         if ((k.sdatacasted.parentEntityId != -1) && (k.sdatacasted.parentEntityId > curId))
/*  66 */           k.sdatacasted.parentEntityId -= 1;
/*     */       }
/*  68 */       this.sectList.remove(cursect);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isNewParentValid(sectMESH s, int newParentId)
/*     */   {
/*  74 */     boolean ret = true;
/*     */     
/*  76 */     if (newParentId == -1) { return true;
/*     */     }
/*  78 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/*  79 */     if (newParentId >= l.size()) { return false;
/*     */     }
/*  81 */     int curId = l.indexOf(s);
/*  82 */     if (newParentId == curId) { return false;
/*     */     }
/*  84 */     sectMESH tmp = (sectMESH)l.get(newParentId);
/*     */     
/*  86 */     while ((ret) && (tmp.sdatacasted.parentEntityId != -1))
/*     */     {
/*  88 */       tmp = (sectMESH)l.get(tmp.sdatacasted.parentEntityId);
/*  89 */       if (tmp == s) { ret = false;
/*     */       }
/*     */     }
/*  92 */     return ret;
/*     */   }
/*     */   
/*     */   public LinkedList<sectMESH> getValidParents(sectMESH s)
/*     */   {
/*  97 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/*  98 */     LinkedList<sectMESH> ret = new LinkedList();
/*  99 */     if (l != null) {
/* 100 */       for (sect t : l)
/*     */       {
/* 102 */         if (isNewParentValid(s, getEntityId((sectMESH)t)))
/* 103 */           ret.add((sectMESH)t); }
/*     */     }
/* 105 */     return ret;
/*     */   }
/*     */   
/*     */   public int getEntityId(sectMESH s)
/*     */   {
/* 110 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/* 111 */     return l.indexOf(s);
/*     */   }
/*     */   
/*     */   public void addObjectAt(sectMESH child, int pos)
/*     */   {
/* 116 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/*     */     
/* 118 */     if (l != null) {
/* 119 */       int lastindex = this.sectList.indexOf(l.getLast());
/* 120 */       int firstindex = this.sectList.indexOf(l.getFirst());
/*     */       
/* 122 */       if (pos < 0) {
/* 123 */         pos = 0;
/*     */       }
/*     */       
/* 126 */       if (pos > lastindex - firstindex) {
/* 127 */         pos = lastindex - firstindex;
/*     */       }
/*     */       
/*     */ 
/* 131 */       if (pos + firstindex >= this.sectList.size()) {
/* 132 */         this.sectList.add(child);
/*     */       } else {
/* 134 */         this.sectList.add(pos + firstindex, child);
/* 135 */         l = getChildrenTypeAndDerived(sectMESH.class);
/* 136 */         for (sect s : l) {
/* 137 */           sectMESH m = (sectMESH)s;
/* 138 */           if (m.sdatacasted.parentEntityId >= pos) {
/* 139 */             m.sdatacasted.parentEntityId += 1;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 145 */       this.sectList.add(child);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getFirstObjectIndex()
/*     */   {
/* 151 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/* 152 */     if (l != null)
/* 153 */       return this.sectList.indexOf(l.getFirst());
/* 154 */     return this.sectList.size() - 1;
/*     */   }
/*     */   
/*     */   public int getLastObjectIndex() {
/* 158 */     LinkedList<sect> l = getChildrenTypeAndDerived(sectMESH.class);
/* 159 */     if (l != null)
/* 160 */       return this.sectList.indexOf(l.getLast());
/* 161 */     return this.sectList.size() - 1;
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/sectSCEN.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*     */ package pakfile;
/*     */ 
/*     */ import java.util.LinkedList;
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
/*     */ public class pakTree
/*     */ {
/*     */   pakFileListener listener;
/*     */   pakFileListItem[] filelist;
/*     */   
/*     */   public pakTree(pakFileListener f_listener, pakFileListItem[] file_list)
/*     */   {
/*  25 */     this.listener = f_listener;
/*  26 */     this.filelist = file_list;
/*     */   }
/*     */   
/*     */   public LinkedList<pakItem> getItems()
/*     */   {
/*  31 */     LinkedList<pakItem> l = new LinkedList();
/*  32 */     build_tree(0, this.filelist.length - 1, null, l);
/*     */     
/*  34 */     phase2(l);
/*     */     
/*  36 */     return l;
/*     */   }
/*     */   
/*     */   private int build_tree(int p, int q, pakItem parent, LinkedList<pakItem> l)
/*     */   {
/*  41 */     int ret = 0;
/*  42 */     int cur_idx = (q + p) / 2;
/*  43 */     pakItem el = new pakItem();
/*  44 */     l.add(el);
/*  45 */     el.fptr = this.filelist[cur_idx].file;
/*  46 */     el.hasleft = (q - p <= 1 ? 0 : 1);
/*     */     
/*     */ 
/*     */ 
/*  50 */     el.initchars = 0;
/*  51 */     el.path = this.filelist[cur_idx].path;
/*  52 */     el.name = this.filelist[cur_idx].path.substring(el.initchars, el.path.length());
/*  53 */     el.dataoffset = this.filelist[cur_idx].dataoffset;
/*  54 */     this.listener.writeIsAdvancing(l.size() * 100 / this.filelist.length, "Building search tree (phase 1)...");
/*     */     
/*  56 */     if (q > p)
/*     */     {
/*  58 */       if (el.hasleft == 1) ret += build_tree(p, cur_idx - 1, el, l) - 1;
/*  59 */       el.nextptr = (l.size() + ret);
/*  60 */       ret += build_tree(cur_idx + 1, q, null, l);
/*     */     }
/*     */     else {
/*  63 */       el.nextptr = 0L;
/*  64 */       ret++;
/*     */     }
/*     */     
/*  67 */     return ret;
/*     */   }
/*     */   
/*     */   private void phase2(LinkedList<pakItem> l)
/*     */   {
/*  72 */     int counter = 0;
/*  73 */     int cnt2 = 0;
/*  74 */     for (pakItem i : l)
/*     */     {
/*  76 */       i.offset = counter;
/*  77 */       counter += i.name.length() + 15;
/*  78 */       this.listener.writeIsAdvancing(cnt2++ * 100 / l.size(), "Building search tree (phase 2)...");
/*     */     }
/*     */     
/*  81 */     cnt2 = 0;
/*  82 */     for (pakItem i : l)
/*     */     {
/*  84 */       this.listener.writeIsAdvancing(cnt2++ * 100 / l.size(), "Building search tree (phase 3)...");
/*  85 */       i.nextptr = ((pakItem)l.get((int)i.nextptr)).offset;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int common_chars(String s_parent, String s_child)
/*     */   {
/*  93 */     int i = 1;
/*  94 */     int slen = s_parent.length() > s_child.length() ? s_child.length() : s_parent.length();
/*  95 */     boolean check = true;
/*  97 */     for (; 
/*  97 */         (i < slen) && (check); i++) {
/*  98 */       check = s_child.startsWith(s_parent.substring(0, i));
/*     */     }
/* 100 */     return i - 2;
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/pakTree.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
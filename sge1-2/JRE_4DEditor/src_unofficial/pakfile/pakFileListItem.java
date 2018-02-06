/*    */ package pakfile;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class pakFileListItem
/*    */   implements Comparable
/*    */ {
/*    */   public String path;
/*    */   public long size;
/* 20 */   public File file = null;
/*    */   
/*    */   public pakFileListItem(String fpath, long fsize, File f_file) {
/*    */     try {
/* 24 */       this.path = new String(fpath);
/* 25 */       this.size = fsize;
/* 26 */       if (f_file != null) {
/* 27 */         this.file = new File(f_file.getCanonicalPath());
/*    */       }
/*    */     } catch (IOException ex) {
/* 30 */       Logger.getLogger(pakFileListItem.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 36 */     return new String(this.path + " " + this.size);
/*    */   }
/*    */   
/*    */   public int compareTo(Object o)
/*    */   {
/* 41 */     return this.path.toLowerCase().compareTo(((pakFileListItem)o).path.toLowerCase());
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/pakfile/pakFileListItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
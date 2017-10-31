/*    */ package pakfile;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class pakItem
/*    */ {
/*    */   public int initchars;
/*    */   public String name;
/*    */   public String path;
/*    */   public long dataoffset;
/*    */   public long offset;
/*    */   public int hasleft;
/*    */   public long nextptr;
/*    */   public File fptr;
/*    */   
/*    */   public String toString()
/*    */   {
/* 26 */     return new String("" + this.initchars + " - " + this.name);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/pakItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
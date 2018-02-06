/*    */ package java4d.my4dfile;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import java4d.sections.sect;
/*    */ import utilities.rFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class my4dFileManager
/*    */ {
/*    */   public static sect loadFile(File fobj)
/*    */     throws Not4dFileException, SizeMismatchException, Exception
/*    */   {
/* 18 */     sect s = null;
/*    */     
/* 20 */     rFile f = new rFile(fobj, "r");
/* 21 */     byte[] title = new byte[4];
/*    */     
/*    */ 
/*    */ 
/* 25 */     if ((f.readIntLE() != 454718035) || (f.readIntLE() != 176622093))
/*    */     {
/* 27 */       throw new Not4dFileException();
/*    */     }
/*    */     
/* 30 */     f.read(title);
/* 31 */     int size = f.readIntLE();
/* 32 */     f.moveCursor(-8L);
/*    */     
/*    */ 
/* 35 */     byte[] data = new byte[size + 8];
/* 36 */     f.read(data);
/*    */     
/* 38 */     s = sectListManager.getSect(data, 0, new String(title), null);
/*    */     
/* 40 */     f.close();
/*    */     
/* 42 */     return s;
/*    */   }
/*    */   
/*    */ 
/*    */   public static void saveFile(File fobj, sect s)
/*    */   {
/* 48 */     if (s != null) {
/*    */       try {
/* 50 */         rFile f = new rFile(fobj, "rw");
/* 51 */         f.setLength(0L);
/* 52 */         f.writeIntLE(454718035);
/* 53 */         f.writeIntLE(176622093);
/*    */         
/* 55 */         byte[] buf = new byte[s.getSize()];
/* 56 */         s.toBytes(buf, 0);
/*    */         
/* 58 */         f.write(buf);
/* 59 */         f.close();
/*    */       } catch (FileNotFoundException ex) {
/* 61 */         Logger.getLogger(my4dFileManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */       } catch (IOException ex) {
/* 63 */         Logger.getLogger(my4dFileManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/my4dfile/my4dFileManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
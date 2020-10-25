/*    */ package pakfile;
/*    */ 
/*    */ import java.awt.Frame;
/*    */ import java.io.File;
/*    */ import javax.swing.JFileChooser;
/*    */ import javax.swing.filechooser.FileNameExtensionFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class myutil
/*    */ {
/* 14 */   static String lastpathload = null;
/* 15 */   static String lastpathsave = null;
/*    */   
/* 17 */   public static int getInt(byte[] data, int offset) { int ch1 = data[offset] & 0xFF;
/* 18 */     int ch2 = data[(offset + 1)] & 0xFF;
/* 19 */     int ch3 = data[(offset + 2)] & 0xFF;
/* 20 */     int ch4 = data[(offset + 3)] & 0xFF;
/* 21 */     return (ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0);
/*    */   }
/*    */   
/*    */   public static void putInt(int val, byte[] data, int offset) {
/* 25 */     data[offset] = ((byte)(val >>> 0 & 0xFF));
/* 26 */     data[(offset + 1)] = ((byte)(val >>> 8 & 0xFF));
/* 27 */     data[(offset + 2)] = ((byte)(val >>> 16 & 0xFF));
/* 28 */     data[(offset + 3)] = ((byte)(val >>> 24 & 0xFF));
/*    */   }
/*    */   
/*    */   public static int getShort(byte[] data, int offset) {
/* 32 */     int ch1 = data[offset] & 0xFF;
/* 33 */     int ch2 = data[(offset + 1)] & 0xFF;
/* 34 */     return (ch2 << 8) + (ch1 << 0);
/*    */   }
/*    */   
/*    */   public static void putShort(int val, byte[] data, int offset) {
/* 38 */     data[offset] = ((byte)(val >>> 0 & 0xFF));
/* 39 */     data[(offset + 1)] = ((byte)(val >>> 8 & 0xFF));
/*    */   }
/*    */   
/*    */   public static void putFloat(float val, byte[] data, int offset) {
/* 43 */     putInt(Float.floatToIntBits(val), data, offset);
/*    */   }
/*    */   
/*    */   public static float getFloat(byte[] data, int offset) {
/* 47 */     return Float.intBitsToFloat(getInt(data, offset));
/*    */   }
/*    */   
/* 50 */   public static long getLong(byte[] data, int offset) { return (getInt(data, offset + 4) << 32) + (getInt(data, offset) & 0xFFFFFFFF); }
/*    */   
/*    */   public static void putLong(long val, byte[] data, int offset) {
/* 53 */     data[offset] = ((byte)(int)(val >>> 0 & 0xFF));
/* 54 */     data[(offset + 1)] = ((byte)(int)(val >>> 8 & 0xFF));
/* 55 */     data[(offset + 2)] = ((byte)(int)(val >>> 16 & 0xFF));
/* 56 */     data[(offset + 3)] = ((byte)(int)(val >>> 24 & 0xFF));
/* 57 */     data[(offset + 4)] = ((byte)(int)(val >>> 32 & 0xFF));
/* 58 */     data[(offset + 5)] = ((byte)(int)(val >>> 40 & 0xFF));
/* 59 */     data[(offset + 6)] = ((byte)(int)(val >>> 48 & 0xFF));
/* 60 */     data[(offset + 7)] = ((byte)(int)(val >>> 56 & 0xFF));
/*    */   }
/*    */   
/*    */   public static File fileOpen(Frame parent, String typename, String ext) {
/* 64 */     JFileChooser chooser = new JFileChooser();
/* 65 */     FileNameExtensionFilter filter = new FileNameExtensionFilter(typename, new String[] { ext });
/*    */     
/* 67 */     chooser.setFileFilter(filter);
/* 68 */     chooser.setCurrentDirectory(lastpathload != null ? new File(lastpathload) : null);
/* 69 */     int returnVal = chooser.showOpenDialog(parent);
/* 70 */     if (returnVal == 0) {
/* 71 */       lastpathload = chooser.getSelectedFile().getPath();
/* 72 */       return chooser.getSelectedFile();
/*    */     }
/* 74 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static File fileSave(Frame parent, String typename, String ext)
/*    */   {
/* 81 */     JFileChooser chooser = new JFileChooser();
/* 82 */     FileNameExtensionFilter filter = new FileNameExtensionFilter(typename, new String[] { ext });
/*    */     
/* 84 */     chooser.setFileFilter(filter);
/* 85 */     chooser.setCurrentDirectory(lastpathsave != null ? new File(lastpathsave) : null);
/* 86 */     int returnVal = chooser.showSaveDialog(parent);
/*    */     
/* 88 */     if (returnVal == 0)
/*    */     {
/* 90 */       String fn = chooser.getSelectedFile().getPath();
/* 91 */       if (!fn.toUpperCase().endsWith("." + ext.toUpperCase()))
/*    */       {
/* 93 */         fn = fn + "." + ext;
/* 94 */         chooser.setSelectedFile(new File(fn));
/*    */       }
/* 96 */       lastpathsave = chooser.getSelectedFile().getPath();
/* 97 */       return chooser.getSelectedFile();
/*    */     }
/* 99 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/myutil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
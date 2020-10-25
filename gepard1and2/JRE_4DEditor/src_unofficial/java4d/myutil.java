/*     */ package java4d;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Frame;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.GraphicsDevice;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.awt.Rectangle;
/*     */ import java.io.File;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class myutil
/*     */ {
/*  19 */   public static final Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
/*  20 */   static String lastpathload = null;
/*  21 */   static String lastpathsave = null;
/*     */   
/*  23 */   public static int getInt(byte[] data, int offset) { int ch1 = data[offset] & 0xFF;
/*  24 */     int ch2 = data[(offset + 1)] & 0xFF;
/*  25 */     int ch3 = data[(offset + 2)] & 0xFF;
/*  26 */     int ch4 = data[(offset + 3)] & 0xFF;
/*  27 */     return (ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0);
/*     */   }
/*     */   
/*     */   public static void putInt(int val, byte[] data, int offset) {
/*  31 */     data[offset] = ((byte)(val >>> 0 & 0xFF));
/*  32 */     data[(offset + 1)] = ((byte)(val >>> 8 & 0xFF));
/*  33 */     data[(offset + 2)] = ((byte)(val >>> 16 & 0xFF));
/*  34 */     data[(offset + 3)] = ((byte)(val >>> 24 & 0xFF));
/*     */   }
/*     */   
/*     */   public static int getShort(byte[] data, int offset) {
/*  38 */     int ch1 = data[offset] & 0xFF;
/*  39 */     int ch2 = data[(offset + 1)] & 0xFF;
/*  40 */     return (ch2 << 8) + (ch1 << 0);
/*     */   }
/*     */   
/*     */   public static void putShort(int val, byte[] data, int offset) {
/*  44 */     data[offset] = ((byte)(val >>> 0 & 0xFF));
/*  45 */     data[(offset + 1)] = ((byte)(val >>> 8 & 0xFF));
/*     */   }
/*     */   
/*     */   public static void putFloat(float val, byte[] data, int offset) {
/*  49 */     putInt(Float.floatToIntBits(val), data, offset);
/*     */   }
/*     */   
/*     */   public static float getFloat(byte[] data, int offset) {
/*  53 */     return Float.intBitsToFloat(getInt(data, offset));
/*     */   }
/*     */   
/*  56 */   public static long getLong(byte[] data, int offset) { return (getInt(data, offset + 4) << 32) + (getInt(data, offset) & 0xFFFFFFFF); }
/*     */   
/*     */   public static void putLong(long val, byte[] data, int offset) {
/*  59 */     data[offset] = ((byte)(int)(val >>> 0 & 0xFF));
/*  60 */     data[(offset + 1)] = ((byte)(int)(val >>> 8 & 0xFF));
/*  61 */     data[(offset + 2)] = ((byte)(int)(val >>> 16 & 0xFF));
/*  62 */     data[(offset + 3)] = ((byte)(int)(val >>> 24 & 0xFF));
/*  63 */     data[(offset + 4)] = ((byte)(int)(val >>> 32 & 0xFF));
/*  64 */     data[(offset + 5)] = ((byte)(int)(val >>> 40 & 0xFF));
/*  65 */     data[(offset + 6)] = ((byte)(int)(val >>> 48 & 0xFF));
/*  66 */     data[(offset + 7)] = ((byte)(int)(val >>> 56 & 0xFF));
/*     */   }
/*     */   
/*     */   public static File fileOpen(Frame parent, String typename, String ext) {
/*  70 */     JFileChooser chooser = new JFileChooser();
/*  71 */     FileNameExtensionFilter filter = new FileNameExtensionFilter(typename, new String[] { ext });
/*     */     
/*  73 */     chooser.setFileFilter(filter);
/*  74 */     chooser.setCurrentDirectory(lastpathload != null ? new File(lastpathload) : null);
/*  75 */     int returnVal = chooser.showOpenDialog(parent);
/*  76 */     if (returnVal == 0) {
/*  77 */       lastpathload = chooser.getSelectedFile().getPath();
/*  78 */       return chooser.getSelectedFile();
/*     */     }
/*  80 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static File fileSave(Frame parent, String typename, String ext)
/*     */   {
/*  87 */     JFileChooser chooser = new JFileChooser();
/*  88 */     FileNameExtensionFilter filter = new FileNameExtensionFilter(typename, new String[] { ext });
/*     */     
/*  90 */     chooser.setFileFilter(filter);
/*  91 */     chooser.setCurrentDirectory(lastpathsave != null ? new File(lastpathsave) : null);
/*  92 */     int returnVal = chooser.showSaveDialog(parent);
/*  93 */     if (returnVal == 0)
/*     */     {
/*  95 */       String fn = chooser.getSelectedFile().getPath();
/*  96 */       if (!fn.toUpperCase().endsWith("." + ext.toUpperCase()))
/*     */       {
/*  98 */         fn = fn + "." + ext;
/*  99 */         chooser.setSelectedFile(new File(fn));
/*     */       }
/* 101 */       lastpathsave = chooser.getSelectedFile().getPath();
/* 102 */       return chooser.getSelectedFile();
/*     */     }
/* 104 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void packPanel(JPanel p, int width)
/*     */   {
/* 110 */     int minh = 0;
/* 111 */     for (Component c : p.getComponents())
/*     */     {
/* 113 */       minh = (int)(minh + c.getMinimumSize().getHeight());
/*     */     }
/*     */     
/* 116 */     p.setMinimumSize(new Dimension(width, minh));
/* 117 */     p.setMaximumSize(new Dimension(width, minh));
/*     */   }
/*     */   
/*     */ 
/*     */   public static float[] mat4x4Mult(float[] a, float[] b)
/*     */   {
/* 123 */     float[] ret = new float[16];
/*     */     
/* 125 */     for (int i = 0; i < 16; i++)
/*     */     {
/* 127 */       float ij = 0.0F;
/* 128 */       for (int j = 0; j < 4; j++) {
/* 129 */         ij += a[(i - i % 4 + j)] * b[(i % 4 + j * 4)];
/*     */       }
/* 131 */       ret[i] = ij;
/*     */     }
/* 133 */     return ret;
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/myutil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
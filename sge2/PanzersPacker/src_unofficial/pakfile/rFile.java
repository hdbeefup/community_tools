/*    */ package pakfile;
/*    */ 
/*    */ import java.io.EOFException;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.io.RandomAccessFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class rFile
/*    */   extends RandomAccessFile
/*    */ {
/*    */   public rFile(String name, String mode)
/*    */     throws FileNotFoundException
/*    */   {
/* 21 */     super(name, mode);
/*    */   }
/*    */   
/*    */   public rFile(File name, String mode) throws FileNotFoundException {
/* 25 */     super(name, mode);
/*    */   }
/*    */   
/*    */   public final int readIntLE() throws IOException {
/* 29 */     int ch1 = read();
/* 30 */     int ch2 = read();
/* 31 */     int ch3 = read();
/* 32 */     int ch4 = read();
/* 33 */     if ((ch1 | ch2 | ch3 | ch4) < 0)
/* 34 */       throw new EOFException();
/* 35 */     return (ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0);
/*    */   }
/*    */   
/*    */   public final short readShortLE() throws IOException {
/* 39 */     int ch1 = read();
/* 40 */     int ch2 = read();
/* 41 */     if ((ch1 | ch2) < 0)
/* 42 */       throw new EOFException();
/* 43 */     return (short)((ch2 << 8) + (ch1 << 0));
/*    */   }
/*    */   
/*    */   public final int readUnsignedShortLE() throws IOException {
/* 47 */     int ch1 = read();
/* 48 */     int ch2 = read();
/* 49 */     if ((ch1 | ch2) < 0)
/* 50 */       throw new EOFException();
/* 51 */     return (ch2 << 8) + (ch1 << 0);
/*    */   }
/*    */   
/*    */   public final long readLongLE() throws IOException {
/* 55 */     return readInt() & 4294967295L + readInt() << 32;
/*    */   }
/*    */   
/*    */   public final float readFloatLE() throws IOException {
/* 59 */     return Float.intBitsToFloat(readIntLE());
/*    */   }
/*    */   
/*    */   public final void writeIntLE(int v) throws IOException {
/* 63 */     write(v >>> 0 & 0xFF);
/* 64 */     write(v >>> 8 & 0xFF);
/* 65 */     write(v >>> 16 & 0xFF);
/* 66 */     write(v >>> 24 & 0xFF);
/*    */   }
/*    */   
/*    */   public final void writeFloatLE(float v) throws IOException {
/* 70 */     writeIntLE(Float.floatToIntBits(v));
/*    */   }
/*    */   
/*    */   public final void moveCursor(long steps) throws IOException
/*    */   {
/* 75 */     seek(steps + getFilePointer());
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/rFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
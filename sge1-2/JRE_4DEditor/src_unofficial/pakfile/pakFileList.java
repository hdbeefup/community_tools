/*     */ package pakfile;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.TreeSet;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import utilities.rFile;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class pakFileList
/*     */ {
/*     */   private pakFileListener listener;
/*     */   private TreeSet<pakFileListItem> filelist;
/*     */   
/*     */   public pakFileList(final File path, pakFileListener f_listener)
/*     */   {
/*  60 */     this.listener = f_listener;
/*  61 */     this.filelist = new TreeSet();
/*  62 */     if (path.isDirectory()) {
/*  63 */       new Runnable()
/*     */       {
/*     */         Thread t;
/*  30 */         long counter = 0L;
/*     */         
/*     */ 
/*     */ 
/*     */         long filecount;
/*     */         
/*     */ 
/*     */ 
/*     */         public void run()
/*     */         {
/*  40 */           this.filecount = this.this$0.getFileCount(path);
/*  41 */           populatelist("", path);
/*  42 */           this.this$0.listener.readStopped();
/*     */         }
/*     */         
/*  45 */         private void populatelist(String basepath, File cur) { File[] l = cur.listFiles();
/*  46 */           if (l != null) {
/*  47 */             for (int i = 0; i < l.length; i++) {
/*  48 */               this.this$0.listener.readIsAdvancing(++this.counter * 100L / this.filecount);
/*  49 */               if (l[i].isFile()) {
/*  50 */                 this.this$0.filelist.add(new pakFileListItem(basepath + l[i].getName(), l[i].length(), l[i]));
/*     */               } else {
/*  52 */                 this.this$0.filelist.add(new pakFileListItem(basepath + l[i].getName(), 0L, null));
/*  53 */                 populatelist(basepath + l[i].getName() + '/', l[i]);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  64 */     this.listener.readStarted();
/*     */   }
/*     */   
/*     */ 
/*     */   private int getFileCount(File cur)
/*     */   {
/*  70 */     int ret = 0;
/*  71 */     File[] l = cur.listFiles();
/*  72 */     if (l != null) {
/*  73 */       for (int i = 0; i < l.length; ret++) {
/*  74 */         if (l[i].isDirectory()) {
/*  75 */           ret += getFileCount(l[i]);
/*     */         }
/*  73 */         i++;
/*     */       }
/*     */     }
/*     */     
/*  77 */     return ret;
/*     */   }
/*     */   
/*     */   public int getRecordCount()
/*     */   {
/*  82 */     return this.filelist.size();
/*     */   }
/*     */   
/*     */   public long getFilesDataSize()
/*     */   {
/*  87 */     long ret = 0L;
/*  88 */     pakFileListItem[] l = (pakFileListItem[])this.filelist.toArray(new pakFileListItem[0]);
/*  89 */     for (int i = 0; i < l.length; i++)
/*  90 */       ret += l[i].size;
/*  91 */     return ret;
/*     */   }
/*     */   
/*     */   public int getNamesSize()
/*     */   {
/*  96 */     int ret = 0;
/*  97 */     pakFileListItem[] l = (pakFileListItem[])this.filelist.toArray(new pakFileListItem[0]);
/*  98 */     for (int i = 0; i < l.length; i++)
/*  99 */       ret += l[i].path.length() + 15;
/* 100 */     return ret;
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
/*     */   public void writeFile(final File out)
/*     */   {
/* 176 */     if (out != null)
/*     */     {
/* 178 */       Thread t = new Thread(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/*     */           try
/*     */           {
/* 110 */             rFile f = new rFile(out, "rw");
/* 111 */             long totalsize = this.this$0.getFilesDataSize() + this.this$0.getNamesSize();
/*     */             
/* 113 */             f.setLength(totalsize);
/* 114 */             f.writeIntLE(454718035);
/* 115 */             f.writeIntLE(176622093);
/* 116 */             f.write("PACK".getBytes(), 0, 4);
/* 117 */             f.writeIntLE(this.this$0.getNamesSize());
/*     */             
/* 119 */             long done = 16L;
/*     */             
/* 121 */             pakFileListItem[] t = (pakFileListItem[])this.this$0.filelist.toArray(new pakFileListItem[0]);
/* 122 */             int offset = 0;
/* 123 */             int headoffset = 0;
/* 124 */             for (int i = 0; i < t.length; i++)
/*     */             {
/* 126 */               f.writeByte(0);
/* 127 */               if (t[i].path.length() > 255) {
/* 128 */                 throw new IOException("Panic: Pathname > 255");
/*     */               }
/* 130 */               f.writeByte(t[i].path.length());
/* 131 */               f.writeBytes(t[i].path);
/* 132 */               f.writeIntLE(offset);
/*     */               
/* 134 */               if (t[i].file != null) {
/* 135 */                 if (t[i].file.length() > 536870912L) {
/* 136 */                   throw new IOException("Panic: Filesize > 512 MB");
/*     */                 }
/* 138 */                 f.writeIntLE((int)t[i].file.length());
/* 139 */                 offset += (int)t[i].file.length();
/*     */               } else {
/* 141 */                 f.writeIntLE(0);
/*     */               }
/*     */               
/* 144 */               headoffset += t[i].path.length() + 15;
/* 145 */               f.writeByte(i < t.length - 1 ? 1 : 0);
/* 146 */               f.writeIntLE(i < t.length - 1 ? headoffset : 0);
/* 147 */               done = headoffset;
/* 148 */               if (this.this$0.listener != null) {
/* 149 */                 this.this$0.listener.writeIsAdvancing(done * 100L / totalsize);
/*     */               }
/*     */             }
/*     */             
/* 153 */             for (int i = 0; i < t.length; i++) {
/* 154 */               if (t[i].file != null) {
/* 155 */                 rFile inputfile = new rFile(t[i].file, "r");
/* 156 */                 int inputlen = (int)t[i].file.length();
/* 157 */                 byte[] buf = new byte[inputlen];
/* 158 */                 inputfile.read(buf);
/* 159 */                 f.write(buf);
/* 160 */                 inputfile.close();
/* 161 */                 done += inputlen;
/* 162 */                 if (this.this$0.listener != null) {
/* 163 */                   this.this$0.listener.writeIsAdvancing(done * 100L / totalsize);
/*     */                 }
/*     */               }
/*     */             }
/* 167 */             f.close();
/*     */           }
/*     */           catch (IOException ex) {
/* 170 */             Logger.getLogger(pakFileList.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/* 173 */           this.this$0.listener.writeStopped();
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 179 */       });
/* 180 */       t.setName("pakWriter");
/* 181 */       t.start();
/* 182 */       this.listener.writeStarted();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setListener(pakFileListener plistener)
/*     */   {
/* 188 */     this.listener = plistener;
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/pakfile/pakFileList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
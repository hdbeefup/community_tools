/*     */ package pakfile;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.TreeSet;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JOptionPane;
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
/*     */ public class pakFileList
/*     */ {
/*     */   private pakFileListener listener;
/*     */   private pakFileListItem[] filelist;
/*     */   
/*     */   public pakFileList(final File path, pakFileListener f_listener)
/*     */   {
/*  69 */     this.listener = f_listener;
/*     */     
/*  71 */     if ((path != null) && (path.isDirectory()))
/*     */     {
/*     */ 
/*  74 */       Thread t = new Thread(new Runnable()
/*     */       {
/*  32 */         long counter = 0L;
/*  33 */         long datacounter = 0L;
/*     */         long filecount;
/*     */         
/*     */         public void run() {
/*  37 */           this.this$0.listener.readIsAdvancing(0L, "Parsing directory tree, please wait...");
/*  38 */           this.filecount = this.this$0.getFileCount(path);
/*  39 */           TreeSet<pakFileListItem> flist = new TreeSet();
/*  40 */           populatelist("", path, flist);
/*  41 */           for (pakFileListItem i : flist)
/*     */           {
/*  43 */             i.dataoffset = this.datacounter;
/*  44 */             if (!i.file.isDirectory()) { this.datacounter += i.file.length();
/*     */             }
/*     */           }
/*  47 */           this.this$0.filelist = ((pakFileListItem[])flist.toArray(new pakFileListItem[0]));
/*  48 */           this.this$0.listener.readStopped();
/*     */         }
/*     */         
/*     */         private void populatelist(String basepath, File cur, TreeSet<pakFileListItem> flist) {
/*  52 */           File[] l = cur.listFiles();
/*  53 */           if (l != null) {
/*  54 */             for (int i = 0; i < l.length; i++) {
/*  55 */               this.this$0.listener.readIsAdvancing(++this.counter * 100L / this.filecount, "Reading files...");
/*  56 */               pakFileListItem el = new pakFileListItem(basepath + l[i].getName(), l[i]);
/*  57 */               flist.add(el);
/*  58 */               if (l[i].isDirectory()) {
/*  59 */                 populatelist(basepath + l[i].getName() + '/', l[i], flist);
/*     */ 
/*     */ 
/*     */               }
/*     */               
/*     */ 
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  75 */       });
/*  76 */       t.start();
/*  77 */       if (this.listener != null) {
/*  78 */         this.listener.readStarted();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private int getFileCount(File cur)
/*     */   {
/*  86 */     int ret = 0;
/*  87 */     File[] l = cur.listFiles();
/*  88 */     if (l != null) {
/*  89 */       for (int i = 0; i < l.length; ret++) {
/*  90 */         if (l[i].isDirectory()) {
/*  91 */           ret += getFileCount(l[i]);
/*     */         }
/*  89 */         i++;
/*     */       }
/*     */     }
/*     */     
/*  93 */     return ret;
/*     */   }
/*     */   
/*     */   public int getRecordCount()
/*     */   {
/*  98 */     return this.filelist.length;
/*     */   }
/*     */   
/*     */   public long getFilesDataSize()
/*     */   {
/* 103 */     long ret = 0L;
/* 104 */     for (int i = 0; i < this.filelist.length; i++)
/* 105 */       if (!this.filelist[i].file.isDirectory()) ret += this.filelist[i].file.length();
/* 106 */     return ret;
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
/*     */   public void writeFile(final File out, final boolean encrypt)
/*     */   {
/* 220 */     if (out != null)
/*     */     {
/* 222 */       Thread t = new Thread(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 124 */           pakTree t = new pakTree(this.this$0.listener, this.this$0.filelist);
/* 125 */           LinkedList<pakItem> l = t.getItems();
/*     */           try {
/* 127 */             rFile f = new rFile(out, "rw");
/* 128 */             long namesSize = ((pakItem)l.getLast()).offset + ((pakItem)l.getLast()).name.length() + 15L;
/* 129 */             long totalsize = this.this$0.getFilesDataSize() + namesSize;
/*     */             
/* 131 */             f.setLength(totalsize + 16L);
/* 132 */             f.writeIntLE(454718035);
/* 133 */             f.writeIntLE(176622093);
/* 134 */             f.write("PACK".getBytes(), 0, 4);
/* 135 */             f.writeIntLE((int)namesSize);
/*     */             
/* 137 */             long done = 16L;
/*     */             
/* 139 */             int offset = 0;
/* 140 */             int headoffset = 0;
/*     */             
/* 142 */             for (pakItem i : l)
/*     */             {
/* 144 */               f.write(i.initchars);
/* 145 */               f.write(i.name.length());
/* 146 */               f.write(i.name.getBytes());
/* 147 */               f.writeIntLE((int)i.dataoffset);
/* 148 */               f.writeIntLE((int)i.fptr.length());
/* 149 */               f.write(i.hasleft);
/* 150 */               f.writeIntLE((int)i.nextptr);
/* 151 */               offset += (int)i.fptr.length();
/* 152 */               done += i.name.length() + 15;
/* 153 */               this.this$0.listener.writeIsAdvancing(done * 100L / totalsize, "Writing PAK search tree...");
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 158 */             for (int i = 0; i < this.this$0.filelist.length; i++) {
/* 159 */               if (!this.this$0.filelist[i].file.isDirectory()) {
/* 160 */                 rFile inputfile = new rFile(this.this$0.filelist[i].file, "r");
/* 161 */                 int inputlen = (int)this.this$0.filelist[i].file.length();
/* 162 */                 byte[] buf = new byte[inputlen];
/* 163 */                 inputfile.read(buf);
/* 164 */                 f.write(buf);
/*     */                 
/* 166 */                 inputfile.close();
/* 167 */                 done += inputlen;
/* 168 */                 if (this.this$0.listener != null) {
/* 169 */                   this.this$0.listener.writeIsAdvancing(done * 100L / totalsize, "Writing PAK data...");
/*     */                 }
/*     */               }
/*     */             }
/*     */             
/* 174 */             if (encrypt)
/*     */             {
/* 176 */               f.seek(3L);
/* 177 */               f.writeByte(28);
/*     */               
/* 179 */               f.seek(16L);
/*     */               
/* 181 */               int bufsize = 4096;
/* 182 */               byte[] buf = new byte['က'];
/*     */               
/* 184 */               long datalen = f.length() - 16L;
/* 185 */               long blocks = datalen / 4096L;
/*     */               
/* 187 */               for (long i = 0L; i < blocks; i += 1L)
/*     */               {
/* 189 */                 this.this$0.listener.writeIsAdvancing(i * 100L * 4096L / datalen, "Encrypting PAK file...");
/* 190 */                 f.read(buf);
/* 191 */                 for (int j = 0; j < 4096; j++)
/* 192 */                   buf[j] = ((byte)(buf[j] + 66));
/* 193 */                 f.moveCursor(-4096L);
/* 194 */                 f.write(buf);
/*     */               }
/*     */               
/* 197 */               for (long i = 0L; i < datalen % 4096L; i += 1L)
/*     */               {
/* 199 */                 this.this$0.listener.writeIsAdvancing((i + blocks * 4096L) * 100L / datalen, "Encrypting PAK file...");
/* 200 */                 int tmp = f.read() + 66;
/*     */                 
/* 202 */                 f.moveCursor(-1L);
/* 203 */                 f.writeByte(tmp);
/*     */               }
/*     */             }
/*     */             
/* 207 */             f.close();
/*     */           }
/*     */           catch (IOException ex)
/*     */           {
/* 211 */             Logger.getLogger(pakFileList.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           finally
/*     */           {
/* 215 */             this.this$0.listener.writeStopped();
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         
/*     */ 
/* 223 */       });
/* 224 */       t.setName("pakWriter");
/* 225 */       t.start();
/* 226 */       this.listener.writeStarted();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setListener(pakFileListener plistener)
/*     */   {
/* 232 */     this.listener = plistener;
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
/*     */   public static void decryptFile(File target, final pakFileListener s_listener)
/*     */   {
/* 293 */     Thread t = new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         try
/*     */         {
/* 243 */           rFile f = new rFile(this.val$target, "rw");
/* 244 */           f.seek(3L);
/* 245 */           if (f.read() != 28) {
/* 246 */             JOptionPane.showMessageDialog(null, "The selected file cannot be decrypted.", "Error", 0);
/* 247 */             s_listener.aborted("Cannot proceed.");
/* 248 */             f.close();
/*     */           }
/*     */           else
/*     */           {
/* 252 */             f.seek(3L);
/* 253 */             f.writeByte(27);
/* 254 */             f.seek(16L);
/*     */             
/* 256 */             int bufsize = 4096;
/* 257 */             byte[] buf = new byte['က'];
/* 258 */             long datalen = f.length() - 16L;
/* 259 */             long blocks = datalen / 4096L;
/* 260 */             for (long i = 0L; i < blocks; i += 1L) {
/* 261 */               if (s_listener != null) {
/* 262 */                 s_listener.writeIsAdvancing(i * 100L * 4096L / datalen, "Decrypting PAK file...");
/*     */               }
/*     */               
/* 265 */               f.read(buf);
/* 266 */               for (int j = 0; j < 4096; j++) {
/* 267 */                 buf[j] = ((byte)(buf[j] + 256 - 66));
/*     */               }
/* 269 */               f.moveCursor(-4096L);
/* 270 */               f.write(buf);
/*     */             }
/* 272 */             for (long i = 0L; i < datalen % 4096L; i += 1L) {
/* 273 */               if (s_listener != null) {
/* 274 */                 s_listener.writeIsAdvancing((i + blocks * 4096L) * 100L / datalen, "Decrypting PAK file...");
/*     */               }
/*     */               
/* 277 */               int tmp = f.read() + 256 - 66;
/* 278 */               f.moveCursor(-1L);
/* 279 */               f.writeByte(tmp);
/*     */             }
/* 281 */             f.close();
/*     */           }
/* 283 */         } catch (IOException ex) { Logger.getLogger(pakFileList.class.getName()).log(Level.SEVERE, null, ex);
/*     */         } finally {
/* 285 */           if (s_listener != null) {
/* 286 */             s_listener.writeStopped();
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/* 294 */     });
/* 295 */     t.setName("pakDecrypter");
/* 296 */     t.start();
/* 297 */     if (s_listener != null) {
/* 298 */       s_listener.writeStarted();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/pakFileList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java4d.datatypes.infoLabel;
/*    */ import java4d.datatypes.spaceSystem;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.sect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MESHdata
/*    */   extends sectData
/*    */ {
/*    */   public infoLabel desc;
/* 20 */   public int parentEntityId = -1;
/*    */   public spaceSystem space;
/*    */   
/*    */   public MESHdata(sect owner)
/*    */   {
/* 25 */     super(owner);
/* 26 */     this.desc = new infoLabel();
/* 27 */     this.space = new spaceSystem();
/*    */   }
/*    */   
/*    */   public int getSize()
/*    */   {
/* 32 */     int ret = this.desc.dataSize() + 4 + this.space.dataSize();
/*    */     
/*    */ 
/*    */ 
/* 36 */     if (this.owner.getVersion() == 101) ret += 8;
/* 37 */     return ret;
/*    */   }
/*    */   
/*    */   public byte[] getData()
/*    */   {
/* 42 */     byte[] ret = new byte[getSize()];
/* 43 */     int offset = 0;
/*    */     
/* 45 */     this.desc.toBytes(ret, offset);
/* 46 */     offset += this.desc.dataSize();
/*    */     
/* 48 */     myutil.putInt(this.parentEntityId, ret, offset);
/* 49 */     offset += 4;
/*    */     
/* 51 */     if (this.owner.getVersion() == 101)
/*    */     {
/* 53 */       myutil.putInt(-1, ret, offset);
/* 54 */       myutil.putInt(-1, ret, offset + 4);
/* 55 */       offset += 8;
/*    */     }
/*    */     
/* 58 */     this.space.toBytes(ret, offset);
/* 59 */     return ret;
/*    */   }
/*    */   
/*    */   public int loadData(byte[] data, int offset)
/*    */   {
/* 64 */     int loaded = 4;
/*    */     
/* 66 */     this.desc.getFrom(data, offset + loaded);
/* 67 */     loaded += this.desc.dataSize();
/*    */     
/* 69 */     this.parentEntityId = myutil.getInt(data, offset + loaded);
/* 70 */     loaded += 4;
/*    */     
/* 72 */     if (this.owner.getVersion() == 101) { loaded += 8;
/*    */     }
/* 74 */     this.space.getFrom(data, offset + loaded);
/* 75 */     loaded += this.space.dataSize();
/*    */     
/* 77 */     return loaded - 4;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/MESHdata.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package java4d.datatypes;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java4d.myutil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class bone
/*    */   extends myDataType
/*    */ {
/*    */   public int dumyid;
/*    */   public spaceSystem space;
/*    */   
/*    */   public bone()
/*    */   {
/* 22 */     this.space = new spaceSystem();
/*    */   }
/*    */   
/*    */   public int dataSize()
/*    */   {
/* 27 */     return 4 + this.space.dataSize();
/*    */   }
/*    */   
/*    */   public void toBytes(byte[] dest, int offset)
/*    */   {
/* 32 */     myutil.putInt(this.dumyid, dest, offset);
/* 33 */     this.space.toBytes(dest, offset + 4);
/*    */   }
/*    */   
/*    */   public void getFrom(byte[] source, int offset)
/*    */   {
/* 38 */     this.dumyid = myutil.getInt(source, offset);
/* 39 */     this.space.getFrom(source, offset + 4);
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 45 */     return new String("Dumy id: " + this.dumyid);
/*    */   }
/*    */   
/*    */ 
/*    */   public bone clone()
/*    */   {
/* 51 */     bone copy = new bone();
/* 52 */     copy.dumyid = this.dumyid;
/* 53 */     copy.space = this.space.clone();
/* 54 */     return copy;
/*    */   }
/*    */   
/*    */   public Component getEditor()
/*    */   {
/* 59 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/datatypes/bone.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
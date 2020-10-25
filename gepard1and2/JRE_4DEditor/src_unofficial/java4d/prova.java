/*    */ package java4d;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class prova
/*    */   implements Serializable
/*    */ {
/*    */   int p1;
/*    */   String p2;
/*    */   transient int p3;
/*    */   cacca cc;
/*    */   
/*    */   public prova(int a, String b, int c)
/*    */   {
/* 51 */     this.p1 = a;
/* 52 */     this.p2 = new String(b);
/* 53 */     this.p3 = c;
/* 54 */     this.cc = new cacca2(22833);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     return new String("" + this.p1 + " " + this.p2 + " " + this.p3 + " " + this.cc.val);
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/prova.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
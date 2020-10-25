/*    */ package utilities;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class stripeConv
/*    */ {
/*    */   public static int[] convertToStripe(LinkedList<int[]> tri)
/*    */   {
/* 18 */     LinkedList<Integer> stripe = new LinkedList();
/* 19 */     System.err.println("Number of faces:" + tri.size() * 3);
/* 20 */     int[] ret = null;
/* 21 */     int i = 0;
/* 22 */     if (tri.size() > 2)
/*    */     {
/* 24 */       int[] tmptri = (int[])tri.removeFirst();
/* 25 */       stripe.add(Integer.valueOf(tmptri[0]));
/* 26 */       stripe.add(Integer.valueOf(tmptri[1]));
/* 27 */       stripe.add(Integer.valueOf(tmptri[2]));
/*    */       
/*    */ 
/*    */ 
/* 31 */       while (tri.size() > 0)
/*    */       {
/* 33 */         int next = findNextVert(tri, ((Integer)stripe.get(stripe.size() - 2)).intValue(), ((Integer)stripe.get(stripe.size() - 1)).intValue(), i % 2);
/*    */         
/* 35 */         if (next != -1)
/*    */         {
/* 37 */           i++;
/* 38 */           stripe.add(Integer.valueOf(next));
/*    */         }
/*    */         else {
/* 41 */           next = findNextVert(tri, ((Integer)stripe.get(0)).intValue(), ((Integer)stripe.get(1)).intValue(), (i - 1) % 2);
/* 42 */           if (next != -1)
/*    */           {
/* 44 */             i++;
/* 45 */             stripe.addFirst(Integer.valueOf(next));
/*    */           }
/*    */           else {
/* 48 */             stripe.add(stripe.get(stripe.size() - 1));
/* 49 */             tmptri = (int[])tri.removeFirst();
/* 50 */             stripe.add(Integer.valueOf(tmptri[0]));
/* 51 */             stripe.add(Integer.valueOf(tmptri[0]));
/* 52 */             stripe.add(Integer.valueOf(tmptri[1]));
/* 53 */             stripe.add(Integer.valueOf(tmptri[2]));
/* 54 */             i += 5;
/*    */           }
/*    */         }
/* 57 */         if (tri.size() % 200 == 0) System.err.println(tri.size() + " indices to go...");
/*    */       }
/* 59 */       ret = new int[stripe.size()];
/* 60 */       for (i = 0; i < ret.length; i++) {
/* 61 */         ret[i] = ((Integer)stripe.get(i)).intValue();
/*    */       }
/*    */     }
/*    */     
/* 65 */     System.err.println("Done!... Number of stripe elements:" + (i + 3));
/* 66 */     return ret;
/*    */   }
/*    */   
/*    */   private static int findNextVert(LinkedList<int[]> tri, int va, int vb, int ord)
/*    */   {
/* 71 */     int tmp = va;
/* 72 */     if (ord == 1)
/*    */     {
/* 74 */       va = vb;
/* 75 */       vb = tmp;
/*    */     }
/* 77 */     for (int i = 0; i < tri.size(); i++)
/*    */     {
/* 79 */       int[] e = (int[])tri.get(i);
/* 80 */       if ((e[0] == va) && (e[2] == vb))
/*    */       {
/* 82 */         return ((int[])tri.remove(i))[1];
/*    */       }
/* 84 */       if ((e[1] == va) && (e[2] == vb))
/*    */       {
/* 86 */         return ((int[])tri.remove(i))[0];
/*    */       }
/* 88 */       if ((e[0] == va) && (e[1] == vb))
/*    */       {
/* 90 */         return ((int[])tri.remove(i))[2];
/*    */       }
/*    */     }
/* 93 */     return -1;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/utilities/stripeConv.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
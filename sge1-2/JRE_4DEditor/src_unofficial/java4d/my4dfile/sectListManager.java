/*    */ package java4d.my4dfile;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.util.LinkedList;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.sect;
/*    */ import java4d.sections.sectUnknown;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectListManager
/*    */ {
/*    */   public static LinkedList<sect> getList(byte[] data, int offset, int toConsume, sect parent)
/*    */     throws SizeMismatchException, Exception
/*    */   {
/* 24 */     int Consumed = 0;
/* 25 */     LinkedList<sect> ret = toConsume - Consumed > 0 ? new LinkedList() : null;
/*    */     
/* 27 */     while (toConsume - Consumed > 0) {
/* 28 */       String title = new String(data, offset + Consumed, 4);
/* 29 */       int size = myutil.getInt(data, offset + Consumed + 4);
/* 30 */       if (size > toConsume - Consumed) {
/* 31 */         throw new SizeMismatchException("Size mismatch in section " + (ret.size() + 1) + "(parent: " + parent.getTitle() + "):  " + title);
/*    */       }
/* 33 */       ret.add(getSect(data, offset + Consumed, title, parent));
/* 34 */       Consumed += 8 + size;
/*    */     }
/* 36 */     return ret;
/*    */   }
/*    */   
/*    */   public static sect getSect(byte[] data, int offset, String title, sect parent)
/*    */     throws SizeMismatchException, Exception
/*    */   {
/* 42 */     sect ret = null;
/*    */     
/*    */     try
/*    */     {
/* 46 */       ret = (sect)Class.forName("java4d.sections.sect" + title).getConstructor(new Class[] { sect.class }).newInstance(new Object[] { parent });
/*    */     }
/*    */     catch (NoSuchMethodException ex)
/*    */     {
/* 50 */       Logger.getLogger(sectListManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (SecurityException ex) {
/* 52 */       Logger.getLogger(sectListManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IllegalArgumentException ex) {
/* 54 */       Logger.getLogger(sectListManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (InvocationTargetException ex) {
/* 56 */       Logger.getLogger(sectListManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     catch (InstantiationException ex) {
/* 59 */       Logger.getLogger(my4dFileManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IllegalAccessException ex) {
/* 61 */       Logger.getLogger(my4dFileManager.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     catch (ClassNotFoundException ex)
/*    */     {
/* 65 */       ret = new sectUnknown(parent);
/*    */     }
/*    */     
/* 68 */     ret.loadData(data, offset);
/* 69 */     return ret;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/my4dfile/sectListManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
/*    */ package pakfile;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public class IconFactory
/*    */ {
/*    */   public static javax.swing.ImageIcon getIcon(String resourceName)
/*    */   {
/*    */     try
/*    */     {
/* 12 */       InputStream input = IconFactory.class.getClassLoader().getResourceAsStream(resourceName);
/* 13 */       byte[] data = new byte[input.available()];
/* 14 */       input.read(data);
/* 15 */       return new javax.swing.ImageIcon(data, resourceName);
/*    */     } catch (IOException e) {
/* 17 */       return null;
/*    */     } catch (NullPointerException e) {}
/* 19 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/IconFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
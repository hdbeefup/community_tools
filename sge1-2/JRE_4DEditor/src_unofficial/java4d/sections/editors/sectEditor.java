/*    */ package java4d.sections.editors;
/*    */ 
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import java4d.myutil;
/*    */ import java4d.sections.data.sectData;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class sectEditor
/*    */   extends JFrame
/*    */ {
/*    */   protected sectData sdata;
/* 18 */   protected final Thread caller = Thread.currentThread();
/*    */   
/*    */   public sectEditor(sectData toEdit)
/*    */   {
/* 22 */     this.sdata = toEdit;
/* 23 */     addWindowListener(new WindowAdapter() {
/*    */       public void windowClosed(WindowEvent evt) {
/* 25 */         sectEditor.this.formWindowClosed(evt);
/*    */       }
/* 27 */     });
/* 28 */     setLocation(myutil.screen.width / 2 - getWidth() / 2, myutil.screen.height / 2 - getHeight() / 2);
/*    */   }
/*    */   
/*    */   private final void formWindowClosed(WindowEvent evt) {
/* 32 */     this.caller.interrupt();
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/editors/sectEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
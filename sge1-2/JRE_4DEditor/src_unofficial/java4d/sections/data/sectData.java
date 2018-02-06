/*    */ package java4d.sections.data;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import java4d.datatypes.myDataType;
/*    */ import java4d.my4dfile.InvalidDataException;
/*    */ import java4d.sections.sect;
/*    */ 
/*    */ public abstract class sectData
/*    */   implements Cloneable
/*    */ {
/*    */   protected sect owner;
/*    */   protected static sect clipboard;
/*    */   
/*    */   public sectData(sect ownerSection)
/*    */   {
/* 20 */     this.owner = ownerSection;
/*    */   }
/*    */   
/*    */   public abstract int getSize();
/*    */   
/*    */   public abstract byte[] getData();
/*    */   
/*    */   public sect getOwner() {
/* 28 */     return this.owner;
/*    */   }
/*    */   
/*    */ 
/*    */   public abstract int loadData(byte[] paramArrayOfByte, int paramInt)
/*    */     throws InvalidDataException;
/*    */   
/*    */ 
/*    */   public void copyFrom(sectData source)
/*    */   {
/* 38 */     if (getClass().isInstance(source)) {
/*    */       try {
/* 40 */         for (Field f : getClass().getFields()) {
/* 41 */           Object val = f.get(source);
/* 42 */           if (myDataType.class.isInstance(val)) {
/* 43 */             f.set(this, ((myDataType)val).clone());
/* 44 */           } else if (val.getClass().isArray()) {
/* 45 */             f.set(this, ((myDataType)val).clone());
/*    */           }
/*    */           else {
/* 48 */             f.set(this, val);
/*    */           }
/*    */         }
/*    */       } catch (SecurityException ex) {
/* 52 */         Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */       } catch (IllegalArgumentException ex) {
/* 54 */         Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */       } catch (IllegalAccessException ex) {
/* 56 */         Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public sectData clone()
/*    */   {
/* 63 */     Object copy = null;
/*    */     try
/*    */     {
/* 66 */       copy = getClass().getConstructor(new Class[] { sect.class }).newInstance(new Object[] { this.owner });
/*    */       
/* 68 */       for (Field f : getClass().getFields()) {
/* 69 */         Object val = f.get(this);
/* 70 */         if (myDataType.class.isInstance(val)) {
/* 71 */           f.set(copy, ((myDataType)val).clone());
/* 72 */         } else if (val.getClass().isArray()) {
/* 73 */           f.set(copy, ((myDataType)val).clone());
/*    */         }
/*    */         else {
/* 76 */           f.set(copy, val);
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (InstantiationException ex) {
/* 81 */       Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (InvocationTargetException ex) {
/* 83 */       Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (NoSuchMethodException ex) {
/* 85 */       Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (SecurityException ex) {
/* 87 */       Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IllegalArgumentException ex) {
/* 89 */       Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IllegalAccessException ex) {
/* 91 */       Logger.getLogger(sectData.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */     
/* 94 */     return (sectData)copy;
/*    */   }
/*    */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/java4d/sections/data/sectData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
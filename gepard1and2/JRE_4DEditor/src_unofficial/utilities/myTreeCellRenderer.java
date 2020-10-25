/*     */ package utilities;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.ComponentOrientation;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Insets;
/*     */ import java.awt.Rectangle;
/*     */ import java4d.sections.sect;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.JTree.DropLocation;
/*     */ import javax.swing.LookAndFeel;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import javax.swing.plaf.ColorUIResource;
/*     */ import javax.swing.plaf.FontUIResource;
/*     */ import javax.swing.plaf.basic.BasicGraphicsUtils;
/*     */ import javax.swing.tree.TreeCellRenderer;
/*     */ import javax.swing.tree.TreePath;
/*     */ import sun.swing.DefaultLookup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class myTreeCellRenderer
/*     */   extends JLabel
/*     */   implements TreeCellRenderer
/*     */ {
/*     */   private JTree tree;
/*     */   protected boolean selected;
/*     */   protected boolean hasFocus;
/*     */   private boolean drawsFocusBorderAroundIcon;
/*     */   private boolean drawDashedFocusIndicator;
/*     */   private Color treeBGColor;
/*     */   private Color focusBGColor;
/*     */   protected transient Icon closedIcon;
/*     */   protected transient Icon leafIcon;
/*     */   protected transient Icon openIcon;
/*     */   protected Color textSelectionColor;
/*     */   protected Color textNonSelectionColor;
/*     */   protected Color backgroundSelectionColor;
/*     */   protected Color backgroundNonSelectionColor;
/*     */   protected Color borderSelectionColor;
/*     */   private boolean isDropCell;
/* 112 */   private boolean fillBackground = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public myTreeCellRenderer()
/*     */   {
/* 120 */     setLeafIcon(DefaultLookup.getIcon(this, this.ui, "Tree.leafIcon"));
/* 121 */     setClosedIcon(DefaultLookup.getIcon(this, this.ui, "Tree.closedIcon"));
/* 122 */     setOpenIcon(DefaultLookup.getIcon(this, this.ui, "Tree.openIcon"));
/*     */     
/* 124 */     setTextSelectionColor(DefaultLookup.getColor(this, this.ui, "Tree.selectionForeground"));
/* 125 */     setTextNonSelectionColor(DefaultLookup.getColor(this, this.ui, "Tree.textForeground"));
/* 126 */     setBackgroundSelectionColor(DefaultLookup.getColor(this, this.ui, "Tree.selectionBackground"));
/* 127 */     setBackgroundNonSelectionColor(DefaultLookup.getColor(this, this.ui, "Tree.textBackground"));
/* 128 */     setBorderSelectionColor(DefaultLookup.getColor(this, this.ui, "Tree.selectionBorderColor"));
/* 129 */     this.drawsFocusBorderAroundIcon = DefaultLookup.getBoolean(this, this.ui, "Tree.drawsFocusBorderAroundIcon", false);
/* 130 */     this.drawDashedFocusIndicator = DefaultLookup.getBoolean(this, this.ui, "Tree.drawDashedFocusIndicator", false);
/*     */     
/* 132 */     this.fillBackground = DefaultLookup.getBoolean(this, this.ui, "Tree.rendererFillBackground", true);
/* 133 */     Insets margins = DefaultLookup.getInsets(this, this.ui, "Tree.rendererMargins");
/* 134 */     if (margins != null) {
/* 135 */       setBorder(new EmptyBorder(margins.top, margins.left, margins.bottom, margins.right));
/*     */     }
/*     */     
/*     */ 
/* 139 */     setName("Tree.cellRenderer");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Icon getDefaultOpenIcon()
/*     */   {
/* 147 */     return DefaultLookup.getIcon(this, this.ui, "Tree.openIcon");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Icon getDefaultClosedIcon()
/*     */   {
/* 155 */     return DefaultLookup.getIcon(this, this.ui, "Tree.closedIcon");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Icon getDefaultLeafIcon()
/*     */   {
/* 163 */     return DefaultLookup.getIcon(this, this.ui, "Tree.leafIcon");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOpenIcon(Icon newIcon)
/*     */   {
/* 170 */     this.openIcon = newIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Icon getOpenIcon()
/*     */   {
/* 177 */     return this.openIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setClosedIcon(Icon newIcon)
/*     */   {
/* 184 */     this.closedIcon = newIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Icon getClosedIcon()
/*     */   {
/* 192 */     return this.closedIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLeafIcon(Icon newIcon)
/*     */   {
/* 199 */     this.leafIcon = newIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Icon getLeafIcon()
/*     */   {
/* 206 */     return this.leafIcon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTextSelectionColor(Color newColor)
/*     */   {
/* 213 */     this.textSelectionColor = newColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Color getTextSelectionColor()
/*     */   {
/* 220 */     return this.textSelectionColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTextNonSelectionColor(Color newColor)
/*     */   {
/* 227 */     this.textNonSelectionColor = newColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Color getTextNonSelectionColor()
/*     */   {
/* 234 */     return this.textNonSelectionColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBackgroundSelectionColor(Color newColor)
/*     */   {
/* 241 */     this.backgroundSelectionColor = newColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Color getBackgroundSelectionColor()
/*     */   {
/* 248 */     return this.backgroundSelectionColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBackgroundNonSelectionColor(Color newColor)
/*     */   {
/* 255 */     this.backgroundNonSelectionColor = newColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Color getBackgroundNonSelectionColor()
/*     */   {
/* 262 */     return this.backgroundNonSelectionColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBorderSelectionColor(Color newColor)
/*     */   {
/* 269 */     this.borderSelectionColor = newColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Color getBorderSelectionColor()
/*     */   {
/* 276 */     return this.borderSelectionColor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFont(Font font)
/*     */   {
/* 287 */     if ((font instanceof FontUIResource)) {
/* 288 */       font = null;
/*     */     }
/*     */     
/* 291 */     super.setFont(font);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Font getFont()
/*     */   {
/* 300 */     Font font = super.getFont();
/*     */     
/* 302 */     if ((font == null) && (this.tree != null))
/*     */     {
/*     */ 
/* 305 */       font = this.tree.getFont();
/*     */     }
/* 307 */     return font;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setBackground(Color color)
/*     */   {
/* 319 */     if ((color instanceof ColorUIResource)) {
/* 320 */       color = null;
/*     */     }
/*     */     
/* 323 */     super.setBackground(color);
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
/*     */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
/*     */   {
/* 340 */     String stringValue = tree.convertValueToText(value, sel, expanded, leaf, row, hasFocus);
/*     */     
/*     */ 
/* 343 */     this.tree = tree;
/* 344 */     this.hasFocus = hasFocus;
/* 345 */     setText(stringValue);
/*     */     
/* 347 */     Color fg = null;
/* 348 */     this.isDropCell = false;
/*     */     
/* 350 */     JTree.DropLocation dropLocation = tree.getDropLocation();
/* 351 */     if ((dropLocation != null) && (dropLocation.getChildIndex() == -1) && (tree.getRowForPath(dropLocation.getPath()) == row))
/*     */     {
/*     */ 
/* 354 */       Color col = DefaultLookup.getColor(this, this.ui, "Tree.dropCellForeground");
/* 355 */       if (col != null) {
/* 356 */         fg = col;
/*     */       } else {
/* 358 */         fg = getTextSelectionColor();
/*     */       }
/*     */       
/* 361 */       this.isDropCell = true;
/* 362 */     } else if (sel) {
/* 363 */       fg = getTextSelectionColor();
/*     */     } else {
/* 365 */       fg = getTextNonSelectionColor();
/*     */     }
/*     */     
/* 368 */     setForeground(fg);
/*     */     
/* 370 */     Icon icon = null;
/* 371 */     if (leaf) {
/* 372 */       icon = getLeafIcon();
/* 373 */     } else if (expanded) {
/* 374 */       icon = getOpenIcon();
/*     */     } else {
/* 376 */       icon = getClosedIcon();
/*     */     }
/*     */     
/* 379 */     if (!tree.isEnabled()) {
/* 380 */       setEnabled(false);
/* 381 */       LookAndFeel laf = UIManager.getLookAndFeel();
/* 382 */       Icon disabledIcon = laf.getDisabledIcon(tree, icon);
/* 383 */       if (disabledIcon != null) {
/* 384 */         icon = disabledIcon;
/*     */       }
/*     */       
/* 387 */       setDisabledIcon(icon);
/*     */     } else {
/* 389 */       setEnabled(true);
/* 390 */       setIcon(icon);
/*     */     }
/* 392 */     setComponentOrientation(tree.getComponentOrientation());
/*     */     
/* 394 */     this.selected = sel;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 414 */     ImageIcon j = IconFactory.getIcon("java4d/images/icon" + super.getText().substring(0, 4) + ".png");
/* 415 */     if (j == null) {
/* 416 */       j = IconFactory.getIcon("java4d/images/iconUnknown.png");
/*     */     }
/* 418 */     setIcon(j);
/*     */     try
/*     */     {
/* 421 */       String t = ((myNode)tree.getPathForRow(row).getLastPathComponent()).getSect().getTipDetails();
/* 422 */       if (t.length() > 5) {
/* 423 */         tree.setToolTipText("Tip: " + t);
/*     */       }
/*     */       else {
/* 426 */         tree.setToolTipText(null);
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {}
/*     */     
/*     */ 
/* 432 */     if (!sel) {
/* 433 */       setBackgroundNonSelectionColor(tree.getBackground());
/*     */     }
/*     */     
/*     */ 
/* 437 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*     */     Color bColor;
/*     */     
/* 446 */     if (this.isDropCell) {
/* 447 */       Color bColor = DefaultLookup.getColor(this, this.ui, "Tree.dropCellBackground");
/* 448 */       if (bColor == null)
/* 449 */         bColor = getBackgroundSelectionColor();
/*     */     } else { Color bColor;
/* 451 */       if (this.selected) {
/* 452 */         bColor = getBackgroundSelectionColor();
/*     */       } else {
/* 454 */         bColor = getBackgroundNonSelectionColor();
/* 455 */         if (bColor == null) {
/* 456 */           bColor = getBackground();
/*     */         }
/*     */       }
/*     */     }
/* 460 */     int imageOffset = -1;
/* 461 */     if ((bColor != null) && (this.fillBackground)) {
/* 462 */       Icon currentI = getIcon();
/*     */       
/* 464 */       imageOffset = getLabelStart();
/* 465 */       g.setColor(bColor);
/* 466 */       if (getComponentOrientation().isLeftToRight()) {
/* 467 */         g.fillRect(imageOffset, 0, getWidth() - imageOffset, getHeight());
/*     */       }
/*     */       else {
/* 470 */         g.fillRect(0, 0, getWidth() - imageOffset, getHeight());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 475 */     if (this.hasFocus) {
/* 476 */       if (this.drawsFocusBorderAroundIcon) {
/* 477 */         imageOffset = 0;
/* 478 */       } else if (imageOffset == -1) {
/* 479 */         imageOffset = getLabelStart();
/*     */       }
/* 481 */       if (getComponentOrientation().isLeftToRight()) {
/* 482 */         paintFocus(g, imageOffset, 0, getWidth() - imageOffset, getHeight(), bColor);
/*     */       }
/*     */       else {
/* 485 */         paintFocus(g, 0, 0, getWidth() - imageOffset, getHeight(), bColor);
/*     */       }
/*     */     }
/* 488 */     super.paint(g);
/*     */   }
/*     */   
/*     */   private void paintFocus(Graphics g, int x, int y, int w, int h, Color notColor) {
/* 492 */     Color bsColor = getBorderSelectionColor();
/*     */     
/* 494 */     if ((bsColor != null) && ((this.selected) || (!this.drawDashedFocusIndicator))) {
/* 495 */       g.setColor(bsColor);
/* 496 */       g.drawRect(x, y, w - 1, h - 1);
/*     */     }
/* 498 */     if ((this.drawDashedFocusIndicator) && (notColor != null)) {
/* 499 */       if (this.treeBGColor != notColor) {
/* 500 */         this.treeBGColor = notColor;
/* 501 */         this.focusBGColor = new Color(notColor.getRGB() ^ 0xFFFFFFFF);
/*     */       }
/* 503 */       g.setColor(this.focusBGColor);
/* 504 */       BasicGraphicsUtils.drawDashedRect(g, x, y, w, h);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getLabelStart() {
/* 509 */     Icon currentI = getIcon();
/* 510 */     if ((currentI != null) && (getText() != null)) {
/* 511 */       return currentI.getIconWidth() + Math.max(0, getIconTextGap() - 1);
/*     */     }
/* 513 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Dimension getPreferredSize()
/*     */   {
/* 521 */     Dimension retDimension = super.getPreferredSize();
/*     */     
/* 523 */     if (retDimension != null) {
/* 524 */       retDimension = new Dimension(retDimension.width + 3, retDimension.height);
/*     */     }
/*     */     
/*     */ 
/* 528 */     return retDimension;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void validate() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void invalidate() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void revalidate() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void repaint(long tm, int x, int y, int width, int height) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void repaint(Rectangle r) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void repaint() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void firePropertyChange(String propertyName, Object oldValue, Object newValue)
/*     */   {
/* 590 */     if ((propertyName == "text") || (((propertyName == "font") || (propertyName == "foreground")) && (oldValue != newValue) && (getClientProperty("html") != null)))
/*     */     {
/* 592 */       super.firePropertyChange(propertyName, oldValue, newValue);
/*     */     }
/*     */   }
/*     */   
/*     */   public void firePropertyChange(String propertyName, byte oldValue, byte newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, char oldValue, char newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, short oldValue, short newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, int oldValue, int newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, long oldValue, long newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, float oldValue, float newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, double oldValue, double newValue) {}
/*     */   
/*     */   public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}
/*     */ }


/* Location:              /home/traildev/javastuff/Java4D.jar!/utilities/myTreeCellRenderer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */
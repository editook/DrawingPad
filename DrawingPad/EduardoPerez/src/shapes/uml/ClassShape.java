package shapes.uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import shapes.Drawable;
import shapes.RectangleShape;

public class ClassShape extends RectangleShape {
  private static final String CLASS = "Class";
  private String titleClass;

  public ClassShape(Color color) {
    super(color);
    titleClass ="Untitled";
  }

  public void setTitleClass(String titleClass){
    if(titleClass!=null){
      this.titleClass = titleClass;
    }
  }

  public String getName() {
    return CLASS;
  }

  @Override
  public void draw(Graphics g){
    super.draw(g);
    Point point1 = getPoint1();
    g.drawString(titleClass,point1.x+10,point1.y+12);
  }
}

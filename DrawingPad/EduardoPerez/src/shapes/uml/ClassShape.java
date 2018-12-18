package shapes.uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import shapes.RectangleShape;

public class ClassShape extends RectangleShape {

  private static final String CLASS = "Class";
  private String titleClass;
  private Color color;

  public ClassShape(Color color) {
    super(color);
    this.color = color;
    titleClass = "Untitled";
  }

  public String getTitleClass() {
    return titleClass;
  }

  public void setTitleClass(String titleClass) {
    if (titleClass != null) {
      this.titleClass = titleClass;
    }
  }

  public String getName() {
    return CLASS;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    Point point1 = getPoint1();
    g.drawString(titleClass, point1.x + 10, point1.y + 12);
    g.setColor(getColor());
    super.draw(g);

  }
}

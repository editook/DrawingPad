package shapes;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class LineShape extends TwoEndsShape {
  private static final String LINE = "Line";
  public LineShape(Color color) {
    super(color);
  }

  @Override
  public void draw(Graphics g) {
    Point point1 = getPoint1();
    Point point2 = getPoint2();
    g.drawLine(point1.x, point1.y, point2.x, point2.y);
  }

  public String getName() {
    return LINE;
  }

  @Deprecated
  public ArrayList<Point> getPoints() {
    return new ArrayList<Point>();
  }
}

package shapes;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class OvalShape extends TwoEndsShape {

  private static final String OVAL = "Oval";

  public OvalShape(Color color) {
    super(color);
  }


  @Override
  public void draw(Graphics g) {
    Point point1 = getPoint1();
    Point point2 = getPoint2();
    int x = Math.min(point1.x, point2.x);
    int y = Math.min(point1.y, point2.y);
    int w = Math.abs(point1.x - point2.x) + 1;
    int h = Math.abs(point1.y - point2.y) + 1;
    g.drawOval(x, y, w, h);
  }

  public String getName() {
    return OVAL;
  }

  @Override
  public ArrayList<Point> getPoints() {
    return new ArrayList<Point>();
  }

}

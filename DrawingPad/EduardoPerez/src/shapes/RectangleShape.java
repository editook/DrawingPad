package shapes;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import org.omg.PortableServer.POA;

public class RectangleShape extends TwoEndsShape {

  public RectangleShape(Color color) {
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
    g.drawRect(x, y, w, h);
  }
  public String getName(){
    return "Rectangle";
  }
  @Override
  public ArrayList<Point> getPoints() {
    return new ArrayList<Point>();
  }
}

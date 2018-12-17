package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StrokeShape extends Shape {

  private List<Point> points;
  private Color color;
  private static final String STROKE_SHAPE = "StrokeShape";
  public StrokeShape(Color color) {
    super(color);
    this.color = color;
    points = new ArrayList<Point>();
  }

  @Override
  public Point getPoint1() {
    return null;
  }

  @Override
  public void setPoint1(Point point) {

  }

  @Override
  public void setPoint2(Point point) {

  }

  public String getName() {
    return STROKE_SHAPE;
  }

  @Override
  public Point getPoint2() {
    return null;
  }

  public void addPoint(Point point) {
    if (point != null) {
      points.add(point);
    }
  }

  public Point lastAddedPoint() {
    int lastPos = points.size() - 1;
    return points.get(lastPos);
  }

  public ArrayList<Point> getPoints() {

    return (ArrayList<Point>) points;
  }

  @Override
  public void draw(Graphics g) {
    if (color != null) {
      g.setColor(color);
    }
    Point prev = null;
    Iterator iter = points.iterator();
    while (iter.hasNext()) {
      Point cur = (Point) iter.next();
      if (prev != null) {
        g.drawLine(prev.x, prev.y, cur.x, cur.y);
      }
      prev = cur;
    }
  }

}

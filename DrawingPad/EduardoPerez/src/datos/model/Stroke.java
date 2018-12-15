package datos.model;

import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import shapes.Shape;
import shapes.StrokeShape;

public class Stroke extends Rebuild {

  private List<Point> points;
  private Color color;

  public Stroke(Color color, List<Point> points) {
    this.color = color;
    this.points = points;
  }

  @Override
  public Shape getShape() {
    StrokeShape shape = new StrokeShape(color);
    Point prev = null;
    Iterator iter = points.iterator();
    while (iter.hasNext()) {
      Point point = (Point) iter.next();
      if (prev != null) {
        shape.addPoint(point);
      }
      prev = point;
    }

    return shape;
  }
}

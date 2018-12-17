package datos.model;

import java.awt.Color;
import java.awt.Point;

public class RectangleBuild extends Rebuild {

  private Color color;
  private Point point1, point2;
  private String name;

  public RectangleBuild(Color color, Point point1, Point point2) {
    this.color = color;
    this.point2 = point2;
    this.point1 = point1;
    name = "Rectangle";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Color getColor() {
    return color;
  }

  public Point getPoint1() {
    return point1;
  }

  public Point getPoint2() {
    return point2;
  }

}

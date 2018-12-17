package datos.model;

import java.awt.Color;
import java.awt.Point;

public class LineBuild extends Rebuild {

  private Color color;
  private Point point1, point2;
  private String name;

  public LineBuild(Color color, Point point1, Point point2) {
    this.color = color;
    this.point2 = point2;
    this.point1 = point1;
    name = "Line";
  }

  @Override
  public String getName() {
    return name;
  }

  public Point getPoint1() {
    return point1;
  }

  public Point getPoint2() {
    return point2;
  }

  @Override
  public Color getColor() {
    return color;
  }
}

package datos.model;

import java.awt.Color;
import java.awt.Point;

public class ClassBuild extends RectangleBuild {

  private String nameClass;
  private Color color;
  private Point point1, point2;
  private String name;

  public ClassBuild(Color color, Point point1, Point point2, String nameClass) {
    super(color, point1, point2);
    this.nameClass = nameClass;
    this.color = color;
    this.point1 = point1;
    this.point2 = point2;
    name = "Class";
  }

  public String getNameClass() {
    return nameClass;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Point getPoint1() {
    return point1;
  }

  public void setPoint1(Point point1) {
    this.point1 = point1;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Point getPoint2() {
    return point2;
  }

}

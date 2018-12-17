package datos.model;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class StrokeBuild extends Rebuild {

  private List<Point> points;
  private Color color;
  private String name;

  public StrokeBuild(Color color, List<Point> points) {
    this.color = color;
    this.points = points;
    name = "StrokeShape";
  }

  @Override
  public Color getColor() {
    return color;
  }

  public List<Point> getPoints() {
    return points;
  }

  @Override
  public String getName() {
    return name;
  }

}

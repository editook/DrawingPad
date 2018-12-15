package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Shape implements Drawable  {

  private Color color;

  public Shape(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }
  public abstract Point getPoint1();
  public abstract Point getPoint2();
  public  abstract String getName();
  public abstract ArrayList<Point> getPoints();
}
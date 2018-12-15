package datos.model;

import java.awt.Color;
import java.awt.Point;
import shapes.Drawable;
import shapes.OvalShape;
import shapes.RectangleShape;
import shapes.Shape;
import shapes.TwoEndsShape;

public class Oval extends Rebuild {
  private Color color;
  private Point point1,point2;
  public Oval(Color color, Point point1, Point point2){
    this.color = color;
    this.point2 = point2;
    this.point1 = point1;
  }
  @Override
  public Shape getShape() {
    TwoEndsShape drawable = new OvalShape(color);
    drawable.setEnds(point1.x,point1.y,point2.x,point2.y);
    return drawable;
  }
}

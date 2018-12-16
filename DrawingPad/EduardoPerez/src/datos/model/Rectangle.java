package datos.model;

import java.awt.Color;
import java.awt.Point;
import shapes.RectangleShape;
import shapes.Shape;
import shapes.TwoEndsShape;

public class Rectangle extends Rebuild {

  private Color color;
  private Point point1, point2;
  private String contentTitle;
  public Rectangle(Color color, Point point1, Point point2) {
    this.color = color;
    this.point2 = point2;
    this.point1 = point1;
  }
  public void setContentTitle(String contentTitle){
    this.contentTitle = contentTitle;
  }
  @Override
  public Shape getShape() {
    RectangleShape shape = new RectangleShape(color);
    shape.setEnds(point1.x, point1.y, point2.x, point2.y);
    if(contentTitle!=null){
      shape.setTextoShape(contentTitle);
    }
    return shape;
  }
}

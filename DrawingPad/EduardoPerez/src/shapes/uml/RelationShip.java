package shapes.uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import shapes.LineShape;
import shapes.Shape;
import shapes.TwoEndsShape;
import views.components.windows.frame.ListShape;

public class RelationShip extends LineShape {

  private int relacion;//herencia= 1, agregación = 1 y asociación simple = 0
  private Shape classShape1, classShape2;

  public RelationShip(Color color,Shape classShape1, Shape classShape2, int relacion){
    super(color);
    setPoint1(classShape1.getPoint1());
    setPoint2(getPointShape(classShape2));
    this.relacion = relacion;
    this.classShape1 = classShape1;
    this.classShape2 = classShape2;
  }
  private Point getPointShape(Shape shape){
    Point point =  shape.getPoint2();
    return new Point(point.x-50,point.y);
  }
  private float getAngleOfLineBetweenTwoPoints(Point point1, Point point2) {
    float xDiff = point2.x - point1.x;
    float yDiff = point2.y - point1.y;
    return (float) (Math.atan2(yDiff, xDiff) * (180/Math.PI));
  }

  @Override
  public void draw(Graphics g){
    super.draw(g);
    Point point1 = getPoint1();
    Point point2 = getPoint2();
    float angle = getAngleOfLineBetweenTwoPoints(point1,point2);
    System.out.println(angle);
    Graphics2D g2 = (Graphics2D) g;
    int size = 15;
    Polygon polygon = new Polygon();
    polygon.addPoint(point2.x-size,point2.y+size);
    polygon.addPoint(point2.x,point2.y);
    polygon.addPoint(point2.x+size,point2.y+size);
    polygon.addPoint(point2.x-size,point2.y+size);
    //g.drawPolygon(polygon);
    //g2.rotate(Math.toRadians(angle)); // rotates about transformed origin
    //g2.drawPolygon(polygon);
    //g2.rotate(180);
  }










































  /*public void draw(Graphics g, Point point1, Point point2){
    float angle = getAngleOfLineBetweenTwoPoints(point1,point2);
    Graphics2D g2 = (Graphics2D) g;
    int size = 30;
    Polygon polygon = new Polygon();
    polygon.addPoint(point1.x-size,point1.y+size);
    polygon.addPoint(point1.x,point1.y);
    polygon.addPoint(point1.x+size,point1.y+size);
    polygon.addPoint(point1.x-size,point1.y+size);

    g2.rotate(Math.toRadians(angle)); // rotates about transformed origin
    g2.drawPolygon(polygon);
  }*/
}

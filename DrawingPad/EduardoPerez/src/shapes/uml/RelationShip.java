package shapes.uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;
import shapes.LineShape;
import shapes.Shape;

public class RelationShip extends LineShape {

  private static final String RELATION_SHIP = "RelationShip";
  private int TypeRelation;
  private Shape classShape1, classShape2;
  private Map<Integer, Polygon> figureMap;

  public RelationShip(Color color, Shape classShape1, Shape classShape2, int TypeRelation) {
    super(color);
    setPoint1(getPointShapeLeft(classShape1, classShape2));
    setPoint2(getPointShapeRight(classShape2, classShape1));
    this.TypeRelation = TypeRelation;
    this.classShape1 = classShape1;
    this.classShape2 = classShape2;
    inifigureMap();
  }

  public RelationShip(Color color, int TypeRelation) {
    super(color);
    this.TypeRelation = TypeRelation;
    inifigureMap();
  }

  public Shape getClassShape1() {
    return classShape1;
  }

  public int getTypeRelation() {
    return TypeRelation;
  }

  public Shape getClassShape2() {
    return classShape2;
  }

  @Override
  public String getName() {
    return RELATION_SHIP;
  }

  private Point getPointShapeLeft(Shape shape, Shape shape2) {
    Point point = shape.getPoint1();
    Point point1 = shape2.getPoint1();
    int x = 50, y;
    if (point.y > point1.y) {
      y = 0;
    } else {
      y = 70;
    }
    return new Point(point.x + x, point.y + y);
  }

  private Point getPointShapeRight(Shape shape, Shape shape2) {
    Point point = shape.getPoint1();
    Point point1 = shape2.getPoint1();
    int x = 50, y;
    if (point.y < point1.y) {
      y = 70;
    } else {
      y = 0;
    }
    return new Point(point.x + x, point.y + y);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(getColor());
    super.draw(g);

    g.drawPolygon(figureMap.get(TypeRelation));
  }
  private void inifigureMap() {
    figureMap = new HashMap<>();
    Polygon polygonHerencia = new Polygon();
    Point point2 = getPoint2();
    int size = 15;
    polygonHerencia.addPoint(point2.x - size, point2.y + size);
    polygonHerencia.addPoint(point2.x, point2.y);
    polygonHerencia.addPoint(point2.x + size, point2.y + size);
    polygonHerencia.addPoint(point2.x - size, point2.y + size);
    figureMap.put(1, polygonHerencia);
    Polygon polygonAgregation = new Polygon();
    polygonAgregation.addPoint(point2.x, point2.y);
    polygonAgregation.addPoint(point2.x + (size / 2), point2.y + (size / 2));
    polygonAgregation.addPoint(point2.x, point2.y + size);
    polygonAgregation.addPoint(point2.x - (size / 2), point2.y + (size / 2));
    polygonAgregation.addPoint(point2.x, point2.y);
    figureMap.put(2, polygonAgregation);
    Polygon polygonAsociation = new Polygon();
    polygonAgregation.addPoint(point2.x, point2.y);
    figureMap.put(0, polygonAsociation);
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

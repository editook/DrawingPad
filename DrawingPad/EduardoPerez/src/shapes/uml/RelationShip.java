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
  private int relacion;//herencia= 1, agregación = 1 y asociación simple = 0
  private Shape classShape1, classShape2;
  private Map<Integer, Polygon> figureMap;

  public RelationShip(Color color, Shape classShape1, Shape classShape2, int relacion) {
    super(color);
    setPoint1(getPointShapeLeft(classShape1));
    setPoint2(getPointShapeRight(classShape2));
    this.relacion = relacion;
    this.classShape1 = classShape1;
    this.classShape2 = classShape2;
    figureMap = new HashMap<Integer, Polygon>();
    inifigureMap();
  }

  public Shape getClassShape1() {
    return classShape1;
  }

  public int gettypeRelation() {
    return relacion;
  }

  public Shape getClassShape2() {
    return classShape2;
  }

  @Override
  public String getName() {
    return RELATION_SHIP;
  }

  private void inifigureMap() {
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

  private Point getPointShapeLeft(Shape shape) {
    Point point = shape.getPoint1();
    return new Point(point.x + 50, point.y + 50);
  }

  private Point getPointShapeRight(Shape shape) {
    Point point = shape.getPoint2();
    return new Point(point.x - 50, point.y - 50);
  }

  private float getAngleOfLineBetweenTwoPoints(Point point1, Point point2) {
    float xDiff = point2.x - point1.x;
    float yDiff = point2.y - point1.y;
    return (float) (Math.atan2(yDiff, xDiff) * (180 / Math.PI));
  }

  @Override
  public void draw(Graphics g) {
    g.drawPolygon(figureMap.get(relacion));
    super.draw(g);
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

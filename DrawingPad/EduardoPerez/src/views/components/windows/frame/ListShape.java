package views.components.windows.frame;

import datos.Connection;
import datos.model.LineBuild;
import datos.model.OvalBuild;
import datos.model.RectangleBuild;
import datos.model.ShapeBuild;
import datos.model.StrokeBuild;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModelShape;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import shapes.Shape;
import shapes.TwoEndsShape;
import shapes.uml.ClassShape;
import shapes.uml.RelationShip;

public class ListShape {

  private static List<Shape> shapeList;
  private Point pointerMouse;
  public ListShape() {
    shapeList = new ArrayList<Shape>();
    pointerMouse = new Point(0,0);
  }

  public List<Shape> getShapes() {
    return shapeList;
  }

  public List<ModelShape> updateShapesList() {
    List<ModelShape> modelShapeList = new ArrayList<ModelShape>();
    for (Shape shape : shapeList) {
      modelShapeList.add(new ModelShape(creatShape(shape)));
    }
    return modelShapeList;
  }

  private ShapeBuild creatShape(Shape shape) {
    ShapeBuild shapeBuild = null;
    switch (shape.getName()) {
      case "Line":
        shapeBuild = new LineBuild(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "Rectangle":
        shapeBuild = new RectangleBuild(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "Oval":
        shapeBuild = new OvalBuild(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "StrokeShape":
        shapeBuild = new StrokeBuild(shape.getColor(), shape.getPoints());
    }
    return shapeBuild;
  }

  public void add(Shape shape) {
      shapeList.add(shape);
  }

  public Iterator<Shape> iterator() {
    return shapeList.iterator();
  }

  public void clear() {
    shapeList.clear();
  }

  public boolean isEmpty() {
    return shapeList.isEmpty();
  }

  public void updateList(String filename) {
    ListModelShape listModelShape = Connection.openFileSerialized(filename);
    List<ModelShape> shareList = listModelShape.getModelShape();

    for (ModelShape modelShape : shareList) {
      ShapeBuild shapeBuild = modelShape.getShapeBuild();
      add(shapeBuild.getShape());
    }
  }

  public void removeLatest() {
    if(shapeList.size()-1>=0){
      shapeList.remove( shapeList.size()-1);
    }
  }

  public boolean isColisionClass(Point point) {
    Rectangle pointer = new Rectangle(point.x,point.y,5,5);
    for (Shape shape : shapeList) {
      if(shape.getName().equals("Class")){
        Point point1 = shape.getPoint1();
        Point point2 = shape.getPoint2();
        int x = Math.abs(point1.x-point2.x);
        int y = Math.abs(point1.y-point2.y);
        Rectangle rectangle1 = new Rectangle(point1.x,point1.y,x,y);
        if(pointer.intersects(rectangle1)){
          return true;
        }
      }
    }
    return false;
  }

  public void renameClassName(String name, Point point) {
    Rectangle pointer = new Rectangle(point.x,point.y,5,5);
    for (Shape shape : shapeList) {
      if(shape.getName().equals("Class")){
        Point point1 = shape.getPoint1();
        Point point2 = shape.getPoint2();
        int x = Math.abs(point1.x-point2.x);
        int y = Math.abs(point1.y-point2.y);
        Rectangle rectangle1 = new Rectangle(point1.x,point1.y,x,y);
        if(pointer.intersects(rectangle1)){
          ClassShape classShape = (ClassShape) shape;
          classShape.setTitleClass(name);
        }
      }
    }
  }

  public void addRelationShapre(Shape relationShip) {
    Point p1 = relationShip.getPoint1();
    Point p2 = relationShip.getPoint2();
    Rectangle pointer1 = new Rectangle(p1.x,p1.y,5,5);
    Rectangle pointer2 = new Rectangle(p2.x,p2.y,5,5);
    Shape shape1=null,shape2=null;
    boolean stateRelation = false;
    for (Shape shape : shapeList) {//ini
      if(shape.getName().equals("Class")){
        Point point1 = shape.getPoint1();
        Point point2 = shape.getPoint2();
        int x = Math.abs(point1.x-point2.x);
        int y = Math.abs(point1.y-point2.y);
        Rectangle rectangle1 = new Rectangle(point1.x,point1.y,x,y);
        if(pointer1.intersects(rectangle1)){
          shape1 = shape;
          System.out.println("primero");
          stateRelation =true;
          break;
        }
      }
    }
    if(stateRelation){
      stateRelation = false;
      for (Shape shape : shapeList) {
        if(shape.getName().equals("Class")){
          Point point1 = shape.getPoint1();
          Point point2 = shape.getPoint2();
          int x = Math.abs(point1.x-point2.x);
          int y = Math.abs(point1.y-point2.y);
          Rectangle rectangle1 = new Rectangle(point1.x,point1.y,x,y);
          if(pointer2.intersects(rectangle1)){
            shape2 = shape;
            System.out.println("segundo");
            stateRelation = true;
            break;
          }
        }
      }
    }
    if(stateRelation){
      System.out.println("creo");
      RelationShip relationShip1 = new RelationShip(relationShip.getColor(), shape1,shape2,1);
      add(relationShip1);
    }
  }
}


package views.components.windows.frame;

import datos.Connection;
import datos.model.ClassBuild;
import datos.model.RelationShipBuild;
import datos.model.ShapeBuild;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModelShape;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import shapes.Shape;
import shapes.uml.ClassShape;
import shapes.uml.RelationShip;

public class ListShape {

  private static List<Shape> shapeList;
  private boolean shapeChanges;

  public ListShape() {
    shapeList = new ArrayList<Shape>();
    shapeChanges = false;
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
      case "Class":
        ClassShape classShape = (ClassShape) shape;
        shapeBuild = new ClassBuild(classShape.getColor(), classShape.getPoint1(),
            classShape.getPoint2(), classShape.getTitleClass());
        break;
      case "RelationShip":
        shapeBuild = createRelationShip(shape);


    }
    return shapeBuild;
  }


  public void add(Shape shape) {
    shapeList.add(shape);
    shapeChanges = true;
  }

  public Iterator<Shape> iterator() {
    return shapeList.iterator();
  }

  public void clear() {
    shapeList.clear();
  }

  public boolean isEmpty() {
    return !shapeChanges;
  }

  public void updateList(String filename) {
    ListModelShape listModelShape = Connection.openFileSerialized(filename);
    List<ModelShape> shareList = listModelShape.getModelShape();

    for (ModelShape modelShape : shareList) {
      ShapeBuild shapeBuild = modelShape.getShapeBuild();
      add(createShape(shapeBuild));
    }
    shapeChanges = false;
  }

  private Shape createShape(ShapeBuild shapeBuild) {
    Shape ouput = null;
    switch (shapeBuild.getName()) {
      case "Class":
        ClassBuild classBuild = (ClassBuild) shapeBuild;
        ClassShape classShape = new ClassShape(classBuild.getColor());
        classShape.setTitleClass(classBuild.getNameClass());
        classShape.setPoint1(classBuild.getPoint1());
        classShape.setPoint2(classBuild.getPoint2());
        ouput = classShape;
        break;
      case "RelationShip":
        RelationShipBuild rectangleBuild1 = (RelationShipBuild) shapeBuild;
        ClassBuild classBuild1 = rectangleBuild1.getClassBuild1();
        ClassShape classShape1 = new ClassShape(classBuild1.getColor());
        classShape1.setTitleClass(classBuild1.getNameClass());
        classShape1.setPoint1(classBuild1.getPoint1());
        classShape1.setPoint2(classBuild1.getPoint2());

        ClassBuild classBuild2 = rectangleBuild1.getClassBuild2();
        ClassShape classShape2 = new ClassShape(classBuild2.getColor());
        classShape2.setTitleClass(classBuild2.getNameClass());
        classShape2.setPoint1(classBuild2.getPoint1());
        classShape2.setPoint2(classBuild2.getPoint2());

        RelationShip relationShip = new RelationShip(rectangleBuild1.getColor(), classShape1,
            classShape2, rectangleBuild1.getTypeRelation());
        relationShip.setPoint1(rectangleBuild1.getPoint1());
        relationShip.setPoint2(rectangleBuild1.getPoint2());
        ouput = relationShip;
        break;
    }
    return ouput;
  }

  public void removeLatest() {
    if (shapeList.size() - 1 >= 0) {
      shapeList.remove(shapeList.size() - 1);
    }
  }

  public boolean isColisionClass(Point point) {
    Rectangle pointer = new Rectangle(point.x, point.y, 5, 5);
    for (Shape shape : shapeList) {
      if (shape.getName().equals("Class")) {
        Point point1 = shape.getPoint1();
        Point point2 = shape.getPoint2();
        int x = Math.abs(point1.x - point2.x);
        int y = Math.abs(point1.y - point2.y);
        Rectangle rectangle1 = new Rectangle(point1.x, point1.y, x, y);
        if (pointer.intersects(rectangle1)) {
          return true;
        }
      }
    }
    return false;
  }

  public void renameClassName(String name, Point point) {
    Rectangle pointer = new Rectangle(point.x, point.y, 5, 5);
    for (Shape shape : shapeList) {
      if (shape.getName().equals("Class")) {
        Point point1 = shape.getPoint1();
        Point point2 = shape.getPoint2();
        int x = Math.abs(point1.x - point2.x);
        int y = Math.abs(point1.y - point2.y);
        Rectangle rectangle1 = new Rectangle(point1.x, point1.y, x, y);
        if (pointer.intersects(rectangle1)) {
          ClassShape classShape = (ClassShape) shape;
          classShape.setTitleClass(name);
        }
      }
    }
  }

  public void addRelationShapre(Shape relationShip, int typeRelationShip) {
    Point p1 = relationShip.getPoint1();
    Point p2 = relationShip.getPoint2();
    Rectangle pointer1 = new Rectangle(p1.x, p1.y, 5, 5);
    Rectangle pointer2 = new Rectangle(p2.x, p2.y, 5, 5);
    Shape shape1 = null, shape2 = null;
    boolean stateRelation = false;
    for (Shape shape : shapeList) {//ini
      if (shape.getName().equals("Class")) {
        Point point1 = shape.getPoint1();
        Point point2 = shape.getPoint2();
        int x = Math.abs(point1.x - point2.x);
        int y = Math.abs(point1.y - point2.y);
        Rectangle rectangle1 = new Rectangle(point1.x, point1.y, x, y);
        if (pointer1.intersects(rectangle1)) {
          shape1 = shape;
          stateRelation = true;
          break;
        }
      }
    }
    if (stateRelation) {
      stateRelation = false;
      for (Shape shape : shapeList) {
        if (shape.getName().equals("Class")) {
          Point point1 = shape.getPoint1();
          Point point2 = shape.getPoint2();
          int x = Math.abs(point1.x - point2.x);
          int y = Math.abs(point1.y - point2.y);
          Rectangle rectangle1 = new Rectangle(point1.x, point1.y, x, y);
          if (pointer2.intersects(rectangle1)) {
            shape2 = shape;
            stateRelation = true;
            break;
          }
        }
      }
    }
    if (stateRelation) {
      RelationShip relationShip1 = new RelationShip(relationShip.getColor(), shape1, shape2,
          typeRelationShip);
      add(relationShip1);
    }
  }

  public void setStateChanges(boolean b) {
    shapeChanges = b;
  }

  private RelationShipBuild createRelationShip(Shape shape) {
    RelationShipBuild shapeBuild;
    RelationShip relationShip = (RelationShip) shape;
    ClassShape classShape1 = (ClassShape) relationShip.getClassShape1();
    ClassShape classShape2 = (ClassShape) relationShip.getClassShape2();
    ClassBuild classBuild1 = new ClassBuild(classShape1.getColor(), classShape1.getPoint1(),
        classShape1.getPoint2(), classShape1.getTitleClass());
    ClassBuild classBuild2 = new ClassBuild(classShape2.getColor(), classShape2.getPoint1(),
        classShape2.getPoint2(), classShape2.getTitleClass());
    shapeBuild = new RelationShipBuild(shape.getColor(), relationShip.getPoint1(),
        relationShip.getPoint2());
    shapeBuild.setTypeRelation(relationShip.getTypeRelation());
    shapeBuild.setRelationPrimary(classBuild1);
    shapeBuild.setRelationSecundary(classBuild2);
    return shapeBuild;
  }

}


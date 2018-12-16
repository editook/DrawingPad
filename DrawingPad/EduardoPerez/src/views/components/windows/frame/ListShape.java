package views.components.windows.frame;

import datos.Connection;
import datos.model.Line;
import datos.model.Oval;
import datos.model.Rectangle;
import datos.model.ShapeBuild;
import datos.model.Stroke;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModelShape;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import shapes.RectangleShape;
import shapes.Shape;

public class ListShape {

  private static List<Shape> shapeList;
  public ListShape() {
    shapeList = new ArrayList<Shape>();
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
        shapeBuild = new Line(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "Rectangle":
        RectangleShape rectangleShape = (RectangleShape) shape;
        shapeBuild = new Rectangle(rectangleShape.getColor(), rectangleShape.getPoint1(),
            rectangleShape.getPoint2());
        ((Rectangle) shapeBuild).setContentTitle(rectangleShape.getTextShape());
        break;
      case "Oval":
        shapeBuild = new Oval(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "StrokeShape":
        shapeBuild = new Stroke(shape.getColor(), shape.getPoints());
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
}


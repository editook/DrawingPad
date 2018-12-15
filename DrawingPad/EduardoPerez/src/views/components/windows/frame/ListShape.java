package views.components.windows.frame;

import datos.Acceso;
import datos.model.Line;
import datos.model.Oval;
import datos.model.Rectangle;
import datos.model.Share;
import datos.model.Stroke;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModelShape;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import shapes.Shape;

public class ListShape {

  private static List<Shape> shapes;
  private boolean changesState;

  public ListShape() {
    shapes = new ArrayList<Shape>();
    changesState = false;
  }

  public List<ModelShape> updateShapesList() {
    List<ModelShape> modelShapeList = new ArrayList<>();
    for (Shape shape : shapes) {
      modelShapeList.add(new ModelShape(creatShare(shape)));
    }
    return modelShapeList;
  }

  private Share creatShare(Shape shape) {
    Share share = null;
    switch (shape.getName()) {
      case "Line":
        share = new Line(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "Rectangle":
        share = new Rectangle(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "Oval":
        share = new Oval(shape.getColor(), shape.getPoint1(), shape.getPoint2());
        break;
      case "StrokeShape":
        share = new Stroke(shape.getColor(), shape.getPoints());
    }
    return share;
  }

  public void add(Shape shape) {
    shapes.add(shape);
    changesState = true;
  }

  public Iterator<Shape> iterator() {
    return shapes.iterator();
  }

  public void clear() {
    shapes.clear();
  }

  public boolean isEmpty() {
    return changesState;
  }

  public void updateList(String filename) {
    ListModelShape listModelShape = Acceso.getInputStream(filename);
    List<ModelShape> shareList = listModelShape.getModelShape();

    for (ModelShape modelShape : shareList) {
      Share share = modelShape.getShare();
      add(share.getShape());
    }
  }
}


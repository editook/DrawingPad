package views.listeners;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import shapes.Shape;
import views.components.windows.panels.DrawingCanvas;

public class DrawingEventMouseMotion implements MouseMotionListener {

  private Cursor cursorSelection;
  private Cursor cursorEdition;
  private DrawingCanvas canvas;
  private Rectangle rectangle;

  public DrawingEventMouseMotion(DrawingCanvas canvas) {
    this.canvas = canvas;
    cursorSelection = new Cursor(Cursor.HAND_CURSOR);
    cursorEdition = new Cursor(Cursor.DEFAULT_CURSOR);
    rectangle = new Rectangle(0, 0, 5, 5);
  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {
    if (canvas.stateMouseEdition() == 3) {
      Point point = mouseEvent.getPoint();
      rectangle.setLocation(point);
      List<Shape> shapeList = canvas.getShapes().getShapes();
      for (Shape shape : shapeList) {
        if (shape.getName().equals("Class")) {
          Rectangle rectangle1 = new Rectangle(shape.getPoint1());
          rectangle1.setSize(99, 69);
          if (rectangle.intersects(rectangle1)) {
            canvas.setCursor(cursorSelection);
            break;
          } else {
            canvas.setCursor(cursorEdition);
          }
        }
      }

    } else {
      canvas.setCursor(cursorEdition);
    }
  }
}

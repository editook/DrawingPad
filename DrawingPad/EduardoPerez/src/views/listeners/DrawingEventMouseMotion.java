package views.listeners;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import views.canvas.toolkit.Tool;
import views.components.windows.panels.DrawingCanvas;

public class DrawingEventMouseMotion implements MouseMotionListener {

  private Cursor cursorSelection;
  private Cursor cursorEdition;
  private Tool tool;
  private DrawingCanvas canvas;
  private Rectangle rectangle;

  public DrawingEventMouseMotion(DrawingCanvas canvas, Tool tool) {
    this.tool = tool;
    this.canvas = canvas;
    cursorSelection = new Cursor(Cursor.HAND_CURSOR);
    cursorEdition = new Cursor(Cursor.DEFAULT_CURSOR);
    rectangle = new Rectangle(0, 0, 5, 5);
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {
    int value = canvas.stateMouseEdition();
    Point point = mouseEvent.getPoint();
    if (value == 0) {
      tool.addPointToShape(point);
    }
  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {












/*
    if(canvas.stateMouseEdition()==1){//create class

      ListShape listShape = canvas.getShapes();
      rectangle.setLocation(mouseEvent.getPoint());
      for (Shape shape : listShape.getShapes()){
        if(shape.getName().equals("RectangleBuild")){
          Point point1 = shape.getPoint1();
          Point point2 = shape.getPoint2();
          int x = Math.abs(point1.x-point2.x);
          int y = Math.abs(point1.y-point2.y);
          RectangleBuild rectangle1 = new RectangleBuild(point1.x,point1.y,x,y);
          if(rectangle.intersects(rectangle1)){
            canvas.setCursor(cursorSelection);
          }
          else {
            canvas.setCursor(cursorEdition);
          }
        }
      }

    }
*/
  }
}

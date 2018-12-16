package views.listeners;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import shapes.Shape;
import views.canvas.toolkit.ScribbleTool;
import views.canvas.toolkit.Tool;
import views.components.windows.frame.ListShape;
import views.components.windows.panels.DrawingCanvas;

public class DrawingEventMouseMotion implements MouseMotionListener {
  private Cursor cursorSelection = new Cursor(Cursor.HAND_CURSOR);
  private Cursor cursorEdition = new Cursor(Cursor.DEFAULT_CURSOR);
  private Tool tool;
  private DrawingCanvas canvas;
  public DrawingEventMouseMotion(DrawingCanvas canvas, Tool tool){
    this.tool = tool;
    this.canvas = canvas;
  }
  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {
    if(!canvas.stateMouseEdition()){
      Point point = mouseEvent.getPoint();
      if (!tool.getName().equals("Rectangle"))
        tool.addPointToShape(point);
    }
  }
  Rectangle rectangle = new Rectangle(0,0,5,5);
  @Override
  public void mouseMoved(MouseEvent mouseEvent) {
    if(canvas.stateMouseEdition()){
      ListShape listShape = canvas.getShapes();
      rectangle.setLocation(mouseEvent.getPoint());
      for (Shape shape : listShape.getShapes()){
        if(shape.getName().equals("Rectangle")){
          Point point1 = shape.getPoint1();
          Point point2 = shape.getPoint2();
          int x = Math.abs(point1.x-point2.x);
          int y = Math.abs(point1.y-point2.y);
          Rectangle rectangle1 = new Rectangle(point1.x,point1.y,x,y);
          if(rectangle.intersects(rectangle1)){
            canvas.setCursor(cursorSelection);
          }
          else {
            canvas.setCursor(cursorEdition);
          }

        }
      }
    }

  }
}

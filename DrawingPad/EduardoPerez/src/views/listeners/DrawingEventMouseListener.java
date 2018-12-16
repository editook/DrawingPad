package views.listeners;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import shapes.RectangleShape;
import shapes.Shape;
import views.canvas.toolkit.Tool;
import views.components.windows.frame.ListShape;
import views.components.windows.panels.DrawingCanvas;

public class DrawingEventMouseListener implements MouseListener {

  private Tool tool;
  private DrawingCanvas canvas;
  public DrawingEventMouseListener(DrawingCanvas canvas, Tool tool) {
    this.tool = tool;
    this.canvas = canvas;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    if(canvas.stateMouseEdition()){

      ListShape listShape = canvas.getShapes();
      Rectangle rectangle = new Rectangle(mouseEvent.getX(),mouseEvent.getY(),5,5);
      for (Shape shape : listShape.getShapes()){
        if(shape.getName().equals("Rectangle")){

          Point point1 = shape.getPoint1();
          Point point2 = shape.getPoint2();
          int x = Math.abs(point1.x-point2.x);
          int y = Math.abs(point1.y-point2.y);
          Rectangle rectangle1 = new Rectangle(point1.x,point1.y,x,y);
          System.out.println(shape.getName());
          if(rectangle.intersects(rectangle1)){
            System.out.println("modo seleccion");
            String name = JOptionPane.showInputDialog(canvas, "Name into the Class?");
            //Graphics g = canvas.getGraphics();
            RectangleShape rectangleShape = (RectangleShape) shape;
            rectangleShape.setTextoShape(name);
            canvas.repaint();
            break;
          }

        }
      }

    }

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
    if(!canvas.stateMouseEdition()){
      int s = mouseEvent.getButton();
      if(s==1){
        Point point = mouseEvent.getPoint();
        tool.startShape(point);
      }
    }
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    if (!canvas.stateMouseEdition()){
      int s = mouseEvent.getButton();
      if(s==1){
        Point point = mouseEvent.getPoint();
        tool.endShape(point);
      }
    }


  }

  @Deprecated
  public void mouseEntered(MouseEvent mouseEvent) {


  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }
}

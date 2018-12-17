package views.listeners;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import org.omg.PortableServer.POA;
import shapes.LineShape;
import shapes.RectangleShape;
import shapes.Shape;
import shapes.TwoEndsShape;
import shapes.uml.ClassShape;
import shapes.uml.RelationShip;
import views.canvas.toolkit.Tool;
import views.canvas.toolkit.TwoEndsTool;
import views.components.windows.frame.ListShape;
import views.components.windows.panels.DrawingCanvas;

public class DrawingEventMouseListener implements MouseListener {

  private Tool tool;
  private DrawingCanvas canvas;
  private TwoEndsShape reacion;
  public DrawingEventMouseListener(DrawingCanvas canvas, Tool tool) {
    this.tool = tool;
    this.canvas = canvas;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int value = canvas.stateMouseEdition();
    Point point = mouseEvent.getPoint();
    if(value==1){//create class

      ClassShape classShape = new ClassShape(canvas.getCurrentColor());
      String name = JOptionPane.showInputDialog(canvas, "Name class name:");
      classShape.setTitleClass(name);
      Point point1 = new Point(point.x+100,point.y+70);
      classShape.setPoint1(point);
      classShape.setPoint2(point1);
      canvas.addShape(classShape);
      canvas.repaint();

    }

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
    int value = canvas.stateMouseEdition();
    Point point = mouseEvent.getPoint();
    if(value ==0){//figure
      tool.startShape(point);
    }
    else{
      if(value ==2){//relationShip
        //continue
        reacion= new LineShape(canvas.getCurColor());
        reacion.setPoint1(point);
      }
    }
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    int value = canvas.stateMouseEdition();
    if(value==0){//figure
      tool.endShape(point);
    }
    else{
      if(value==3){//class edit name
        if(canvas.isColisionClassShape(point)){
          String name = JOptionPane.showInputDialog(canvas, "Rename class name:");
          canvas.changeClassName(name,point);
          canvas.repaint();
        }
      }
      else{
        if(value ==2){
          System.out.println(value);
          reacion.setPoint2(point);
          canvas.addRelationShape(reacion);
          canvas.repaint();
        }
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

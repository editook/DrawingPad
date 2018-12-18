package views.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import shapes.LineShape;
import shapes.TwoEndsShape;
import shapes.uml.ClassShape;
import views.canvas.toolkit.Tool;
import views.components.windows.panels.DrawingCanvas;

public class DrawingEventMouseListener implements MouseListener {

  private Tool tool;
  private DrawingCanvas canvas;
  private TwoEndsShape reacion;
  private int valueRelationShip;

  public DrawingEventMouseListener(DrawingCanvas canvas, Tool tool) {
    this.tool = tool;
    this.canvas = canvas;
    this.valueRelationShip = 0;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  private void setSelected(String valueSelected) {
    switch (valueSelected) {
      case "Inheritance":
        valueRelationShip = 1;
        break;
      case "Agregation":
        valueRelationShip = 2;
        break;
      case "Association":
        valueRelationShip = 0;
    }
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    int value = canvas.stateMouseEdition();
    if (value == 3) {//class edit name
      if (canvas.isColisionClassShape(point)) {
        String name = JOptionPane.showInputDialog(canvas, "Rename class name:");
        canvas.changeClassName(name, point);
        canvas.repaint();
      }
      canvas.setChangeMouseEdition(0);
    }
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    int value = canvas.stateMouseEdition();
    if (!tool.getName().equals("Class") && value != 3) {
      setSelected(tool.getName());
      reacion = new LineShape(canvas.getCurColor());
      reacion.setPoint1(point);
    }
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    int value = canvas.stateMouseEdition();
    if (tool.getName().equals("Class") && value != 3) {
      ClassShape classShape = new ClassShape(canvas.getCurrentColor());
      String name = JOptionPane.showInputDialog(canvas, "Name class name:");
      classShape.setTitleClass(name);
      Point point1 = new Point(point.x + 100, point.y + 70);
      classShape.setPoint1(point);
      classShape.setPoint2(point1);
      canvas.addShape(classShape);
      canvas.repaint();
    }
    if (!tool.getName().equals("Class") && value != 3) {
      reacion.setPoint2(point);
      canvas.setTypeRelationShip(valueRelationShip);
      canvas.addRelationShape(reacion);
      canvas.repaint();
    }
  }

  @Deprecated
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }
}

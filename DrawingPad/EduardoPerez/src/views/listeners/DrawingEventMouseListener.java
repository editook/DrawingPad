package views.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.canvas.toolkit.Tool;

public class DrawingEventMouseListener implements MouseListener {
  private Tool tool;
  public DrawingEventMouseListener(Tool tool){
    this.tool = tool;
  }
  public void setTool(Tool tool) {
    this.tool = tool;
  }
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    tool.startShape(point);
  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    tool.endShape(point);
  }

  @Deprecated
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }
}

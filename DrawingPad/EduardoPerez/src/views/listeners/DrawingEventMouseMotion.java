package views.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import views.canvas.toolkit.ScribbleTool;
import views.canvas.toolkit.Tool;

public class DrawingEventMouseMotion implements MouseMotionListener {

  private Tool tool;

  public DrawingEventMouseMotion(Tool tool){
    this.tool = tool;
  }
  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {
    Point point = mouseEvent.getPoint();
    tool.addPointToShape(point);
  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {

  }
}

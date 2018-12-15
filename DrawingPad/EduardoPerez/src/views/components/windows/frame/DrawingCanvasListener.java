package views.components.windows.frame;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import views.canvas.toolkit.ScribbleTool;
import views.canvas.toolkit.Tool;

public class DrawingCanvasListener
        implements MouseListener, MouseMotionListener {

  private DrawingCanvas canvas;
  private Tool tool;

  public DrawingCanvasListener(DrawingCanvas canvas) {
    this.canvas = canvas;
    tool = new ScribbleTool(canvas, "Scribble");
  }

  public DrawingCanvasListener(DrawingCanvas canvas, Tool tool) {
    this.canvas = canvas;
    this.tool = tool;
  }

  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    Point point = e.getPoint();
    tool.startShape(point);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    Point point = e.getPoint();
    tool.addPointToShape(point);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point point = e.getPoint();
    tool.endShape(point);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

}

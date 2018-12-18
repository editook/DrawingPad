package views.listeners;

import views.canvas.toolkit.ScribbleTool;
import views.canvas.toolkit.Tool;
import views.components.windows.panels.DrawingCanvas;

public class DrawingCanvasListener {

  private Tool tool;
  private DrawingEventMouseListener drawingEventMouseListener;

  public DrawingCanvasListener(DrawingCanvas canvas) {
    tool = new ScribbleTool(canvas, "Scribble");
    drawingEventMouseListener = new DrawingEventMouseListener(canvas, tool);
    DrawingEventMouseMotion drawingEventMouseMotion = new DrawingEventMouseMotion(canvas);
    canvas.addMouseListener(drawingEventMouseListener);
    canvas.addMouseMotionListener(drawingEventMouseMotion);
  }

  public void setTool(Tool tool) {
    this.tool = tool;
    drawingEventMouseListener.setTool(tool);
  }

}

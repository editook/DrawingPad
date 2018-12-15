package views.listeners;

import views.canvas.toolkit.ScribbleTool;
import views.canvas.toolkit.Tool;
import views.components.windows.panels.DrawingCanvas;

public class DrawingCanvasListener{

  private DrawingCanvas canvas;
  private Tool tool;
  private DrawingEventMouseMotion drawingEventMouseMotion;
  private DrawingEventMouseListener drawingEventMouseListener;
  public DrawingCanvasListener(DrawingCanvas canvas) {
    this.canvas = canvas;
    tool = new ScribbleTool(canvas, "Scribble");
    drawingEventMouseListener = new DrawingEventMouseListener(tool);
    drawingEventMouseMotion = new DrawingEventMouseMotion(tool);
    canvas.addMouseListener(drawingEventMouseListener);
    canvas.addMouseMotionListener(drawingEventMouseMotion);
  }

  public void setTool(Tool tool) {
    this.tool = tool;
    drawingEventMouseMotion.setTool(tool);
    drawingEventMouseListener.setTool(tool);
  }

}

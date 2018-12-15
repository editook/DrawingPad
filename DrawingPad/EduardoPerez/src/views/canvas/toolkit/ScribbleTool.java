package views.canvas.toolkit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import shapes.StrokeShape;
import views.components.windows.frame.DrawingCanvas;

public class ScribbleTool implements Tool {

  private final DrawingCanvas canvas;
  private final String name;
  private StrokeShape currentStrokeShape;
  private Color color;

  public ScribbleTool(DrawingCanvas canvas, String name) {
    this.canvas = canvas;
    this.name = name;
    currentStrokeShape = null;
    color = canvas.getCurrentColor();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void startShape(Point point) {
    color = canvas.getCurrentColor();
    currentStrokeShape = new StrokeShape(color);
    currentStrokeShape.addPoint(point);
  }

  @Override
  public void addPointToShape(Point point) {
    if (currentStrokeShape != null) {
      Point lastPoint = currentStrokeShape.lastAddedPoint();
      currentStrokeShape.addPoint(point);
      Graphics g = canvas.getGraphics();
      g.setColor(color);
      g.drawLine(lastPoint.x, lastPoint.y, point.x, point.y);
    }
  }

  @Override
  public void endShape(Point point) {
    if (currentStrokeShape != null) {
      currentStrokeShape.addPoint(point);
      canvas.addShape(currentStrokeShape);
      currentStrokeShape = null;
    }
  }

}

package views.canvas.toolkit;

import java.awt.Color;
import java.awt.Point;
import shapes.LineShape;
import shapes.Shape;
import views.components.windows.panels.DrawingCanvas;

public class ScribbleTool implements Tool {

  private final DrawingCanvas canvas;
  private final String name;
  private Color color;
  private Shape shape;
  public ScribbleTool(DrawingCanvas canvas, String name) {
    this.canvas = canvas;
    this.name = name;
    color = canvas.getCurrentColor();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void startShape(Point point) {
    color = canvas.getCurrentColor();
    shape= new LineShape(color);
  }

  @Override
  public void endShape(Point point) {
    shape.setPoint2(point);
    canvas.addShape(shape);
  }

}

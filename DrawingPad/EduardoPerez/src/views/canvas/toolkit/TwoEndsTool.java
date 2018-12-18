package views.canvas.toolkit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import shapes.TwoEndsShape;
import views.components.windows.panels.DrawingCanvas;

public class TwoEndsTool implements Tool {

  private final DrawingCanvas canvas;
  private final String name;
  private int xStart;
  private int yStart;
  private int xEnd;
  private int yEnd;
  private Color color;
  private TwoEndsShape shape;

  public TwoEndsTool(DrawingCanvas canvas, String name, TwoEndsShape shape) {
    this.canvas = canvas;
    this.name = name;
    this.shape = shape;
    color = canvas.getCurrentColor();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void startShape(Point point) {
    xStart = point.x;
    xEnd = point.x;
    yStart = point.y;
    yEnd = point.y;
    color = canvas.getCurrentColor();
    Graphics g = canvas.getGraphics();
    g.setXORMode(canvas.getBackground());

    shape.setColor(color);
    shape.setEnds(xStart, yStart, xEnd, yEnd);
    shape.draw(g);
  }

  @Override
  public void endShape(Point point) {
    shape.setPoint2(point);
    canvas.addShape(shape);
  }

}

package views.canvas.toolkit;

import java.awt.Point;

public interface Tool {

  String getName();
  void startShape(Point point);
  void endShape(Point point);

}

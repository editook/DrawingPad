package views.components.windows.frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsClose extends WindowAdapter {

  private DrawingPad drawingPad;

  WindowsClose(DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
  }

  @Override
  public void windowClosing(WindowEvent e) {
    drawingPad.exit();
  }
}

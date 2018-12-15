import javax.swing.JFrame;
import views.components.windows.frame.DrawingPad;

public class App {

  private static final String DRAWING_PAD = "Drawing Pad";

  public static void main(String[] arg) {
    JFrame drawingPad = new DrawingPad(DRAWING_PAD);
    drawingPad.setVisible(true);
  }
}

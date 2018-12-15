package views.listeners;


import javax.swing.JMenuItem;
import views.components.windows.frame.DrawingCanvas;
import views.components.windows.frame.DrawingPad;

public class SaveFileItem extends JMenuItem implements Performable {

  private final DrawingPad scribble;
  private final DrawingCanvas canvas;

  public SaveFileItem(String text, DrawingPad scribble, DrawingCanvas canvas) {
    super(text);
    this.scribble = scribble;
    this.canvas = canvas;
  }

  @Override
  public void perform() {
    saveFile();
  }

  private void saveFile() {
    String currentFileName = scribble.getCurrentFileName();
    if (currentFileName == null) {
      currentFileName = "Untitled";
    }
    canvas.saveFile(currentFileName);
    scribble.setTitle("Scribble Pad [" + currentFileName + "]");
  }

}

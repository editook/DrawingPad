package views.components.windows.dialogs.files;

import java.io.File;
import javax.swing.JFileChooser;
import views.components.windows.frame.DrawingPad;

public class FileChooser implements FileChooserI {

  private static JFileChooser CHOOSER = new JFileChooser(".");
  private DrawingPad drawingPad;

  public FileChooser(DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
  }

  private int getChooser(String title){
    return CHOOSER.showDialog(drawingPad, title);
  }
  @Override
  public String getPathUrlOpen(String title) {
    if (getChooser(title) == 0) {
      File theFile = CHOOSER.getSelectedFile();
      if (theFile != null) {
        if (theFile.isFile()) {
          return CHOOSER.getSelectedFile().getAbsolutePath();
        }
      }
    }
    return null;
  }

  @Override
  public String getPathUrlSaveChanges() {
    String output = null;
    String title = "Save As";
    if (getChooser(title)==0) {
      File theFile = CHOOSER.getSelectedFile();
      if (theFile != null) {
        if (!theFile.isDirectory()) {
          return CHOOSER.getSelectedFile().getAbsolutePath();
        }
      }
    }
    return output;
  }
}

package views.components.windows.dialogs.files;

import java.io.File;
import javax.swing.JFileChooser;
import views.components.windows.frame.DrawingPad;

public class FileChooser {

  private static JFileChooser CHOOSER = new JFileChooser(".");
  private DrawingPad drawingPad;

  public FileChooser(DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
  }

  public String getPathUrlSave(String title) {
    String output = null;
    int retval = CHOOSER.showDialog(drawingPad, title);
    if (retval == JFileChooser.APPROVE_OPTION) {
      File theFile = CHOOSER.getSelectedFile();
      if (theFile != null) {
        if (theFile.isFile()) {
          return CHOOSER.getSelectedFile().getAbsolutePath();
        }
      }
    }
    return output;
  }

  public String getPathUrlOpen(String title) {
    int retval = CHOOSER.showDialog(drawingPad, title);
    if (retval == JFileChooser.APPROVE_OPTION) {
      File theFile = CHOOSER.getSelectedFile();
      if (theFile != null) {
        if (theFile.isFile()) {
          return CHOOSER.getSelectedFile().getAbsolutePath();
        }
      }
    }
    return null;
  }

  public String getPathUrlSaveChanges() {
    String output = null;
    int retval = CHOOSER.showDialog(drawingPad, "Save As");
    if (retval == JFileChooser.APPROVE_OPTION) {
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

package views.components.windows.dialogs.closewindow;

import java.awt.Component;
import javax.swing.JOptionPane;
import views.components.windows.frame.DrawingPad;

public abstract class AlertDialog extends JOptionPane {
  private String title,message;
  private DrawingPad drawingPad;
  public AlertDialog(String title, String message, DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
    this.message = message;
    this.title = title;
  }

  public boolean alertExitSaveChanges(){
    int result = showConfirmDialog(drawingPad,
        message,
        title,
        YES_NO_OPTION);
    return result == YES_OPTION;
  }
}

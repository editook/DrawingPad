package views.components.windows.dialogs.closewindow;

import javax.swing.JOptionPane;
import views.components.windows.frame.DrawingPad;

public abstract class AlertDialog extends JOptionPane implements ChangeDialog {

  private DrawingPad drawingPad;

  public AlertDialog(DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
  }

  @Override
  public abstract void setMesssage(String message);

  @Override
  public abstract String getTitle();

  @Override
  public abstract void setTitle(String title);

  public abstract String getMessage();

  public boolean alertExitSaveChanges() {
    int result = showConfirmDialog(drawingPad,
        getMessage(),
        getTitle(),
        YES_NO_OPTION);
    return result == YES_OPTION;
  }
}

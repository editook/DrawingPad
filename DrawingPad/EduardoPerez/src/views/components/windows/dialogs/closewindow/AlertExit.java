package views.components.windows.dialogs.closewindow;

import views.components.windows.frame.DrawingPad;

public class AlertExit extends AlertDialog {

  private String title, message;

  public AlertExit(DrawingPad drawingPad) {
    super(drawingPad);
  }

  @Override
  public void setMesssage(String message) {
    this.message = message;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String getMessage() {
    return message;
  }
}

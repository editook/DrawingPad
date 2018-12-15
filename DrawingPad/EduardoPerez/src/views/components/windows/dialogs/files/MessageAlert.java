package views.components.windows.dialogs.files;

import views.components.windows.frame.DrawingPad;

public class MessageAlert implements MessageDialog {

  private static final String SAVE_AS = "Save As";
  private FileChooser fileChooser;

  public MessageAlert(DrawingPad drawingPad) {
    fileChooser = new FileChooser(drawingPad);
  }

  @Override
  public String openFileListener(String title) {

    return fileChooser.getPathUrlOpen(title);
  }

  @Override
  public String saveFileListener() {
    return fileChooser.getPathUrlSave(SAVE_AS);
  }

  @Override
  public String saveAsFileListener() {
    return fileChooser.getPathUrlSaveChanges();
  }

}

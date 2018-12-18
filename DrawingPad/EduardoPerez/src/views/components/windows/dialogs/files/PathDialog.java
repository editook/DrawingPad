package views.components.windows.dialogs.files;

import views.components.windows.frame.DrawingPad;

public class PathDialog implements PathDialogI {

  private FileChooser fileChooser;

  public PathDialog(DrawingPad drawingPad) {
    fileChooser = new FileChooser(drawingPad);
  }

  @Override
  public String openFileListener(String title) {

    return fileChooser.getPathUrlOpen(title);
  }

  @Override
  public String saveAsFileListener() {
    return fileChooser.getPathUrlSaveChanges();
  }

}

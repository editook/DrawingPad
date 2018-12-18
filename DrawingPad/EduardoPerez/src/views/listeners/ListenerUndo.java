package views.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.components.windows.frame.DrawingPad;

public class ListenerUndo implements MouseListener {

  private DrawingPad drawingPad;

  public ListenerUndo(DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    drawingPad.UndoChange();
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }
}

package views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.components.windows.frame.DrawingPad;

public class ListenerUndo implements MouseListener {

  private DrawingPad drawingPad;

  public ListenerUndo(DrawingPad drawingPad) {
    this.drawingPad = drawingPad;
  }

  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println(actionEvent.getActionCommand());
    drawingPad.UndoChange();
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    //System.out.println(mouseEvent.getActionCommand());
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

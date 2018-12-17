package views.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.components.windows.dialogs.colors.ColorDialog;
import views.components.windows.dialogs.files.PathDialog;
import views.components.windows.dialogs.files.PathDialogI;
import views.components.windows.frame.DrawingPad;
import views.components.windows.panels.DrawingCanvas;
import views.menus.StaticMenu;

public class ListenerMenuBar implements ActionListener {

  private DrawingCanvas canvas;
  private String currentFilename;
  private DrawingPad drawingPad;
  private PathDialogI messageDialog;

  public ListenerMenuBar(DrawingPad drawingPad, DrawingCanvas canvas, String currentFilename) {
    this.canvas = canvas;
    this.drawingPad = drawingPad;
    this.currentFilename = currentFilename;
    messageDialog = new PathDialog(drawingPad);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case StaticMenu.NEW:
        newFile();
        break;
      case StaticMenu.OPEN:
        openFileListener();
        break;
      case StaticMenu.SAVE:
        saveFileListener();
        break;
      case StaticMenu.SAVE_AS:
        saveAsFileListener();
        break;
      case StaticMenu.EXIT:
        exit();
        break;
      case StaticMenu.COLOR:
        colorListener();
        break;
      case StaticMenu.ABOUT:
        aboutListener();
        break;
      case StaticMenu.RELATION_SHIP:
        canvas.setChangeMouseEdition(2);
        break;
      case StaticMenu.NONE:
        canvas.setChangeMouseEdition(0);
        canvas.setCurrentColor(Color.BLACK);
        break;
      case StaticMenu.CLASS:
        canvas.setChangeMouseEdition(1);
        break;
      case StaticMenu.CLASS_NAME:
        canvas.setChangeMouseEdition(3);
        break;
      case StaticMenu.HERENCIA:
        canvas.setChangeMouseEdition(2);
        canvas.setTypeRelationShip(1);
        break;
      case StaticMenu.ASOCIATION:
        canvas.setChangeMouseEdition(2);
        canvas.setTypeRelationShip(2);
        break;
      case StaticMenu.RElATION_SIMPLE:
        canvas.setChangeMouseEdition(2);
        canvas.setTypeRelationShip(0);
        break;
    }

  }

  private void newFile() {
    currentFilename = null;
    canvas.newFile();
    drawingPad.setTitle("Scribble Pad [" + currentFilename + "]");
  }

  /*me eh rallado aqui no me acuerdo*/
  private void saveFile() {
    if (currentFilename == null) {
      currentFilename = "Untitled";
    }
    canvas.saveFile(currentFilename);
    drawingPad.setTitle("Scribble Pad [" + currentFilename + "]");
  }

  private void openFileListener() {
    String valueRequest = messageDialog.openFileListener("Open");
    if (valueRequest != null) {
      currentFilename = valueRequest;
      canvas.openFile(currentFilename);
      drawingPad.setTitle("Scribble Pad [" + currentFilename + "]");
    }
  }

  private void saveFileAs(String filename) {
    currentFilename = filename;
    canvas.saveFile(filename);
    drawingPad.setTitle("Scribble Pad [" + currentFilename + "]");
  }

  private void saveAsFileListener() {
    String filename = messageDialog.saveAsFileListener();
    if (filename != null) {
      saveFileAs(filename);
    }
  }

  private void saveFileListener() {
    String filename = messageDialog.saveFileListener();
    if (filename != null) {
      saveFileAs(filename);
    }
  }

  private void exit() {
    drawingPad.exit();
  }

  private void colorListener() {
    ColorDialog dialog =
        new ColorDialog(drawingPad, "Choose color", canvas.getCurColor());
    Color result = dialog.showDialog();
    if (result != null) {
      canvas.setCurrentColor(result);
    }
  }

  private void aboutListener() {
    JOptionPane.showMessageDialog(drawingPad,
        "views.components.windows.frame.DrawingPad version 1.0\nCopyright (c) Xiaoping Jia 2002",
        "About",
        JOptionPane.INFORMATION_MESSAGE);
  }

}

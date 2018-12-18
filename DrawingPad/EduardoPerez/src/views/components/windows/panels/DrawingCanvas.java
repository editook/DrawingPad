package views.components.windows.panels;

import datos.Connection;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModeloSerializable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import javax.swing.JPanel;
import shapes.Drawable;
import shapes.Shape;
import views.canvas.toolkit.Tool;
import views.components.windows.frame.ListShape;
import views.listeners.DrawingCanvasListener;

public class DrawingCanvas extends JPanel {

  private ListShape shapes;

  private Color currentColor = Color.black;
  private int modeEition;
  private DrawingCanvasListener listener;
  private int typeRelationShip;

  public DrawingCanvas() {
    shapes = new ListShape();
    listener = makeCanvasListener();
    modeEition = 0;
    typeRelationShip = 0;
  }

  public Color getCurrentColor() {
    return currentColor;
  }

  public void setCurrentColor(Color curColor) {
    this.currentColor = curColor;
  }

  public void addShape(Drawable shape) {
    if (shape != null) {
      shapes.add((Shape) shape);
    }
  }

  public ListShape getShapes() {
    return shapes;
  }

  public void setTool(Tool tool) {
    listener.setTool(tool);
  }


  @Override
  public void paint(Graphics g) {
    Dimension dim = getSize();
    g.setColor(Color.white);
    g.fillRect(0, 0, dim.width, dim.height);
    g.setColor(Color.black);
    if (shapes != null) {
      Iterator iter = shapes.iterator();
      while (iter.hasNext()) {
        Drawable shape = (Drawable) iter.next();
        if (shape != null) {
          shape.draw(g);
        }
      }
    }
  }

  public void setTypeRelationShip(int typeRelationShip) {
    this.typeRelationShip = typeRelationShip;
  }

  public void newFile() {
    shapes.clear();
    repaint();
  }

  public void openFile(String filename) {
    shapes.clear();
    shapes.updateList(filename);
    repaint();
  }

  public void saveFile(String currentFilename) {
    if (currentFilename == null) {
      currentFilename = "Untitled";
    }

    ModeloSerializable modeloSerializable = new ListModelShape();
    modeloSerializable.setModelShape(shapes.updateShapesList());
    Connection.setFileSerialized(modeloSerializable, currentFilename);

  }

  public void setChangeMouseEdition(int modeEition) {
    this.modeEition = modeEition;
  }

  public int stateMouseEdition() {
    return modeEition;
  }

  private DrawingCanvasListener makeCanvasListener() {
    return new DrawingCanvasListener(this);
  }

  public Color getCurColor() {
    return currentColor;//mal
  }

  public boolean stateShapes() {
    return !shapes.isEmpty();
  }

  public void UndoChange() {
    shapes.removeLatest();
    repaint();
  }

  public boolean isColisionClassShape(Point point) {
    return shapes.isColisionClass(point);
  }

  public void changeClassName(String name, Point pointer) {
    if (name != null) {
      shapes.renameClassName(name, pointer);
    }
  }

  public void addRelationShape(Shape relationShip) {
    shapes.addRelationShapre(relationShip, typeRelationShip);
  }

  public void setStateChanges(boolean b) {
    shapes.setStateChanges(b);
  }
}

package views.components.windows.panels;

import datos.Acceso;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModeloSerializable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
  private boolean stateMouse;
  private DrawingCanvasListener listener;

  public DrawingCanvas() {
    shapes = new ListShape();
    listener = makeCanvasListener();
    //addMouseListener((MouseListener) listener);
    //addMouseMotionListener((MouseMotionListener) listener);
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
  public ListShape getShapes(){
    return shapes;
  }
  public void setColorSelected(Shape shape){
    if(shape!=null){
      shapes.setColorSelected(shape);
    }
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

  public void newFile() {
    shapes.clear();
    repaint();
  }

  public void openFile(String filename) {
    shapes.updateList(filename);
    repaint();
  }

  public void saveFile(String currentFilename) {
    if (currentFilename == null) {
      currentFilename = "Untitled";
    }

    ModeloSerializable modeloSerializable = new ListModelShape();
    modeloSerializable.setModelShape(shapes.updateShapesList());
    Acceso.setOutputStream(modeloSerializable, currentFilename);

  }
  public void setChangeMouseEdition(){
    stateMouse = ! stateMouse;
  }
  public boolean stateMouseEdition(){
    return stateMouse;
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
}

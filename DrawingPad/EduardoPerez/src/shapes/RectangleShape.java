package shapes;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class RectangleShape extends TwoEndsShape {
  private static final String RECTANGLE = "Rectangle";
  private TextoShape textoShape;
  public RectangleShape(Color color) {
    super(color);
    textoShape = new TextoShape(null);
  }
  public void setTextoShape(String text){
    textoShape.setNameText(text);
  }
  public String getTextShape(){
    return textoShape.getNameText();
  }
  @Override
  public void draw(Graphics g) {
    Point point1 = getPoint1();
    Point point2 = getPoint2();
    int x = Math.min(point1.x, point2.x);
    int y = Math.min(point1.y, point2.y);
    int w = Math.abs(point1.x - point2.x) + 1;
    int h = Math.abs(point1.y - point2.y) + 1;
    g.drawRect(x, y, w, h);
    if(textoShape.getNameText()!=null){
      textoShape.draw(g,x,y);
    }

  }

  public String getName() {
    return RECTANGLE;
  }

  @Override
  public ArrayList<Point> getPoints() {
    return new ArrayList<Point>();
  }
}

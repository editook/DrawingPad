package shapes;

import java.awt.Color;
import java.awt.Point;

public abstract class TwoEndsShape extends Shape implements Cloneable {

  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public TwoEndsShape(Color color) {
    super(color);
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public void setEnds(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
@Override
  public void setPoint1(Point point1){
    x1 =point1.x;
    y1 = point1.y;
  }
  @Override
  public void setPoint2(Point point1){
    x2 =point1.x;
    y2 = point1.y;
  }
@Override
  public Point getPoint1() {
    return new Point(x1, y1);
  }
  @Override
  public Point getPoint2() {
    return new Point(x2, y2);
  }
}

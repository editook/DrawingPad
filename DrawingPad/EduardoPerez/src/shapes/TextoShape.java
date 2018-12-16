package shapes;

import java.awt.Graphics;

public class TextoShape{
  private String nameText;
  public TextoShape(String nameText){
    this.nameText = nameText;
  }

  public void draw(Graphics g,int x,int y) {
    y = y+12;
    x = x+10;
    if(nameText!=null){
      g.drawString(nameText,x,y);
    }

  }
}

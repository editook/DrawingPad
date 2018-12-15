package views.components.windows.frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import views.listeners.ExitItem;

public class ExitWindow extends WindowAdapter {

  private final ExitItem exitItem;
          
  public ExitWindow(ExitItem exitItem) {
    this.exitItem = exitItem;
  }
  
  @Override
  public void windowClosing(WindowEvent e) {
    exitItem.perform();
  }

}

package views.menus;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import views.components.windows.frame.DrawingCanvas;
import views.components.windows.frame.DrawingPad;
import views.listeners.ListenerMenuBar;

public class MenuBar extends JMenuBar {

  private int index;
  private ListenerMenuBar listenerMenu;

  public MenuBar(DrawingPad drawingPad, DrawingCanvas canvas, String currentFilename) {
    index = 0;
    listenerMenu = new ListenerMenuBar(drawingPad, canvas, currentFilename);
  }

  public void addMenu(String name) {
    JMenu menu = new JMenu(name);
    add(menu);
    index++;
  }

  public void addMenuItem(String nameMenu, String nameItem) {
    JMenu menu = getMenu(nameMenu);
    if (menu != null) {
      menu.add(getNewItem(nameItem));
    }
  }

  private JMenu getMenu(String nameMenu) {
    JMenu menu;
    for (int i = 0; i < index; i++) {
      menu = getMenu(i);
      if (menu != null && (menu.getText().equals(nameMenu))) {
        return menu;
      }
    }
    return null;
  }

  private JMenuItem getNewItem(String nameItem) {
    JMenuItem menuItem = new JMenuItem(nameItem);
    menuItem.setActionCommand(nameItem);
    menuItem.addActionListener(listenerMenu);
    return menuItem;
  }

  public void addEspace() {
    add(Box.createHorizontalGlue());
    index++;
  }
}

package views.menus;

import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import views.components.windows.frame.DrawingPad;
import views.components.windows.panels.DrawingCanvas;
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


  public void createMenu(String name, String subMenu1, String subMenu2, String subMenu3) {
    JMenu menu2 = getMenu(StaticMenu.NEW_CLASS);
    JMenu menu = new JMenu(name);
    JMenuItem menuItem1 = new JMenuItem(subMenu1);
    menuItem1.setActionCommand(subMenu1);
    menuItem1.addActionListener(listenerMenu);
    JMenuItem menuItem2 = new JMenuItem(subMenu2);
    menuItem2.setActionCommand(subMenu2);
    menuItem2.addActionListener(listenerMenu);
    JMenuItem menuItem3 = new JMenuItem(subMenu3);
    menuItem3.setActionCommand(subMenu3);
    menuItem3.addActionListener(listenerMenu);
    menu.add(menuItem1);
    menu.add(menuItem2);
    menu.add(menuItem3);
    menu2.add(menu);
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

  public void addMenu(String name, MouseListener actionListenerUndo) {
    JMenu menu = new JMenu(name);
    menu.setActionCommand(name);
    menu.addMouseListener(actionListenerUndo);
    add(menu);
    index++;
  }
}

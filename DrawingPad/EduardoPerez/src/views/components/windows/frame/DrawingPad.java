package views.components.windows.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import shapes.LineShape;
import shapes.OvalShape;
import shapes.RectangleShape;
import views.canvas.toolkit.ScribbleTool;
import views.canvas.toolkit.Tool;
import views.canvas.toolkit.TwoEndsTool;
import views.components.windows.dialogs.closewindow.AlertDialog;
import views.components.windows.dialogs.closewindow.AlertDialogExit;
import views.components.windows.dialogs.closewindow.AlertDialogSave;
import views.menus.MenuBar;
import views.menus.StaticMenu;

public class DrawingPad extends JFrame {
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;
  private DrawingCanvas canvas;
  private String currentFileName;
  private ToolKit toolkit;
  private JMenuBar menuBar;
  public DrawingPad(String title) {
    super(title);
    iniComponents();
    canvas = makeCanvas();
    initMenus();
    initTools();

    WindowsClose windowsClose = new WindowsClose(this);
    addWindowListener(windowsClose);
  }
  public void exit(){
    AlertDialog alert;
    boolean mode = canvas.stateShapes();
    if (mode) {
      alert = new AlertDialogSave("Exit Scribble Pad?",
          "Do you want to save changes", this);
    } else {
      alert = new AlertDialogExit("Exit Scribble Pad?",
          "Do you want to exit Scribble Pad?", this);
    }
    if (mode) {
      saveChanges(alert.alertExitSaveChanges());
    } else {
      exitDrawingPad(alert.alertExitSaveChanges());
    }

  }

  private void exitDrawingPad(boolean status) {
    if (status) {
      canvas.saveFile(currentFileName);
      System.exit(0);
    } else {
      setDefaultCloseOperation(DrawingPad.DO_NOTHING_ON_CLOSE);
    }
  }

  private void saveChanges(boolean status) {
    if (status) {
      canvas.saveFile(currentFileName);
    }
    System.exit(0);
  }

  private void initMenus() {

    menuBar = createMenuBar();
    setJMenuBar(menuBar);
    getContentPane().add(canvas, BorderLayout.CENTER);
  }
  private JMenuBar createMenuBar() {
    MenuBar menuBar = new MenuBar(this, canvas, currentFileName);
    menuBar.addMenu(StaticMenu.FILE);
    menuBar.addMenuItem(StaticMenu.FILE, StaticMenu.NEW);
    menuBar.addMenuItem(StaticMenu.FILE, StaticMenu.OPEN);
    menuBar.addMenuItem(StaticMenu.FILE, StaticMenu.SAVE);
    menuBar.addMenuItem(StaticMenu.FILE, StaticMenu.SAVE_AS);
    menuBar.addMenuItem(StaticMenu.FILE, StaticMenu.EXIT);
    menuBar.addMenu(StaticMenu.OPTION);
    menuBar.addMenuItem(StaticMenu.OPTION, StaticMenu.COLOR);
    // horizontal space
    menuBar.addEspace();
    menuBar.addMenu(StaticMenu.HELP);
    menuBar.addMenuItem(StaticMenu.HELP, StaticMenu.ABOUT);
    return menuBar;
  }
  private void iniComponents() {
    setLayout(new BorderLayout());
    setResizable(false);
    setSize(WIDTH, HEIGHT);
    setLocation(getDimension());
  }
  private Point getDimension() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    return new Point(screenSize.width / 2 - WIDTH / 2,
        screenSize.height / 2 - HEIGHT / 2);
  }

  private DrawingCanvas makeCanvas() {
    return new DrawingCanvas();
  }

  private void initTools() {
    toolkit = createToolkit();
    canvas.setTool(toolkit.getTool(0));
    ActionListener toolListener = event -> actionToolListener(event.getActionCommand());
    JComponent toolbar = createToolBar(toolListener);
    getContentPane().add(toolbar, BorderLayout.WEST);
    JMenu menuItemTool = createToolMenu(toolListener);
    menuBar.add(menuItemTool, 1); // insert at index position 1
  }
  private void actionToolListener(String nameTool) {
    if (nameTool != null) {
      Tool tool = toolkit.setSelectedTool(nameTool);
      canvas.setTool(tool);
    }
  }
  private ToolKit createToolkit() {
    toolkit = new ToolKit();
    toolkit.addTool(new ScribbleTool(canvas, "Scribble"));
    toolkit.addTool(new TwoEndsTool(canvas, "Line", new LineShape(Color.yellow)));
    toolkit.addTool(new TwoEndsTool(canvas, "Oval", new OvalShape(Color.yellow)));
    toolkit.addTool(new TwoEndsTool(canvas, "Rectangle", new RectangleShape(Color.yellow)));
    return toolkit;
  }

  private JComponent createToolBar(ActionListener toolListener) {
    JPanel toolbar = new JPanel(new GridLayout(0, 1));
    int n = toolkit.getToolCount();
    for (int i = 0; i < n; i++) {
      Tool tool = toolkit.getTool(i);
      if (tool != null) {
        JButton button = new JButton(tool.getName());
        button.addActionListener(toolListener);
        toolbar.add(button);
      }
    }
    return toolbar;
  }

  private JMenu createToolMenu(ActionListener toolListener) {
    JMenu menu = new JMenu("Tools");
    int n = toolkit.getToolCount();
    for (int i = 0; i < n; i++) {
      Tool tool = toolkit.getTool(i);
      if (tool != null) {
        JMenuItem menuItem = new JMenuItem(tool.getName());
        menuItem.addActionListener(toolListener);
        menu.add(menuItem);
      }
    }
    return menu;
  }

  public String getCurrentFileName() {
    return currentFileName;
  }

  public void setCurrentFileName(String fileName) {
    currentFileName = fileName;
  }


}

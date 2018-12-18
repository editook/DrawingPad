package views.components.windows.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import shapes.uml.ClassShape;
import shapes.uml.RelationShip;
import views.canvas.toolkit.Tool;
import views.canvas.toolkit.TwoEndsTool;
import views.components.windows.dialogs.closewindow.AlertDialog;
import views.components.windows.dialogs.closewindow.AlertExit;
import views.components.windows.panels.DrawingCanvas;
import views.listeners.ListenerUndo;
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
    currentFileName = null;
    WindowsClose windowsClose = new WindowsClose(this);
    addWindowListener(windowsClose);
  }

  public void exit() {
    AlertDialog alert = new AlertExit(this);
    boolean mode = canvas.stateShapes();
    alert.setTitle("Exit Scribble Pad?");
    if (mode) {
      alert.setMesssage("Do you want to save changes");
    } else {
      alert.setMesssage("Do you want to exit Scribble Pad?");
    }
    boolean request = alert.alertExitSaveChanges();
    if (mode) {
      saveChanges(request);
    } else {
      exitDrawingPad(request);
    }

  }

  public void UndoChange() {
    canvas.UndoChange();
  }

  private void exitDrawingPad(boolean status) {
    if (status) {
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
    MouseListener actionListenerUndo = new ListenerUndo(this);
    menuBar.addMenu(StaticMenu.UNDO, actionListenerUndo);
    menuBar.addMenu(StaticMenu.EDIT);
    menuBar.addMenuItem(StaticMenu.EDIT, StaticMenu.CLASS_NAME);
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
    canvas.setTool(toolkit.getFirst());
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
    toolkit.addTool(new TwoEndsTool(canvas, "Class",new ClassShape(canvas.getCurColor())));
    toolkit.addTool(new TwoEndsTool(canvas, "Inheritance",createRelationShip(1)));
    toolkit.addTool(new TwoEndsTool(canvas, "Agregation", createRelationShip(2)));
    toolkit.addTool(new TwoEndsTool(canvas, "Association", createRelationShip(0)));
    return toolkit;
  }
  private RelationShip createRelationShip(int value){
    return new RelationShip(canvas.getCurColor(), value);
  }
  private JComponent createToolBar(ActionListener toolListener) {
    JPanel toolbar = new JPanel(new GridLayout(0, 1));
    for (Tool tool : toolkit.getTools()) {
      JButton button = new JButton(tool.getName());
      button.addActionListener(toolListener);
      toolbar.add(button);
    }
    return toolbar;
  }

  private JMenu createToolMenu(ActionListener toolListener) {
    JMenu menu = new JMenu("Tools");
    for (Tool tool : toolkit.getTools()) {
      JMenuItem menuItem = new JMenuItem(tool.getName());
      menuItem.addActionListener(toolListener);
      menu.add(menuItem);
    }
    return menu;
  }

}

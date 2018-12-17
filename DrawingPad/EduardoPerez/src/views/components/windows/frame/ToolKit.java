package views.components.windows.frame;

import java.util.ArrayList;
import java.util.List;
import views.canvas.toolkit.Tool;

public class ToolKit {

  private List<Tool> tools;

  public ToolKit() {
    tools = new ArrayList<Tool>();
  }

  public List<Tool> getTools() {
    return tools;
  }

  /**
   * Add a new tool to the tool kit. Return the index of the new tool.
   *
   * @return number
   */
  public void addTool(Tool tool) {
    if (tool != null) {
      tools.add(tool);
    }
  }

  public Tool getFirst() {
    if (!tools.isEmpty()) {
      return tools.get(0);
    }
    return null;
  }

  public Tool findTool(String name) {
    if (name != null) {
      for (Tool tool : tools) {
        if (name.equals(tool.getName())) {
          return tool;
        }
      }
    }
    return null;
  }

  public Tool setSelectedTool(String name) {
    return findTool(name);
  }

}

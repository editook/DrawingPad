package datos.modelserializer;

import java.util.ArrayList;
import java.util.List;

public class ListModelShape implements ModeloSerializable {

  private List<ModelShape> modelShapeList;

  public ListModelShape() {
    modelShapeList = new ArrayList<ModelShape>();
  }

  @Override
  public List<ModelShape> getModelShape() {
    return modelShapeList;
  }

  @Override
  public void setModelShape(List<ModelShape> listModelShape) {
    modelShapeList.clear();
    modelShapeList.addAll(listModelShape);
  }
}

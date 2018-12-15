package datos.modelserializer;

import java.io.Serializable;
import java.util.List;

public interface ModeloSerializable extends Serializable {

  List<ModelShape> getModelShape();

  void setModelShape(List<ModelShape> listModelShape);

}

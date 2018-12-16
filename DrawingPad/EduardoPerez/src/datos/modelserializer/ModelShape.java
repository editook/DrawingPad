package datos.modelserializer;

import datos.model.ShapeBuild;
import java.io.Serializable;

public class ModelShape implements Comparable<ModelShape>, Serializable {

  private ShapeBuild shapeBuild;

  public ModelShape(ShapeBuild shapeBuild) {
    this.shapeBuild = shapeBuild;
  }

  @Override
  public int compareTo(ModelShape modelShape) {
    return 0;
  }

  public ShapeBuild getShapeBuild() {
    return shapeBuild;
  }
}

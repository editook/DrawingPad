package datos.modelserializer;

import datos.model.ShapeBuild;
import java.io.Serializable;

public class ModelShape implements Serializable {

  private ShapeBuild shapeBuild;

  public ModelShape(ShapeBuild shapeBuild) {
    this.shapeBuild = shapeBuild;
  }


  public ShapeBuild getShapeBuild() {
    return shapeBuild;
  }
}

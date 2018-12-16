package datos.model;

import java.io.Serializable;
import shapes.Shape;

public interface ShapeBuild extends Serializable {

  Shape getShape();
}

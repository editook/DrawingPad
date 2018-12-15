package datos.model;

import java.io.Serializable;
import shapes.Shape;

public interface Share extends Serializable {

  Shape getShape();
}

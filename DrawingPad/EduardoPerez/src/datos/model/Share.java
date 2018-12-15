package datos.model;

import java.awt.Color;
import java.io.Serializable;
import shapes.Drawable;
import shapes.Shape;

public interface Share extends Serializable {
  Shape getShape();
}

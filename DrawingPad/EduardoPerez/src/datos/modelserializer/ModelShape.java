package datos.modelserializer;

import datos.model.Share;
import java.io.Serializable;

public class ModelShape implements Comparable<ModelShape>, Serializable {

  private Share share;

  public ModelShape(Share share) {
    this.share = share;
  }


  @Override
  public int compareTo(ModelShape modelShape) {
    return 0;
  }

  public Share getShare() {
    /*Share share = new Oval(Color.BLACK,new Point(1,1),new Point(3,3));
    Drawable share1 = figure.getShape();
    return (Share) share1;*/
    return share;
  }
}

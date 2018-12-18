package shapes;

import static org.junit.Assert.assertTrue;

import datos.model.LineBuild;
import datos.model.RectangleBuild;
import datos.model.ShapeBuild;
import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModelShape;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestFiguresGeometrics {

  private ListModelShape listModelShape;
  private Point point1 = new Point(200, 22);
  private Point point2 = new Point(333, 200);

  @Before
  public void setUp() {
    listModelShape = new ListModelShape();
  }

  private void updateList(List<ModelShape> modelShapes) {
    listModelShape.setModelShape(modelShapes);
  }

  private List<ModelShape> listShapesBuilds() {
    ShapeBuild shapeBuild1 = new LineBuild(Color.BLACK, point1, point2);
    ShapeBuild shapeBuild3 = new LineBuild(Color.BLACK, point1, point2);
    ShapeBuild shapeBuild4 = new RectangleBuild(Color.BLACK, point1, point2);
    List<ModelShape> modelShapes = new ArrayList<>();
    modelShapes.add(new ModelShape(shapeBuild1));
    modelShapes.add(new ModelShape(shapeBuild3));
    modelShapes.add(new ModelShape(shapeBuild4));
    return modelShapes;
  }

  private boolean compareShapeBuilds(String[] names) {
    List<ModelShape> modelShapes = listModelShape.getModelShape();
    for (int i = 0; i < names.length; i++) {
      if (!names[i].equals(modelShapes.get(i).getShapeBuild().getName())) {
        return false;
      }
    }
    return true;
  }

  @Test
  public void testCompareOrdenShapes() {
    String arrayNames[] = new String[]{"Line", "Line", "Rectangle"};

    List<ModelShape> modelShapes = listShapesBuilds();
    updateList(modelShapes);
    boolean expected = compareShapeBuilds(arrayNames);
    assertTrue(expected);

  }
}

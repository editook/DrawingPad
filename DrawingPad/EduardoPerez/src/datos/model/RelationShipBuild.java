package datos.model;

import java.awt.Color;
import java.awt.Point;

public class RelationShipBuild extends LineBuild {

  private Color color;
  private ClassBuild classBuild1, classBuild2;
  private int typeRelation;
  private String name;

  public RelationShipBuild(Color color, Point point1, Point point2) {
    super(color, point1, point2);
    this.color = color;
    name = "RelationShip";
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Color getColor() {
    return color;
  }

  public ClassBuild getClassBuild1() {
    return classBuild1;
  }

  public ClassBuild getClassBuild2() {
    return classBuild2;
  }

  public int getTypeRelation() {
    return typeRelation;
  }

  public void setTypeRaltion(int typeRelation) {
    this.typeRelation = typeRelation;
  }

  public void setRelationPrimary(ClassBuild classBuild) {
    classBuild1 = classBuild;
  }

  public void setRelationSecundary(ClassBuild classBuild) {
    classBuild2 = classBuild;
  }

}

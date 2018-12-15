package datos;

import datos.modelserializer.ListModelShape;
import datos.modelserializer.ModeloSerializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Acceso {

  public Acceso() {

  }

  public static ListModelShape getInputStream(String filename) {
    ListModelShape listModelShape = new ListModelShape();
    try {
      ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
      String str = (String) inputStream.readObject();
      listModelShape = (ListModelShape) inputStream.readObject();
      inputStream.close();
    } catch (IOException e) {
      System.err.println("Unable to open file: " + filename);
    } catch (ClassNotFoundException e2) {
      System.err.println(e2);
    }
    return listModelShape;
  }

  public static void setOutputStream(ModeloSerializable listModelShape, String filename) {
    ObjectOutputStream outputStream;
    try {
      outputStream = new ObjectOutputStream(new FileOutputStream(filename));
      outputStream.writeObject("");
      outputStream.writeObject(listModelShape);
      outputStream.close();
      System.out.println("Save drawing to " + filename);
    } catch (IOException e) {
      System.out.println("Unable to write file: " + filename);
    }
  }
}

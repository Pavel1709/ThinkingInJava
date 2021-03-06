//: typeinfo/Shapes.java
import java.util.*;
abstract class Shape {
 void draw() {
  System.out.println(this + ".draw()"); 
 } 
 abstract public String toString();
}
class Circle extends Shape {
  public String toString() { return "Circle"; }
}
class Square extends Shape {
  public String toString() { return "Square"; }
}
class Triangle extends Shape {
 public String toString() { return "Triangle"; }
}
class Rhomboid extends Shape {
 public String toString() { return "Rhomboid"; }
}

public class Shapes {
  public static void main(String[] args) {
   List<Shape> shapeList = Arrays.asList(
    new Circle(), new Square(), new Triangle(), new Rhomboid());
   for(Shape shape : shapeList) {
     shape.draw(); 
   }
   ((Shape)shapeList.get(3)).draw();//Rhomboid.draw()
  
   Rhomboid rmb = new Rhomboid();
   if (rmb instanceof Rhomboid) 
   ((Shape)rmb).draw(); //Rhomboid.draw()
    Shape c = rmb;
    ((Rhomboid)c).draw(); //Rhomboid.draw()
   //error: incompatible types: Rhomboid cannot be converted to Circle

 } 
}/* Output: Circle.draw() Square.draw() Triangle.draw() *///:~
//: typeinfo/Shapes.java
import java.util.*;
abstract class Shape {
 boolean light = false;
 void highlite() {
  light = true;
 }
 void draw() {
  System.out.println(this.getClass().getSimpleName() + ".draw()"); 
 } 
 abstract public String toString();
}
class Circle extends Shape {
  public String toString() { return "Circle light " + light ; }
}
class Square extends Shape {
  public String toString() { return "Square light " + light; }
}
class Triangle extends Shape {
 public String toString() { return "Triangle light " + light; }
}
class Rhomboid extends Shape {
 public String toString() { return "Rhomboid light " + light; }
}

public class Shapes {
  public static void main(String[] args) {
   List<Shape> shapeList = Arrays.asList(
    new Circle(), new Square(), new Triangle(), new Rhomboid());
   for(Shape shape : shapeList) {
     shape.draw(); 
     System.out.println(shape);
   }
   for(Shape shape : shapeList) {
     shape.highlite(); 
     System.out.println(shape);
   }
  } 
}/* Output: Circle.draw() Square.draw() Triangle.draw() *///:~
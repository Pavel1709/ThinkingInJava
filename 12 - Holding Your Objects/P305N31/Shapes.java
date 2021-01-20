//: polymorphism/Shapes.java
// Polymorphism in Java.
import polymorphism.shape.*;
public class Shapes {
  public static void main(String[] args) {
   RandomShapeGenerator r = new RandomShapeGenerator();
   r.addShapes();
    
  for(Shape shp : new RandomShapeGenerator())
   shp.draw(); 
 }
}
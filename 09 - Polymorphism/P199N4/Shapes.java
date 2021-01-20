//: polymorphism/Shapes.java // Polymorphism in Java. 
import polymorphism.shape.*;
public class Shapes {
 static RandomShapeGenerator gen = new RandomShapeGenerator();
  public static void main(String[] args) {
    Shape[] s = new Shape[15];
   //Circle c = new Circle();
    //c.countPerimeter();
   // Fill up the array with shapes: 
   for(int i = 0; i < s.length; i++) {
    s[i] = gen.next();
   }
   // Make polymorphic method calls: 
   for(Shape shp : s) {
      shp.draw();
      shp.erase();
      shp.countPerimeter();
   }
 }
}

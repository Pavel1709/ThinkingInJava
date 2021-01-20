//: polymorphism/shape/RandomShapeGenerator.java 
// A "factory" that randomly creates shapes.
package polymorphism.shape;
import java.util.*;
public class RandomShapeGenerator implements Iterable<Shape>{ 
 private  Random rand = new Random(47);
 static public Shape[] shapes = new Shape[9];
  public void addShapes() {
  for(int j = 0; j < 9; j++) {
  switch(rand.nextInt(3)) { 
   default:
   case 0: shapes[j] = new Circle(); 
   break;
   case 1: shapes[j] = new Square();
   break; 
   case 2: shapes[j] = new Triangle();
   break; 
  } 
 }
}
 public Iterator<Shape> iterator() {
  return new Iterator<Shape>() {
   private int index = 0;
   public boolean hasNext() {
    return index <shapes.length;
   }
   public Shape next() {
    return shapes[index++];
   }
   public void remove() {
    throw new UnsupportedOperationException();
   }
  };
 }
}


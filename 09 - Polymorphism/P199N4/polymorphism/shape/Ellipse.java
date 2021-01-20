//: polymorphism/shape/Ellipse.java 
package polymorphism.shape;
import static net.mindview.util.Print.*;
public class Ellipse extends Shape {
 public void draw() { 
  print("Ellipse.draw()"); 
 } 
 public void erase() { 
  print("Ellipse.erase()"); 
 }
  @Override
 public void countPerimeter() {
  print("Perimeter of Ellipse");
 }
} 
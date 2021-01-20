//: polymorphism/PolyConstructors.java // Constructors and polymorphism
// don’t produce what you might expect. 
import static net.mindview.util.Print.*;
class Glyph {
 void draw() { 
  print("Glyph.draw()");
 } 
 Glyph() {
  print("Glyph() before draw()"); 
  draw();
  print("Glyph() after draw()");
 }
}
class RoundGlyph extends Glyph { 
 private int radius = 1; 
 RoundGlyph(int r) {
  radius = r;
  print("RoundGlyph.RoundGlyph(), radius = " + radius); 
 }
 void draw() {
  print("RoundGlyph.draw(), radius = " + radius); 
 }
}
class RectangularGlyph extends Glyph { 
 private int a = 1; 
 private int b = 2; 
 RectangularGlyph(int a, int b) {
  this.a = a;
  this.b = b;
  print("RectangularGlyph.RectangularGlyph(), a = " + a + " b =" + b); 
 }
 void draw() {
  print("Rectangular.draw(), a = " + a + " b =" + b); 
 }
}
public class PolyConstructors {
  public static void main(String[] args) {
   new RoundGlyph(5);
   new Glyph();
   new RectangularGlyph(5 , 10);
  }
} 
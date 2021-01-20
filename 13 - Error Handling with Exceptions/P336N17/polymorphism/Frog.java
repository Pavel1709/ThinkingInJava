//: polymorphism/Frog.java
// Cleanup and inheritance.
package polymorphism;
import static net.mindview.util.Print.*;
class Characteristic {
  private static  String s;
  Characteristic(String s) {
   this.s = s;
   print("Creating Characteristic " + s); 
  }
  protected static void dispose() {
   print("disposing Characteristic " + s); 
  }
}
class Description {
  static private String s;
  Description(String s) {
   this.s = s;
   print("Creating Description " + s); }
   protected static void dispose() { print("disposing Description " + s);
  } 
}
class LivingCreature { 
 private static Characteristic p =new Characteristic("is alive");
 private static Description t = new Description("Basic Living Creature");
 LivingCreature() {
  print("LivingCreature()"); 
 }
  protected static void dispose() { 
   print("LivingCreature dispose"); 
   t.dispose();
   p.dispose();
  }
}
class Animal extends LivingCreature { 
 private static Characteristic p = new Characteristic("has heart");
 private static Description t = new Description("Animal not Vegetable");
 Animal() { print("Animal()"); }
 protected static void dispose() {
  print("Animal dispose"); 
  t.dispose();
  p.dispose(); 
  LivingCreature.dispose();
 } 
}
class Amphibian extends Animal { 
 private static Characteristic p = new Characteristic("can live in water"); 
 private static Description t = new Description("Both water and land"); 
 Amphibian() {
  print("Amphibian()"); 
 }
 protected static void dispose() { 
  print("Amphibian dispose"); 
  t.dispose();
  p.dispose(); 
  Animal.dispose();
 } 
}
public class Frog extends Amphibian {
 private static Characteristic p = new Characteristic("Croaks"); 
 private static Description t = new Description("Eats Bugs"); 
 public Frog() { 
  print("Frog()"); 
 }
 protected static void dispose() {
  print("Frog dispose"); 
  t.dispose(); 
  p.dispose(); 
  Amphibian.dispose();
 }
  public static void main(String[] args) {
   try {
     Frog frog = new Frog(); 
     print("Bye!"); 
   }
   finally {
    Frog.dispose();
  }
 }
}
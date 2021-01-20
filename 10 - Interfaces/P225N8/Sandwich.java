//: polymorphism/Sandwich.java
// Order of constructor calls.

import static net.mindview.util.Print.*;
class Meal {
 Meal() {
  print("Meal()"); 
 } 
}
class Bread {
 Bread() {
  print("Bread()"); 
 } 
}
class Cheese {
 Cheese() { 
  print("Cheese()"); 
 } 
}
class Lettuce {
 Lettuce() {
  print("Lettuce()"); 
 } 
}
class Lunch extends Meal {
 Lunch() { 
  print("Lunch()"); 
 } 
}
class PortableLunch extends Lunch {
 PortableLunch() {
  print("PortableLunch()");
 } 
}
interface Fastood {
 void beTasty();
 void beUnhealthy();
}
public class Sandwich implements Fastood{
 public void beTasty() {
  System.out.print("it is tasty ");
 }
 public void beUnhealthy() {
  System.out.println("it is unhealthy");
 }
 private Bread b = new Bread();
 private Cheese c = new Cheese();
 private Lettuce l = new Lettuce();
 public Sandwich() {
  print("Sandwich()"); 
 } 
 public static void main(String[] args) {
  new Sandwich();
  Sandwich ff = new Sandwich();
  ff.beTasty();
  System.out.print ("but ");
  ff.beUnhealthy();
 }
} 
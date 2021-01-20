//: generics/Holder3.java
import typeinfo.pets.*;
public class Holder3<T> {
 private T a;
 public Holder3(T a) { 
  this.a = a; 
 }
 public void set(T a) { 
  this.a = a; 
 } 
 public T get() {
  return a; 
 }
 public static void main(String[] args) {
  Holder3<Pet> h3 = new Holder3<Pet>(new Hamster());
  Hamster a =(Hamster) h3.get(); 
  h3.set(new Cat()); 
  h3.set(new Dog()); 
  Pet b = h3.get(); // No cast needed
 }
} ///:~
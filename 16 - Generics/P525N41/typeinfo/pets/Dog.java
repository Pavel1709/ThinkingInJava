//: typeinfo/pets/Dog.java 
package typeinfo.pets;
public class Dog extends Pet {
  public Dog(String name) { super(name); }
  public Dog() { super(); }
  public static class Factory implements inter.Factory<Dog> {
    public Dog create() { return new Dog(); }
  }
  public void speak() {
   System.out.println(this + " speaks");
  }
} ///:~
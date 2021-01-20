//: typeinfo/pets/Cat.java 
package typeinfo.pets;
public class Cat extends Pet {
  public Cat(String name) { super(name); }
  public Cat() { super(); }
  public static class Factory implements inter.Factory<Cat> {
    public Cat create() { return new Cat(); }
  }
} ///:~
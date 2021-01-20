//: typeinfo/pets/Hamster.java 
package typeinfo.pets;
public class Hamster extends Rodent {
  public Hamster(String name) { super(name); }
  public Hamster() { super(); }
  public static class Factory implements inter.Factory<Hamster> {
    public Hamster create() { return new Hamster(); }
  }
} ///:~
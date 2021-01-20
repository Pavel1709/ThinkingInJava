//: typeinfo/pets/Gerbil.java 
package typeinfo.pets;
public class Gerbil extends Rodent {
  public Gerbil(String name) { super(name); }
  public Gerbil() { super(); }
  public static class Factory implements inter.Factory<Gerbil> {
    public Gerbil create() { return new Gerbil(); }
  }
  public void speak() {
   System.out.println(this + " speaks");
  }
} ///:~

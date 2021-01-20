//: typeinfo/pets/Manx.java 
package typeinfo.pets;
public class Manx extends Cat {
  public Manx(String name) { super(name); }
  public Manx() { super(); }
  public static class Factory implements inter.Factory<Manx> {
    public Manx create() { return new Manx(); }
  }
  public void speak() {
   System.out.println(this + " speaks");
  }
} ///:~
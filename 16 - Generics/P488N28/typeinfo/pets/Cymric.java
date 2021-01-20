//: typeinfo/pets/Cymric.java 
package typeinfo.pets;
public class Cymric extends Manx {
  public Cymric(String name) { super(name); }
  public Cymric() { super(); }
  public static class Factory implements inter.Factory<Cymric> {
    public Cymric create() { return new Cymric(); }
  }
} ///:~
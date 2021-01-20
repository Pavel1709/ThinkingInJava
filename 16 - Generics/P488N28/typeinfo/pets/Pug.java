//: typeinfo/pets/Pug.java 
package typeinfo.pets;
public class Pug extends Dog {
  public Pug(String name) { super(name); }
  public Pug() { super(); }
  public static class Factory implements inter.Factory<Pug> {
    public Pug create() { return new Pug(); }
  }
} ///:~
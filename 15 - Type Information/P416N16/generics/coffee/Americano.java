
//: generics/coffee/Americano.java
package generics.coffee;
import generics.coffee.factory.*;
public class Americano extends Coffee {
 public static class Factory implements generics.coffee.factory.Factory<Americano> {
    public Americano create() {
      return new Americano();
    }
 }
} ///:~
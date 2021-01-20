//: generics/coffee/Cappuccino.java
package generics.coffee;
import generics.coffee.factory.*;
public class Cappuccino extends Coffee {
 public static class Factory implements generics.coffee.factory.Factory<Cappuccino> {
    public Cappuccino create() {
      return new Cappuccino();
    }
 }
} ///:~
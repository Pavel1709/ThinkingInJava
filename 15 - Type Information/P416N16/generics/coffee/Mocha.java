//: generics/coffee/Mocha.java
package generics.coffee;
import generics.coffee.factory.*;
public class Mocha extends Coffee {
 public static class Factory implements generics.coffee.factory.Factory<Mocha> {
    public Mocha create() {
      return new Mocha();
    }
 }
} ///:~
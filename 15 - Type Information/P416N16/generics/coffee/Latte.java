//: generics/coffee/Latte.java
package generics.coffee;
import generics.coffee.factory.*;
public class Latte extends Coffee {
 public static class Factory implements generics.coffee.factory.Factory<Latte> {
    public Latte create() {
      return new Latte();
    }
 }
} ///:~
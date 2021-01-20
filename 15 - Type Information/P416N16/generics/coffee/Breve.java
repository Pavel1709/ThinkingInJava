
//: generics/coffee/Breve.java
package generics.coffee;
import generics.coffee.factory.*;
public class Breve extends Coffee { 
 public static class Factory implements generics.coffee.factory.Factory<Breve> {
    public Breve create() {
      return new Breve();
    }
 }
} ///:~
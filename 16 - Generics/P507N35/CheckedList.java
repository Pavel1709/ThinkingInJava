//: generics/CheckedList.java
// Using Collection.checkedList(). 
import generics.coffee.*;
import java.util.*;
 public class CheckedList { 
  @SuppressWarnings("unchecked")
  static void oldStyleMethod(List probablyAmericano) {
   probablyAmericano.add(new Latte()); 
  }
  public static void main(String[] args) {
   List<Americano> americano1 = new ArrayList<Americano>(); 
   oldStyleMethod(americano1); 
   // Quietly accepts a Cat
   List<Americano> americano2 = Collections.checkedList( new ArrayList<Americano>(), Americano.class); 
   try {
     oldStyleMethod(americano2); // Throws an exception
   } 
   catch(Exception e) {
    System.out.println(e); 
   }
   // Derived types work fine:
   List<Coffee> coffee = Collections.checkedList( new ArrayList<Coffee>(), Coffee.class);     
   coffee.add(new Americano());
   coffee.add(new Latte());
  }
}
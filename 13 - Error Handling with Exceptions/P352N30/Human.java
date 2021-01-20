//: exceptions/Human.java
// Catching exception hierarchies.
class Annoyance extends RuntimeException {}
class Sneeze extends RuntimeException {}
public class Human {
 public static void main(String[] args) {
  // Catch the exact type:
  try {
   throw new Sneeze();
  } 
  catch(Sneeze s) {
   throw(new RuntimeException(s));
  } 
  catch(Annoyance a) {
   throw(new RuntimeException(a));
  }
  catch(RuntimeException rt) {} 
  try {
   throw new Sneeze();
  } 
  catch(Annoyance a) {
   throw(new RuntimeException(a));
  }
  catch(RuntimeException rt) {} 
 }
} /* Output: Caught Sneeze Caught Annoyance *///:~
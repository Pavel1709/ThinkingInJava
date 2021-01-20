import java.util.*;
class Banana{}
class Peel<T> extends ArrayList<T>{}
public class SomePeel {  
 @SuppressWarnings("unchecked")
 public static void main(String[] args) {
  // Peel<Banana>[] peels = new Peel<Banana> [10]; // Illegal
  /*
  error: generic array creation
  Peel<Banana>[] peels = new Peel<Banana> [10]; // Illegal
  */
  Peel<Banana> peels = new Peel<Banana>(); // legal
  List[] la = new Peel[10];
  Peel<Banana>[] peels2 = (Peel<Banana>[])new Peel[10]; // Illegal
 }
}
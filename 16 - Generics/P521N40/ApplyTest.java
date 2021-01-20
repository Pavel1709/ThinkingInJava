//: generics/Apply.java
// {main: ApplyTest} 
import java.lang.reflect.*; 
import typeinfo.pets.*;
import java.util.*;
import static net.mindview.util.Print.*;
class Apply {
 public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
  try {
    for(T t: seq)
     f.invoke(t, args); 
    } catch(Exception e) {
     // Failures are programmer errors
     throw new RuntimeException(e);
    }
 } 
}
class SimpleQueue<T> implements Iterable<T> {
 private LinkedList<T> storage = new LinkedList<T>();
 public void add(T t) { storage.offer(t); }
 public T get() { return storage.poll(); }
 public Iterator<T> iterator() {
  return storage.iterator(); 
 }
}
class Shape {
 public void rotate() {
  print(this + " rotate"); 
 } 
 public void resize(int newSize) {
  print(this + " resize " + newSize); 
 }
}
class Square extends Shape {}
class FilledList<T> extends ArrayList<T> {
 public FilledList(Class<? extends T> type, int size) {
  try {
   for(int i = 0; i < size; i++)
    // Assumes default constructor: 
    add(type.newInstance());
   }
   catch(Exception e) {
      throw new RuntimeException(e);
   }
 } 
}
public class ApplyTest {
  public static void main(String[] args) throws Exception {
   List<Pet> pets = new ArrayList<Pet>(); 
   for(int i = 0; i < 10; i++)
    pets.add(new Pet());
    Apply.apply(pets, Pet.class.getMethod("speak"));
    pets.add(new Gerbil());
    pets.add(new Cat());
    pets.add(new Dog());
    pets.add(new Mouse());
    Apply.apply(pets, Pet.class.getMethod("speak")); 
    Apply.apply(new FilledList<Pet>(Manx.class, 10), Pet.class.getMethod("speak"));
    Apply.apply(new FilledList<Pet>(Hamster.class, 10), Pet.class.getMethod("speak"));
    SimpleQueue<Pet> shapeQ = new SimpleQueue<Pet>();
    for(int i = 0; i < 5; i++) {
     shapeQ.add(new Mutt());
     shapeQ.add(new Rat()); 
    }
    Apply.apply(shapeQ, Pet.class.getMethod("speak")); 
 }
} /* (Execute to see output) *///:~
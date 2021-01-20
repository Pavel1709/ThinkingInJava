//: generics/Fill2.java
// Using adapters to simulate latent typing. // {main: Fill2Test}
import typeinfo.pets.*;;
import java.util.*;
import generics.coffee.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
interface Addable<T> { void add(T t); }
class SimpleQueue<T> implements Iterable<T> { 
 private LinkedList<T> storage = new LinkedList<T>(); 
 public void add(T t) { storage.offer(t); }
 public T get() { return storage.poll(); }
 public Iterator<T> iterator() {
  return storage.iterator(); 
 }
}
class Fill2 {
 // Classtoken version:
 public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
  for(int i = 0; i < size; i++) 
  try {
   addable.add(classToken.newInstance()); 
  } 
  catch(Exception e) {
   throw new RuntimeException(e);
  }
 }
 // Generator version:
 public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
  for(int i = 0; i < size; i++) 
   addable.add(generator.next());
 } 
}
// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
  private Collection<T> c;
  public AddableCollectionAdapter(Collection<T> c) {
   this.c = c; 
  }
  public void add(T item) {
   c.add(item); 
  }
}
// A Helper to capture the type automatically:
class Adapter {
  public static <T>
  Addable<T> collectionAdapter(Collection<T> c) {
    return new AddableCollectionAdapter<T>(c);
  }
}
// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance: 
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
 public void add(T item) { 
  super.add(item); 
 } 
}
public class Fill2Test {
  public static void main(String[] args) {
   // Adapt a Collection:
   List<Pet> carrier = new ArrayList<Pet>();
   Fill2.fill( new AddableCollectionAdapter<Pet>(carrier), Pet.class, 3);
   // Helper method captures the type: 
   Fill2.fill(Adapter.collectionAdapter(carrier), Gerbil.class, 2); 
   for(Pet c: carrier)
    print(c); 
    print("----------------------");
   // Use an adapted class: 
   AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<Pet>(); 
   Fill2.fill(petQueue, Hamster.class, 4); 
   Fill2.fill(petQueue, Gerbil.class, 1);
   for(Pet c: petQueue)
    print(c); 
  }
}
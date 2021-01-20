//: innerclasses/Sequence.java 
// Holds a sequence of Objects.
import java.util.*;
interface Selector {
  boolean end();
  Object current();
  void next();
}
public class Sequence<T> { 
 private ArrayList<T> items;
 private int next = 0; 
 int size;
 public Sequence(int size) {  
  items = new ArrayList<T>(); 
  this.size = size;
 }
 public void add(T x) {
  if(next < size) 
   items.add(x);
 }
private class SequenceSelector implements Selector {
  private int i = 0;
  public boolean end() { 
   return i == size; 
  } 
  public T current() { 
   return items.get(i); 
  } 
  public void next() { 
  if(i < size) 
   i++; 
  }
 }
 public Selector selector() {
    return new SequenceSelector();
  }
 public static void main(String[] args) { 
  Sequence<Integer> sequence = new Sequence<Integer>(10); 
  for(int i = 0; i < 10; i++)
   sequence.add(i); 
  Selector selector = sequence.selector(); 
  while(!selector.end()) {
   System.out.print(selector.current() + " ");
   selector.next(); 
  }
 }
} /* Output: 0123456789 *///:~
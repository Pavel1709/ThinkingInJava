//: generics/GenericCast.java
import java.util.*;
class FixedSizeStack<T> {
 private int index = 0;
 private int maxSize = 0;
 private ArrayList<T> storage;
 public FixedSizeStack(int size) {
  storage = new ArrayList<T>();
  this.maxSize = size;
 }
 public void push(T item) { 
  if (storage.size() <= maxSize) {
   storage.add(item); 
   index++;
  }
 } 
 @SuppressWarnings("unchecked")
 public T pop() {
  return  storage.get(--index ); 
 
 }
}
public class GenericCast {
 public static final int SIZE = 10; 
 public static void main(String[] args) {
  FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
  for(String s : "A B C D E F G H I J".split(" ")) 
   strings.push(s);
   for(int i = 0; i <  SIZE; i++) { 
   String s = strings.pop();
   System.out.print(s + " "); 
  }
 }
} /* Output: JIHGFEDCBA *///:~

//: generics/IterableFibonacci.java
// Adapt the Fibonacci class to make it Iterable.
import java.util.*;
public class IterableFibonacci extends Fibonacci { 
 private int n;
 public IterableFibonacci(int count) { 
  n = count; 
 }
 Fibonacci f = new Fibonacci();
 public boolean hasNext() { return n > 0; }
 public Integer next() {
       n--;
       return f.next(); 
 }
 public static void main(String[] args) {
  IterableFibonacci i = new IterableFibonacci(18);
   while (i.hasNext()) 
  System.out.print(i.next() + " ");
 }
}
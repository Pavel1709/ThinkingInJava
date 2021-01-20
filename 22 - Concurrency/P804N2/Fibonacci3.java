//: generics/Fibonacci3.java
// Generate a Fibonacci sequence.
import net.mindview.util.*;

public class Fibonacci3 implements Generator<Integer>, Runnable {
  private int count = 0;
  int m;
  Fibonacci3() {}
  Fibonacci3(int m) {
   this.m = m;
  }
  public Integer next() { return fib(count++); }
  private int fib(int n) {
    if(n < 2) return 1;
    return fib(n-2) + fib(n-1);
  }
  public  void run() {
    Fibonacci3 gen = new Fibonacci3();
    for(int i = 0; i < m; i++)
      System.out.print(gen.next() + " "); 
      Thread.yield();
      System.out.println();
  }
}  
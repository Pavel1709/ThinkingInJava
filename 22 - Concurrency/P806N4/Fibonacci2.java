//: generics/Fibonacci2.java
// Generate a Fibonacci sequence.
import net.mindview.util.*;

public class Fibonacci2 implements Generator<Integer>, Runnable {
  private int count = 0;
  int m;
  Fibonacci2() {}
  Fibonacci2(int m) {
   this.m = m;
  }
  public Integer next() { return fib(count++); }
  private int fib(int n) {
    if(n < 2) return 1;
    return fib(n-2) + fib(n-1);
  }
  public  void run() {
    Fibonacci2 gen = new Fibonacci2();
    for(int i = 0; i < m; i++)
      System.out.print(gen.next() + " ");
      Thread.yield();      
      System.out.println();
  }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~

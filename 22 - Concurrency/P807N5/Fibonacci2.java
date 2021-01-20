//: generics/Fibonacci2.java
// Generate a Fibonacci sequence.
import net.mindview.util.*;
import java.util.concurrent.*;
import java.util.*;
public class Fibonacci2 implements Generator<Integer>, Callable<ArrayList<Integer>> {
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
  public ArrayList<Integer> call() {
    Fibonacci2 gen = new Fibonacci2();
    ArrayList<Integer> is = new  ArrayList<Integer>();
    for(int i = 0; i < m; i++)
      is.add(gen.next()) ;
     return is;
  }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~

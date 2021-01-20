//: generics/Fibonacci3.java
// Generate a Fibonacci sequence.
import net.mindview.util.*;
import java.util.concurrent.*;
import java.util.*;
public class Fibonacci3 implements Generator<Integer>, Callable<ArrayList<Integer>>  {
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
  public ArrayList<Integer> call() {
    Fibonacci3 gen = new Fibonacci3();
    ArrayList<Integer> is = new  ArrayList<Integer>();
    for(int i = 0; i < m; i++)
      is.add(gen.next()) ;
     return is;
  }
}  
//: generics/Fibonacci1.java
// Generate a Fibonacci sequence.
import net.mindview.util.*;
import java.util.concurrent.*;
import java.util.*;
public class Fibonacci1 implements Generator<Integer>, Callable<ArrayList<Integer>> {
  private int count = 0;
  int m;
  ExecutorService exec = Executors.newSingleThreadExecutor();
  Fibonacci1() {}
  public Integer next() { return fib(count++); }
  private int fib(int n) {
    if(n < 2) return 1;
    return fib(n-2) + fib(n-1);
  }
  public ArrayList<Integer> call() {
    Fibonacci1 gen = new Fibonacci1();
    ArrayList<Integer> is = new  ArrayList<Integer>();
    for(int i = 0; i < m; i++)
      is.add(gen.next()) ;
     return is;
  }
  public Future<ArrayList<Integer>> runTask(Integer m) {
   this.m = m;	
   return exec.submit(this);		
  }
} 

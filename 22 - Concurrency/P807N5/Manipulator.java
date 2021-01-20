import java.util.concurrent.*;
import java.util.*;
public class Manipulator{
 public static void main(String[] args) {
  ExecutorService exec = Executors.newCachedThreadPool();
  ArrayList<Future<ArrayList<Integer>>> res = new ArrayList<Future<ArrayList<Integer>>>();
  res.add(exec.submit(new Fibonacci1(6)));
  res.add(exec.submit(new Fibonacci2(7)));
  res.add(exec.submit(new Fibonacci3(8)));
  for(Future<ArrayList<Integer>> fs: res) {
   try{
    System.out.println(fs.get());
   }
   catch(InterruptedException e) {
    System.out.println(e);
    return;
   }
   catch(ExecutionException e) {
    System.out.println(e);
   }
   finally {
    exec.shutdown();
   }
  }
 }
}
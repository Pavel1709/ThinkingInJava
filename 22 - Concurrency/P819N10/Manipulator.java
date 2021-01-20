import java.util.concurrent.*;
import java.util.*;
public class Manipulator{
 public static void main(String[] args) {
  ArrayList<Future<ArrayList<Integer>>> res = new ArrayList<Future<ArrayList<Integer>>>();
  Fibonacci1 f1 = new Fibonacci1();
  Fibonacci2 f2 = new Fibonacci2();
  Fibonacci3 f3 = new Fibonacci3();
  res.add(f1.runTask(6));
  res.add(f2.runTask(7));
  res.add(f3.runTask(8));
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
    f1.exec.shutdown();
    f2.exec.shutdown();
    f3.exec.shutdown();
   }
  }
 }
}
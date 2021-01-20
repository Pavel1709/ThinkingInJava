import java.util.concurrent.*;
public class Manipulator3{
 public static void main(String[] args) {
  ExecutorService exec = Executors.newSingleThreadExecutor();
  exec.execute(new Fibonacci1(6));
  exec.execute(new Fibonacci2(7));
  exec.execute(new Fibonacci3(8));
  exec.shutdown();
 }
}
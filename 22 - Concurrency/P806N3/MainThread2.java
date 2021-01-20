import java.util.concurrent.*;
public class MainThread2 {
 public static void main(String[] args) {
  ExecutorService exec = Executors.newFixedThreadPool(3);
  exec.execute(new One());
  exec.execute(new Two());
  exec.execute(new Three());
  exec.shutdown();
 }
}
 


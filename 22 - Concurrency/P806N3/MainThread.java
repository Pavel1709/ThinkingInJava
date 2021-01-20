import java.util.concurrent.*;
public class MainThread {
 public static void main(String[] args) {
  ExecutorService exec = Executors.newCachedThreadPool();
  exec.execute(new One());
  exec.execute(new Two());
  exec.execute(new Three());
  exec.shutdown();
 }
}
 


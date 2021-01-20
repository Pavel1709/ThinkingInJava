import java.util.concurrent.*;
public class MainThread3 {
 public static void main(String[] args) {
  ExecutorService exec = Executors.newSingleThreadExecutor();
  exec.execute(new One());
  exec.execute(new Two());
  exec.execute(new Three());
  exec.shutdown();
 }
}
 


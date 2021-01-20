import java.util.concurrent.*;
public class Runner {
 
 public static void main(String[] args) {
  ExecutorService exe = Executors.newCachedThreadPool();
  exe.execute(new Tasker());
  exe.shutdownNow();
 }
}
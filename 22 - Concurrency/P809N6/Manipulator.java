import java.util.concurrent.*;

public class Manipulator{
 public static void main(String[] args) {
  ExecutorService exc = Executors.newCachedThreadPool();
  exc.execute(new Timer());
  exc.execute(new Timer2());
  exc.execute(new Timer3());
  exc.shutdown();
 }
}
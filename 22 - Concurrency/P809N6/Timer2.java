import java.util.*;
import java.util.concurrent.*;
public class Timer2 implements Runnable{
 public void run() {
  try{
   Random rand = new Random();
   int time = rand.nextInt(10);
   TimeUnit.MILLISECONDS.sleep(time);
   System.out.println(time);
  }
  catch(InterruptedException e) {
   System.err.println("Interrupted");
  }
 }
}
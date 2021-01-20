
import java.util.concurrent.*;
class ClassWithThreeMethods {
 Object i = new Object();
 public void one() throws InterruptedException{
  synchronized(i) {
   System.out.println("One");
   TimeUnit.SECONDS.sleep(1);
   Thread.yield();

  }
 }
 public void two() throws InterruptedException{
  synchronized(i) {
   System.out.println("Two");
   TimeUnit.SECONDS.sleep(1);
   Thread.yield();
 
  }
 }
 public void three() throws InterruptedException{
  synchronized(i) {
   System.out.println("Three");
   TimeUnit.SECONDS.sleep(1);
   Thread.yield();
 
  }
 }
}

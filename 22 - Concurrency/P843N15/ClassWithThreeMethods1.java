
import java.util.concurrent.*;
class ClassWithThreeMethods1 {
 public void one() throws InterruptedException{
 ClassWithThreeMethods1 c2 = new ClassWithThreeMethods1();

  synchronized(c2) {
   System.out.println("One");
   Thread.yield();
   TimeUnit.SECONDS.sleep(1);
  }
 }
 public void two() throws InterruptedException{
  ClassWithThreeMethods1 c3 = new ClassWithThreeMethods1();
  synchronized(c3)  {
   System.out.println("Two");
   Thread.yield(); 
   TimeUnit.SECONDS.sleep(1);
  }
 }
 public void three() throws InterruptedException{
   ClassWithThreeMethods1 c1 = new ClassWithThreeMethods1();
   synchronized(c1) {
   System.out.println("Three");
   Thread.yield();
   TimeUnit.SECONDS.sleep(1);
  }
 }
}
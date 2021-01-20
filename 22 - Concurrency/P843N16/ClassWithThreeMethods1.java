import java.util.concurrent.locks.*;
import java.util.concurrent.*;
class ClassWithThreeMethods1 {
 private Lock lock = new ReentrantLock();
 public void one() throws InterruptedException{
 ClassWithThreeMethods1 c2 = new ClassWithThreeMethods1();
  synchronized(c2) {
   lock.lock();
   try{
    System.out.println("One");
    Thread.yield();
    TimeUnit.SECONDS.sleep(1);
   }
   finally {
    lock.unlock();
   }
  }
 }
 public void two() throws InterruptedException{
  ClassWithThreeMethods1 c3 = new ClassWithThreeMethods1();
  synchronized(c3)  {
   lock.lock();
   try{
    System.out.println("Two");
    Thread.yield(); 
    TimeUnit.SECONDS.sleep(1);
   }
   finally {
    lock.unlock();
   }
  }
 }
 public void three() throws InterruptedException{
   ClassWithThreeMethods1 c1 = new ClassWithThreeMethods1();
   synchronized(c1) {
    lock.lock();
    try{
     System.out.println("Three");
     Thread.yield();
     TimeUnit.SECONDS.sleep(1);
    }
    finally {
     lock.unlock();
    }
   }
 }
}
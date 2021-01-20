import java.util.concurrent.locks.*;
import java.util.concurrent.*;
class ClassWithThreeMethods {
 private Object i = new Object();
 private Lock lock = new ReentrantLock();
 public void one() throws InterruptedException{
  synchronized(i) {
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
  synchronized(i) {
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
  synchronized(i) {
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

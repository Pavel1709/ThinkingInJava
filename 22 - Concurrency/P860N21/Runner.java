import java.util.concurrent.*;
class FirstClass implements Runnable {
  static boolean b = false;
  public synchronized void waiter() throws InterruptedException {
   while (!b)
   wait();
   System.out.println("Message");
  }
 public void run() {
  try{
  while(!Thread.interrupted()) 
   waiter();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  } 
 }
}
class SecondClass implements Runnable {
  public synchronized void notifier() throws InterruptedException {
   
   TimeUnit.SECONDS.sleep(1);
    FirstClass.b = true;
    notifyAll();
  }
 FirstClass f = new FirstClass();
 public void run() {
  try{
   while(!Thread.interrupted()) 
    notifier();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  } 
 }
}
public class Runner {
 public static void main(String[] args) throws Exception {
  ExecutorService exe = Executors.newCachedThreadPool();
  exe.execute(new FirstClass());
  exe.execute(new SecondClass());
 
 }
}
//не понимаю, почему не работает

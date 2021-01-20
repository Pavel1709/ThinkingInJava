public class Tasker implements Runnable {
 Slepper slp = new Slepper();
 public void run() {
  try{ 
   slp.toSleep();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }
 }
}
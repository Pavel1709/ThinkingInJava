import java.util.concurrent.*;
//: concurrency/LiftOff.java
// Demonstration of the Runnable interface.

public class LiftOff implements Runnable {
  protected int countDown = 10; // Default
  private static int taskCount = 0;
  private final int id = taskCount++;
  public LiftOff() {}
  public LiftOff(int countDown) {
    this.countDown = countDown;
  }
  public String status() throws InterruptedException{
    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }
  public void run() {
   try{
    while(true ) {
      System.out.print(status());
      countDown-- ;
      TimeUnit.MILLISECONDS.sleep(3);
      Thread.yield();
     
    }
   }
   catch(InterruptedException e) {
    System.out.println(e);
   }
  }
} ///:~

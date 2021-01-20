
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
  public String status() {
    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }
  public void run() {
   try{ 
    while(countDown-- > 0) {
      System.out.print(status());
      Thread.yield();
    }
   }
   catch(Exception e) {
    System.out.println(e);
   }
   finally {
    System.out.println("end");
   }
  }
} ///:~

//: concurrency/TestBlockingQueues.java
// {RunByHand}
import java.util.concurrent.*;
import java.io.*;
import static net.mindview.util.Print.*;

class LiftOffRunner implements Runnable {
  private BlockingQueue<LiftOff> rockets;
  public LiftOffRunner(BlockingQueue<LiftOff> queue) {
    rockets = queue;
  }
  public void add(LiftOff lo) {
    try {
      rockets.put(lo);
    } catch(InterruptedException e) {
      print("Interrupted during put()");
    }
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        LiftOff rocket = rockets.take();
        rocket.run(); // Use this thread
      }
    } catch(InterruptedException e) {
      print("Waking from take()");
    }
    print("Exiting LiftOffRunner");
  }
}
class LiftOffAdder implements Runnable {
  private LiftOffRunner runner;
  public LiftOffAdder(LiftOffRunner runner) {
    this.runner = runner;
  }
  public void run() {
   for(int i = 0; i < 5; i++)
   runner.add(new LiftOff(5));	
  }
}
public class TestBlockingQueues {
  static void getkey() {
    try {
      // Compensate for Windows/Linux difference in the
      // length of the result produced by the Enter key:
      new BufferedReader(
        new InputStreamReader(System.in)).readLine();
    } catch(java.io.IOException e) {
      throw new RuntimeException(e);
    }
  }
  static void getkey(String message) {
    print(message);
    getkey();
  }
  static void
  test(String msg, BlockingQueue<LiftOff> queue) {
    print(msg);
    LiftOffRunner runner = new LiftOffRunner(queue);
    LiftOffAdder adder = new LiftOffAdder(runner);
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(runner);
    exec.execute(adder);
    for(int i = 0; i < 5; i++)
      runner.add(new LiftOff(5));
    getkey("Press 'Enter' (" + msg + ")");
    print("Finished " + msg + " test");
    exec.shutdownNow();
  }
  public static void main(String[] args) {
    test("LinkedBlockingQueue", // Unlimited size
      new LinkedBlockingQueue<LiftOff>());
    test("ArrayBlockingQueue", // Fixed size
      new ArrayBlockingQueue<LiftOff>(3));
    test("SynchronousQueue", // Size of 1
      new SynchronousQueue<LiftOff>());
  }
} ///:~

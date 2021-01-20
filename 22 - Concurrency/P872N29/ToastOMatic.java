//: concurrency/ToastOMatic.java
// A toaster that uses queues.
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Toast {
  public enum Status { DRY, BUTTERED, JAMMED, PEANUTED, JELLIED, MERGED }
  private Status status = Status.DRY;
  private final int id;
  public Toast(int idn) { id = idn; }
  public void butter() { status = Status.BUTTERED; }
  public void jam() { status = Status.JAMMED; }
  public void merge(Toast t1, Toast t2) { 
   if ((t1.status == Status.PEANUTED && t2.status == Status.JELLIED) || (t2.status == Status.PEANUTED && t1.status == Status.JELLIED)) {
    status = Status.MERGED;
   } 
  }
  public void peanut() { status = Status.PEANUTED; }
  public void jelly() { status = Status.JELLIED; }
  public Status getStatus() { return status; }
  public int getId() { return id; }
  public String toString() {
    return "Toast " + id + ": " + status;
  }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}

class Toaster implements Runnable {
  private ToastQueue toastQueue;
  private int count = 0;
  private Random rand = new Random(47);
  public Toaster(ToastQueue tq) { toastQueue = tq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep(
          100 + rand.nextInt(500));
        // Make toast
        Toast t = new Toast(count++);
        print(t);
        // Insert into queue
        toastQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Toaster interrupted");
    }
    print("Toaster off");
  }
}

// Apply butter to toast:
class Butterer implements Runnable {
  private ToastQueue dryQueue, butteredQueue;
  public Butterer(ToastQueue dry, ToastQueue buttered) {
    dryQueue = dry;
    butteredQueue = buttered;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = dryQueue.take();
        t.butter();
        print(t);
        butteredQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Butterer interrupted");
    }
    print("Butterer off");
  }
}

// Apply jam to buttered toast:
class Jammer implements Runnable {
  private ToastQueue butteredQueue, finishedQueue;
  public Jammer(ToastQueue buttered, ToastQueue finished) {
    butteredQueue = buttered;
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = butteredQueue.take();
        t.jam();
        print(t);
        finishedQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Jammer interrupted");
    }
    print("Jammer off");
  }
}
class Peanutter implements Runnable {
  private ToastQueue butteredQueue, peanuttedQueue;
  public Peanutter(ToastQueue buttered, ToastQueue peanutted) {
    butteredQueue = buttered;
    peanuttedQueue = peanutted;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = butteredQueue.take();
        t.peanut();
        print(t);
        peanuttedQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Peanutter interrupted");
    }
    print("Peanutter off");
  }
}
class Jellier implements Runnable {
  private ToastQueue butteredQueue, jelliedQueue;
  public Jellier(ToastQueue buttered, ToastQueue jellied) {
    butteredQueue = buttered;
    jelliedQueue = jellied;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = butteredQueue.take();
        t.jelly();
        print(t);
        jelliedQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Jellier interrupted");
    }
    print("Jellier off");
  }
}
class Merger implements Runnable {
  private ToastQueue peanuttedQueue, jelliedQueue, finishedQueue;
  public Merger(ToastQueue peanutted, ToastQueue jellied,ToastQueue finished) {
    peanuttedQueue = peanutted;
    jelliedQueue = jellied;
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t1 = peanuttedQueue.take();
        Toast t2 = jelliedQueue.take();
        t1.merge(t1, t2);
        print(t1);
        finishedQueue.put(t1);
      }
    } catch(InterruptedException e) {
      print("Merger interrupted");
    }
    print("Merger off");
  }
}
// Consume the toast:
class Eater implements Runnable {
  private ToastQueue finishedQueue;
  private int counter = 0;
  public Eater(ToastQueue finished) {
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = finishedQueue.take();
        // Verify that the toast is coming in order,
        // and that all pieces are getting jammed:
        if(t.getId() != counter++  ) {
          print(">>>> Error: " + t);
          System.exit(1);
        } else
          print("Chomp! " + t);
      }
    } catch(InterruptedException e) {
      print("Eater interrupted");
    }
    print("Eater off");
  }
}

public class ToastOMatic {
  public static void main(String[] args) throws Exception {
    ToastQueue dryQueue = new ToastQueue(),
               butteredQueue = new ToastQueue(),
               peanuttedQueue = new ToastQueue(),
               jelliedQueue = new ToastQueue(),
               finishedQueue = new ToastQueue();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new Toaster(dryQueue));
    exec.execute(new Butterer(dryQueue, butteredQueue));
    exec.execute(new Jammer(butteredQueue, finishedQueue));
    exec.execute(new Peanutter(butteredQueue, peanuttedQueue));
    exec.execute(new Jellier(butteredQueue, jelliedQueue));
    exec.execute(new Merger(peanuttedQueue,jelliedQueue, finishedQueue));
    exec.execute(new Eater(finishedQueue));
    TimeUnit.SECONDS.sleep(5);
    exec.shutdownNow();
  }
} /* (Execute to see output) *///:~

//: concurrency/CarBuilder.java
// A complex example of tasks working together.
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class House {
  private final int id;
  private boolean
    pol = false, steni = false, krisha = false;
  public House(int idn)  { id = idn; }
  // Empty House object:
  public House()  { id = -1; }
  public synchronized int getId() { return id; }
  public synchronized void addPol() { pol = true; }
  public synchronized void addSteni() {
    steni = true;
    
  }
  public synchronized void addKrisha() { krisha = true; }
  public synchronized String toString() {
    return "House " + id + " [" + " pol: " + pol
      + " steni: " + steni
      + " krisha: " + krisha + " ]";
  }
}

class HouseQueue extends LinkedBlockingQueue<House> {}

class FundamentBuilder implements Runnable {
  private HouseQueue houseQueue;
  private int counter = 0;
  public FundamentBuilder(HouseQueue cq) { houseQueue = cq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep(500);
        // Make chassis:
        House  c = new House(counter++);
        print("FundamentBuilder created " + c);
        // Insert into queue
        houseQueue.put(c);
      }
    } catch(InterruptedException e) {
      print("Interrupted: ChassisBuilder");
    }
    print("FundamentBuilder off");
  }
}

class Assembler implements Runnable {
  private HouseQueue fundamentQueue, finishingQueue;
  private House house;
  private CyclicBarrier barrier = new CyclicBarrier(4);
  private BuilderPool builderPool;
  public Assembler(HouseQueue cq, HouseQueue fq, BuilderPool rp){
    fundamentQueue = cq;
    finishingQueue = fq;
    builderPool = rp;
  }
  public House house() { return house; }
  public CyclicBarrier barrier() { return barrier; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until chassis is available:
        house = fundamentQueue.take();
        // Hire robots to perform work:
        builderPool.hire(PolBuilder.class, this);
        builderPool.hire(SteniBuilder.class, this);
        builderPool.hire(KrishaBuilder.class, this);
        barrier.await(); // Until the robots finish
        // Put car into finishingQueue for further work
        finishingQueue.put(house);
      }
    } catch(InterruptedException e) {
      print("Exiting Assembler via interrupt");
    } catch(BrokenBarrierException e) {
      // This one we want to know about
      throw new RuntimeException(e);
    }
    print("Assembler off");
  }
}

class Reporter implements Runnable {
  private HouseQueue houseQueue;
  public Reporter(HouseQueue cq) { houseQueue = cq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        print(houseQueue.take());
      }
    } catch(InterruptedException e) {
      print("Exiting Reporter via interrupt");
    }
    print("Reporter off");
  }
}

abstract class Builder implements Runnable {
  private BuilderPool pool;
  public Builder(BuilderPool p) { pool = p; }
  protected Assembler assembler;
  public Builder assignAssembler(Assembler assembler) {
    this.assembler = assembler;
    return this;
  }
  private boolean engage = false;
  public synchronized void engage() {
    engage = true;
    notifyAll();
  }
  // The part of run() that's different for each robot:
  abstract protected void performService();
  public void run() {
    try {
      powerDown(); // Wait until needed
      while(!Thread.interrupted()) {
        performService();
        assembler.barrier().await(); // Synchronize
        // We're done with that job...
        powerDown();
      }
    } catch(InterruptedException e) {
      print("Exiting " + this + " via interrupt");
    } catch(BrokenBarrierException e) {
      // This one we want to know about
      throw new RuntimeException(e);
    }
    print(this + " off");
  }
  private synchronized void
  powerDown() throws InterruptedException {
    engage = false;
    assembler = null; // Disconnect from the Assembler
    // Put ourselves back in the available pool:
    pool.release(this);
    while(engage == false)  // Power down
      wait();
  }
  public String toString() { return getClass().getName(); }
}

class PolBuilder extends Builder {
  public PolBuilder(BuilderPool pool) { super(pool); }
  protected void performService() {
    print(this + " kladet pol");
    assembler.house().addPol();
  }
}

class SteniBuilder extends Builder {
  public SteniBuilder(BuilderPool pool) { super(pool); }
  protected void performService() {
    print(this + " stavit steni");
    assembler.house().addSteni();
  }
}

class KrishaBuilder extends Builder {
  public KrishaBuilder(BuilderPool pool) { super(pool); }
  protected void performService() {
    print(this + " kladet krishu");
    assembler.house().addKrisha();
  }
}

class BuilderPool {
  // Quietly prevents identical entries:
  private Set<Builder> pool = new HashSet<Builder>();
  public synchronized void add(Builder r) {
    pool.add(r);
    notifyAll();
  }
  public synchronized void
  hire(Class<? extends Builder> builderType, Assembler d)
  throws InterruptedException {
    for(Builder r : pool)
      if(r.getClass().equals(builderType)) {
        pool.remove(r);
        r.assignAssembler(d);
        r.engage(); // Power it up to do the task
        return;
      }
    wait(); // None available
    hire(builderType, d); // Try again, recursively
  }
  public synchronized void release(Builder r) { add(r); }
}

public class HouseBuilder {
  public static void main(String[] args) throws Exception {
    HouseQueue fundamentQueue = new HouseQueue(),
             finishingQueue = new HouseQueue();
    ExecutorService exec = Executors.newCachedThreadPool();
    BuilderPool builderPool = new BuilderPool();
    exec.execute(new PolBuilder(builderPool));
    exec.execute(new SteniBuilder(builderPool));
    exec.execute(new KrishaBuilder(builderPool));
    exec.execute(new Assembler(
      fundamentQueue, finishingQueue, builderPool));
    exec.execute(new Reporter(finishingQueue));
    // Start everything running by producing chassis:
    exec.execute(new FundamentBuilder(fundamentQueue));
    TimeUnit.SECONDS.sleep(7);
    exec.shutdownNow();
  }
} /* (Execute to see output) *///:~

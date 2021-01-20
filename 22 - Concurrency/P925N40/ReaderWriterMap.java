//: concurrency/ReaderWriterList.java
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import static net.mindview.util.Print.*;
import net.mindview.util.*;
public class ReaderWriterMap<T extends Integer, L> implements Map<T, L>{
  public Set<Map.Entry<T,L>> entrySet() { return null;}
  public Collection<L> values() {return null;}
  public Set<T> keySet() {return null;}
  public boolean equals(Object o) {return false;}
  public void clear() {}
  public void putAll(Map<? extends T,? extends L> m) {}
  public int hashCode() {return 0;}
  public L remove(Object key) {return lockedMap.get(key);}
  public boolean containsValue(Object value) {return false;}
  public L get(Object key) {return lockedMap.get(key);}
  public boolean containsKey(Object key) {return false;}
  public boolean isEmpty() {return false;}
  public int size(){return 0;}

  private HashMap<Integer , L> lockedMap;
  // Make the ordering fair:
  private ReentrantReadWriteLock lock =
    new ReentrantReadWriteLock(true);
  public ReaderWriterMap(int size, L initialValue) {
    lockedMap = new HashMap<Integer, L>();
     int ii = 0;
    for (L l : Collections.nCopies(size, initialValue)) {
     lockedMap.put( ii, l);
     ii++;
    }
  }
 public ReaderWriterMap(MapData<T, L> m) {
  lockedMap = new HashMap<Integer, L>();
  lockedMap.putAll(m);
    
  }
  public L put(T index, L element) {
    Lock wlock = lock.writeLock();
    wlock.lock();
    try {
      return lockedMap.put(index, element);
    } finally {
      wlock.unlock();
    }
  }
  public L get(int index) {
    Lock rlock = lock.readLock();
    rlock.lock();
    try {
      // Show that multiple readers
      // may acquire the read lock:
      if(lock.getReadLockCount() > 1)
        print(lock.getReadLockCount());
      return lockedMap.get(index);
    } finally {
      rlock.unlock();
    }
  }
  public static void main(String[] args) throws Exception {
    new ReaderWriterMapTest(30, 1);
  }
}

class ReaderWriterMapTest {
  ExecutorService exec = Executors.newCachedThreadPool();
  private final static int SIZE = 100;
  private static Random rand = new Random(47);
  private ReaderWriterMap<Integer, Integer> map =
    new ReaderWriterMap<Integer, Integer>(SIZE, 0);
  private class Writer implements Runnable {
    public void run() {
      try {
        for(int i = 0; i < 20; i++) { // 2 second test
          map.put(i, rand.nextInt());
          TimeUnit.MILLISECONDS.sleep(100);
        }
      } catch(InterruptedException e) {
        // Acceptable way to exit
      }
      print("Writer finished, shutting down");
      exec.shutdownNow();
    }
  }
  private class Reader implements Runnable {
    public void run() {
      try {
        while(!Thread.interrupted()) {
          for(int i = 0; i < SIZE; i++) {
            map.get(i);
            TimeUnit.MILLISECONDS.sleep(1);
          }
        }
      } catch(InterruptedException e) {
        // Acceptable way to exit
      }
    }
  }
  public ReaderWriterMapTest(int readers, int writers) {
    for(int i = 0; i < readers; i++)
      exec.execute(new Reader());
    for(int i = 0; i < writers; i++)
      exec.execute(new Writer());
  }
} /* (Execute to see output) *///:~
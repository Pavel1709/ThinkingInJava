//: containers/SimpleHashMap.java
// A demonstration hashed Map.
import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
  // Choose a prime number for the hash table
  // size, to achieve a uniform distribution:
  static final int SIZE = 997;
  // You can't have a physical array of generics,
  // but you can upcast to one:
  @SuppressWarnings("unchecked")
  LinkedList<MapEntry<K,V>>[] buckets =
    new LinkedList[SIZE];
  public V put(K key, V value) {
    V oldValue = null;
    int index = Math.abs(key.hashCode()) % SIZE;
    if(buckets[index] == null)
      buckets[index] = new LinkedList<MapEntry<K,V>>();
    LinkedList<MapEntry<K,V>> bucket = buckets[index];
    MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
    boolean found = false;
    ListIterator<MapEntry<K,V>> it = bucket.listIterator();
    int probes = 0;
    while(it.hasNext()) {
      MapEntry<K,V> iPair = it.next();
      probes++;
      if(iPair.getKey().equals(key)) {
        oldValue = iPair.getValue();
        it.set(pair); // Replace old with new
        found = true;
        System.out.println("Collision at " +  iPair + ": " + probes + " probe"  + ((probes == 1) ? "" : "s") + " needed");
        break;
        
      }
    }
    if(!found)
      buckets[index].add(pair);
    return oldValue;
  }
    public int size() {
   int result = 0;
   for(LinkedList bucket : buckets)
    if(bucket != null) result += bucket.size();
     return result;
  }
  private int firstNonEmptyBucket() {
   if(buckets.length < 1) return -1;
    for(int j = 0; j < buckets.length; j++) 
     if(buckets[j] != null) return j;
   return -1;		
  }
  private int start(int i) {
   int first = this.firstNonEmptyBucket();
    if(i < first) return -1;
    if(i == first) return 0;
    int result = 0;
     for(int j = first; j < i; j++) 
      if(buckets[j] != null) result += buckets[j].size();
	return result;
  }
  private EntrySet entries = new EntrySet();
  private KeySet keys = new KeySet();
  public Set<Map.Entry<K,V>> entrySet() { return entries; }
  public Set<K> keySet() { return keys; }
  public boolean isEmpty() {
   return this.size() == 0;
  }
  private int end(int i) {
   int first = this.firstNonEmptyBucket();
    if(i < first) return -1;
     return start(i) + ((buckets[i] == null) ? 0 : buckets[i].size()); 
  }
  public void putAll(Map<? extends K, ? extends V> m) {
   for(Map.Entry<? extends K,? extends V> me : m.entrySet())
    this.put(me.getKey(), me.getValue());
  }
  public void clear() {
   for(LinkedList<MapEntry<K,V>> bucket : buckets)
    if(bucket != null) bucket.clear();		
  }
  public boolean containsKey(Object key) {
   int index = Math.abs(key.hashCode()) % SIZE;
   if(buckets[index] == null) return false;
    for(MapEntry<K,V> iPair : buckets[index])
     if(iPair.getKey().equals(key))
	 return true;
   return false;
  }	
  public boolean containsValue(Object value) {
   for(LinkedList<MapEntry<K,V>> bucket : buckets) {
    if(bucket != null) 
     for(MapEntry<K,V> iPair : bucket)
      if(iPair.getValue().equals(value)) return true;
     }
     return false;
  }
  public V get(Object key) {
    int index = Math.abs(key.hashCode()) % SIZE;
    if(buckets[index] == null) return null;
    for(MapEntry<K,V> iPair : buckets[index])
      if(iPair.getKey().equals(key))
        return iPair.getValue();
    return null;
  }
 
  public Collection<V> values() {
   HashSet<V> vals = new HashSet<V>();
   for(LinkedList<MapEntry<K,V>> bucket : buckets) {
    if(bucket != null) 
     for(MapEntry<K,V> iPair : bucket)
      vals.add(iPair.getValue()); 
   }
   return vals;
  }
  public boolean equals(Object o) {
   if(o instanceof SimpleHashMap) {
   if(this.entrySet().equals(((SimpleHashMap)o).entrySet()))
    return true;
   }
   return false;
  }
  public int hashCode() {
   return this.entrySet().hashCode();
  }	
  public V remove(Object o) {
   V v = null;
   if(this.get(o) != null) {
    int index = Math.abs(o.hashCode()) % SIZE;
    for(MapEntry<K,V> iPair : buckets[index])
     if(iPair.getKey().equals(o)) {
	 v = iPair.getValue();
         int i = buckets[index].indexOf(iPair);
         buckets[index].remove(i);
         break;		
     }
    }
    return v;		
  }
  private class EntrySet extends AbstractSet<Map.Entry<K,V>> {
   public int size() { return SimpleHashMap.this.size(); }
   public Iterator<Map.Entry<K,V>> iterator() {
    return new Iterator<Map.Entry<K,V>>() {
     private int index = -1;
     public boolean hasNext() {
      return index < SimpleHashMap.this.size() - 1; 
     }
     @SuppressWarnings("unchecked")
     public Map.Entry<K,V> next() {
      int i = ++index;
      for(int j = 0; j < SIZE; j++) {
       if((start(j) <= index) && (index < end(j)))
        return new MapEntry(buckets[j].get(index - start(j)).getKey(),buckets[j].get(index - start(j)).getValue());	
      }
      return null;						
     }
     public void remove() {
      for(int j = 0; j < SIZE; j++)
       if(start(j) <= index && index < end(j))
        buckets[j].remove(index - start(j));
       index--;			
      }				
     };
    }
   }	
   private class KeySet extends AbstractSet<K> {
    public int size() { return SimpleHashMap.this.size(); }
    public Iterator<K> iterator() {
     return new Iterator<K>() {
      private int index = -1;
      public boolean hasNext() {
       return index < SimpleHashMap.this.size() - 1; 
      }
      public K next() {
       int i = ++index;
       for(int j = 0; j < SIZE; j++) {
        if((start(j) <= index) && (index < end(j)))
         return buckets[j].get(index - start(j)).getKey();
       }
       return null; 	
      }
      public void remove() {
       for(int j = 0; j < SIZE; j++)
	if(start(j) <= index && index < end(j))
	  buckets[j].remove(index - start(j));
	index--;		
      }
     };
    }
   } 
  public static void main(String[] args) {
    SimpleHashMap<String,String> m =
      new SimpleHashMap<String,String>();
    m.putAll(Countries.capitals(25));
    m.putAll(Countries.capitals(25));
    m.put("a", "ok");
    m.put("a", "not");
    m.put("a", "not");
    System.out.println(m);
    System.out.println(m.get("ERITREA"));
    System.out.println(m.entrySet());
    m.clear();
    m.remove("a");
    System.out.println(m);
    System.out.println(m.get("ERITREA"));
    System.out.println(m.entrySet());
  }
} 

//: containers/SlowMap.java
// A Map implemented with ArrayLists.
import java.util.*;
import net.mindview.util.*;

public class SlowMap<K,V>  implements Map<K,V> {
  private List<K> keys = new ArrayList<K>();
  private List<V> values = new ArrayList<V>();
  public V put(K key, V value) {
    V oldValue = get(key); // The old value or null
    if(!keys.contains(key)) {
      keys.add(key);
      values.add(value);
    } else
      values.set(keys.indexOf(key), value);
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
  public V get(Object key) { // key is type Object, not K
    if(!keys.contains(key))
      return null;
    return values.get(keys.indexOf(key));
  }
  public Set<Map.Entry<K,V>> entrySet() {
    Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
    Iterator<K> ki = keys.iterator();
    Iterator<V> vi = values.iterator();
    while(ki.hasNext())
      set.add(new MapEntry<K,V>(ki.next(), vi.next()));
    return set;
  }
  public Set<K> keySet() {
   Set<K> set = new TreeSet<K>();
   for (K k: keys) 
    set.add(k);
   return set;
  }
  public Collection<V> values() {
   return values;
  }
  public boolean equals(Object o) {
   return (o.equals(this));
  }
  public void putAll(Map<? extends K,? extends V> m) {
   for(Map.Entry<? extends K,? extends V> map: m.entrySet()) {
    keys.add(map.getKey());
    values.add(map.getValue());
   }
  }
  public void clear() {
   keys = new ArrayList<K>();
   values = new ArrayList<V>();
  }
  protected Object clone() {
   return this;
  }
  public int hashCode() {
   return (this.hashCode());
  }
  public V remove(Object key) {
   V v;
   if (keys.contains(key)) {
     v = get(key);
    if (keys.contains(key)) {
     keys.remove(keys.indexOf(key));
    }
    return v;
   }
   return null;
  }
  public boolean containsKey(Object key) {
   if (keys.contains(key))
    return true;
   return false;
  }
  public boolean containsValue(Object value) {
   if (values.contains(value)) 
    return true;
   return false; 
  }
  public boolean isEmpty() {
   if (keys.size() == 0)
    return true;
   return false;
  }
  public int size() {
   return keys.size();
  }
  public static void main(String[] args) {
    SlowMap<String,String> m= new SlowMap<String,String>();
    m.putAll(Countries.capitals(15));
    System.out.println(m);
    System.out.println(m.get("BULGARIA"));
    System.out.println(m.entrySet());
    m.clear();
    m.put("a", "a");
    System.out.println(m);
  }
} /* Output:
{CAMEROON=Yaounde, CHAD=N'djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti}
Sofia
[CAMEROON=Yaounde, CHAD=N'djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti]
*///:~

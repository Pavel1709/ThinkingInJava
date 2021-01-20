import static net.mindview.util.Print.*;
import java.util.*;
import net.mindview.util.*;


  
public class SlowMap<K,V> extends AbstractMap<K,V> {
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
  public static void main(String[] args) {
    SlowMap<String,Integer> map1 = new SlowMap<String,Integer>( );
    String fileName = "Help.txt";
    ArrayList<String> words = new ArrayList<String>(new TextFile(fileName, "\\W+"));
    words.add("one");
    words.add("two");
    words.add("three");
     words.add("three");
    for (String word: words) {
     if (map1.keys.contains(word)) {
      map1.put(word, map1.get(word) + 1);
     }  
     else { 
      map1.put(word, 1);
     }
    }
  /*  
    for(String key1: map1.getKeys()) {
     for(String key2: map1.getKeys()) {
      if ( (key1.equals(key2)) && (map1.get(key1)<=map1.get(key2)) ) {
        map1.remove(key1);
      }
     }
    }
 */
    System.out.println(map1);
  }
}  
class MapEntry<K,V> implements Map.Entry<K,V> {
  private K key;
  private V value;
  public MapEntry(K key, V value) {
    this.key = key;
    this.value = value;
  }
  public K getKey() { return key; }
  public V getValue() { return value; }
  public V setValue(V v) {
    V result = value;
    value = v;
    return result;
  }
  public int hashCode() {
    return (key==null ? 0 : key.hashCode()) ^
      (value==null ? 0 : value.hashCode());
  }
  public boolean equals(Object o) {
    if(!(o instanceof MapEntry)) return false;
    MapEntry me = (MapEntry)o;
    return
      (key == null ?
       me.getKey() == null : key.equals(me.getKey())) &&
      (value == null ?
       me.getValue()== null : value.equals(me.getValue()));
  }
  public String toString() { return key + "=" + value; }
} ///:~
//задача интересная и понимаю, что реально могу исправить косяк с выводом одних и тех же ключей по несколько раз, 
//но из-за нехватки времени не имею возможности исправлять сейчас. 

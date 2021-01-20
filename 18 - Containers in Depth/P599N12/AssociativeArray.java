//: containers/AssociativeArray.java
// Associates keys with values.
import static net.mindview.util.Print.*;
import java.util.*;
public class AssociativeArray<K,V> {
  private Object[][] pairs;
  private int index;
  public AssociativeArray(int length) {
    pairs = new Object[length][2];
  }
  public void put(K key, V value) {
    if(index >= pairs.length)
      throw new ArrayIndexOutOfBoundsException();
    pairs[index++] = new Object[]{ key, value };
  }
  @SuppressWarnings("unchecked")
  public V get(K key) {
    for(int i = 0; i < index; i++)
      if(key.equals(pairs[i][0]))
        return (V)pairs[i][1];
    return null; // Did not find key
  }
  public String toString() {
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < index; i++) {
      result.append(pairs[i][0].toString());
      result.append(" : ");
      result.append(pairs[i][1].toString());
      if(i < index - 1)
        result.append("\n");
    }
    return result.toString();
  }
  public static void main(String[] args) {
    AssociativeArray<String,String> map1 =
      new AssociativeArray<String,String>(6);
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("sky", "blue");
    map.put("grass", "green");
    map.put("ocean", "dancing");
    map.put("tree", "tall");
    map.put("earth", "brown");
    map.put("sun", "warm");
    try {
      map.put("extra", "object"); // Past the end
    } catch(ArrayIndexOutOfBoundsException e) {
      print("Too many objects!");
    }
    print(map);
    print(map.get("ocean"));
    TreeMap<String, String> tmap = new TreeMap<String, String>();
    tmap.put("sky", "blue");
    tmap.put("grass", "green");
    tmap.put("ocean", "dancing");
    tmap.put("tree", "tall");
    tmap.put("earth", "brown");
    tmap.put("sun", "warm");
    try {
      tmap.put("extra", "object"); // Past the end
    } catch(ArrayIndexOutOfBoundsException e) {
      print("Too many objects!");
    }
    print(tmap);
    print(tmap.get("ocean"));
    LinkedHashMap<String, String> lhmap = new LinkedHashMap<String, String>();
    lhmap.put("sky", "blue");
    lhmap.put("grass", "green");
    lhmap.put("ocean", "dancing");
    lhmap.put("tree", "tall");
    lhmap.put("earth", "brown");
    lhmap.put("sun", "warm");
    try {
      lhmap.put("extra", "object"); // Past the end
    } catch(ArrayIndexOutOfBoundsException e) {
      print("Too many objects!");
    }
    print(lhmap);
    print(lhmap.get("ocean"));
  }
} /* Output:
Too many objects!
sky : blue
grass : green
ocean : dancing
tree : tall
earth : brown
sun : warm
dancing
*///:~

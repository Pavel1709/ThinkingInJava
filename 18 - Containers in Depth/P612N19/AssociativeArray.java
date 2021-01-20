import static net.mindview.util.Print.*;
import java.util.*;
import net.mindview.util.*;
public class AssociativeArray<K,V> {
  private Object[][] pairs;
  private int index;
  boolean b = true;
 

  
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
  public void remove(K k) {
     for (int i = 0; i < pairs.length; i++) {
       if (k.equals(pairs[i][0])) {
        pairs[i][1] = 1;
        pairs[i][0] = "w";
      }
     }
  }
  public boolean containsKey(K a) {
   for (int i = 0; i < pairs.length; i++) {
       if (pairs[i][0].equals(a)) {return true;}
   }
   return false;
  }
  @SuppressWarnings("unchecked")

  public Set<K> getKeys() {
   LinkedHashSet<K> ars = new LinkedHashSet<K>();
   for (int i = 0; i < pairs.length; i++) {
       ars.add((K) pairs[i][0]);
   } 
   return ars;
  }
   @SuppressWarnings("unchecked")

  public List<V> getVals() {
   ArrayList<V> ars = new ArrayList<V>();
   for (int i = 0; i < pairs.length; i++) {
       ars.add((V) pairs[i][1]);
   } 
   return ars;
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
    AssociativeArray<String,Integer> map1 = new AssociativeArray<String,Integer>(100);
    String fileName = "Help.txt";
    ArrayList<String> words = new ArrayList<String>(new TextFile(fileName, "\\W+"));
    words.add("one");
    words.add("two");
    words.add("three");
     words.add("three");
    for (String word: words) {
     if (map1.getKeys().contains(word)) {
      map1.put(word, map1.get(word) + 1);
     }  
     else { 
      map1.put(word, 1);
     }
    }

    System.out.println(map1);
  }
}  
//задача интересная и понимаю, что реально могу исправить косяк с выводом одних и тех же ключей по несколько раз, 
//но из-за нехватки времени не имею возможности исправлять сейчас. 

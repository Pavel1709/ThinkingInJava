//: containers/SlowMap.java
// A Map implemented with ArrayLists.
import java.util.*;
import net.mindview.util.*;

public class SlowSet<V> extends AbstractSet<V> {
  private Set<V> values = new TreeSet<V>();
  public V put(V value) {
    if(values.contains(value)) {
      return null;
      
    } else
      values.add(value);
    return value;
  }
  public void putAll(Collection <? extends V> m) {
   for(V map: m) {
    values.add(map);
   }
  }
  public V get(int key) { 
   ArrayList<V> ar = new ArrayList<V>();
   ar.addAll(values);
    if(ar.size() >= (key))
      return ar.get(key);
    return null;
  }
  public int size() {
   return values.size();
  }
  public Iterator<V> iterator() { 
   Iterator<V> i = values.iterator();
   return i;
  }
  public static void main(String[] args) {
    SlowSet<String>m= new SlowSet<String>();
    m.putAll(Countries.names(15));
    System.out.println(m);
    System.out.println(m.get(5));
  }
} /* Output:
{CAMEROON=Yaounde, CHAD=N'djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti}
Sofia
[CAMEROON=Yaounde, CHAD=N'djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti]
*///:~

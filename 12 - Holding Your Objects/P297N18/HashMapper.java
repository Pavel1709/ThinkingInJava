import java.util.*;
 
public class HashMapper {
 static HashMap<Integer, String> hasher = new HashMap<Integer, String>();
 public static void main(String[] args) {
  hasher.put(3, "He");
  hasher.put(6, "She");
  hasher.put(1, "I");
  hasher.put(58, "It");
  hasher.put(34, "They");
  hasher.put(166, "Them");
  hasher.put(88, "Him");
  hasher.put(12, "Her");
  hasher.put(11, "Me");
  hasher.put(122, "Their");
  LinkedHashMap<Integer, String> linkedHasher = new LinkedHashMap<Integer, String>();
  Set<Integer> keys = new TreeSet(hasher.keySet());
  System.out.println(keys);
 System.out.println(hasher);
  for (int i: keys){
      linkedHasher.put(i, hasher.get(i));
  }  
  System.out.println(linkedHasher);
 }
}
import java.util.*;
 
public class HashMapper {
 static HashSet< String> hasher = new HashSet< String>();
 public static void main(String[] args) {
  hasher.add("He");
  hasher.add("She");
  hasher.add("I");
  hasher.add("It");
  hasher.add("They");
  hasher.add("Them");
  hasher.add("Him");
  hasher.add("Her");
  hasher.add("Me");
  hasher.add("Their");
  LinkedHashSet<String> linkedHasher = new LinkedHashSet<String>();
  Set<String> vals = new TreeSet(hasher );
  System.out.println(vals);
  System.out.println(hasher);
  for (String i: vals) {
      linkedHasher.add(i);
  }  
  System.out.println(linkedHasher);
 }
}
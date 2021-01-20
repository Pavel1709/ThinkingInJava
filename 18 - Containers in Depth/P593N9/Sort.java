import java.util.*;
import net.mindview.util.*;
public class Sort {
 public static void main(String[] args) {
  Generator<String> g = new RandomGenerator.String();
  SortedSet<String> sortedSet = new TreeSet<String>();
  for (int i = 0; i < 30; i++) {
   sortedSet.add(g.next());
  }
  System.out.println(sortedSet);
 }
}
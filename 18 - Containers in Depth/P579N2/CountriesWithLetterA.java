import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public class CountriesWithLetterA {
 public static void main(String[] args) {
  Map<String, String> allCous = new HashMap<String,String>(Countries.capitals(Countries.DATA.length));
  Map<String, String> aCous = new HashMap<String,String>();
  Set<String> aCousSet = new TreeSet<String>();
  for (Map.Entry<String, String> entry: allCous.entrySet()) {
   if (entry.getKey().charAt(0)==('A')) {
    aCous.put(entry.getKey(), entry.getValue());
    aCousSet.add(entry.getKey());
   }
  }
  print(aCousSet);
  print(aCous);
 }
}
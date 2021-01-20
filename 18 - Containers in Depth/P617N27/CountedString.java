//: containers/CountedString.java
// Creating a good hashCode().
import java.util.*;
import static net.mindview.util.Print.*;

public class CountedString {
  private static List<String> created =
    new ArrayList<String>();
  private String s;
  private int id = 0;
  public CountedString(String str) {
    s = str;
    created.add(s);
    // id is the total number of instances
    // of this string in use by CountedString:
    for(String s2 : created)
      if(s2.equals(s))
        id++;
  }
  public String toString() {
    return "String: " + s + " id: " + id +
      " hashCode(): " + hashCode();
  }
  public int hashCode() {
    // The very simple approach:
    // return s.hashCode() * id;
    // Using Joshua Bloch's recipe:
    int result = 17;
    result = 37 * result + s.hashCode();
    return result;
  }
  public boolean equals(Object o) {
    return o instanceof CountedString &&
      s.equals(((CountedString)o).s) &&
      id == ((CountedString)o).id;
  }
  public static void main(String[] args) {
    Map<CountedString,Integer> map =
      new HashMap<CountedString,Integer>();
    CountedString[] cs = new CountedString[5];
    for(int i = 0; i < cs.length; i++) {
      cs[i] = new CountedString("hi");
      map.put(cs[i], i); // Autobox int -> Integer
    }
    print(map);
    for(CountedString cstring : cs) {
      print("Looking up " + cstring);
      print(map.get(cstring));
    }
  }
} /* Output: (Sample)
{String: hi id: 1 hashCode(): 3958=0, String: hi id: 2 hashCode(): 3958=1, String: hi id: 3 hashCode(): 3958=2, String: hi id: 4 hashCode(): 3958=3, String: hi id: 5 hashCode(): 3958=4}
Looking up String: hi id: 1 hashCode(): 3958
0
Looking up String: hi id: 2 hashCode(): 3958
1
Looking up String: hi id: 3 hashCode(): 3958
2
Looking up String: hi id: 4 hashCode(): 3958
3
Looking up String: hi id: 5 hashCode(): 3958
4
*///:~ //проблема в том, что разные оюъекты обладают одинаковым hash-кодом

import java.util.*;
public class withMethod {
 String value;
 withMethod(String value) {
     this.value = value;
 }
 public String toString() {
     return value;
 }
 public static void useIt(Collection c) {
  Iterator r = c.iterator();
   while(r.hasNext()) {
       Object o = r.next();
       System.out.println(o.toString());
   }
  }
  public static void main(String[] args) {
    ArrayList<Object> arrList = new ArrayList<Object>(Arrays.asList(new withMethod ("ok"), new withMethod("yes"), new withMethod("no"),new withMethod( "why"), new withMethod("who"),new withMethod( "what")));
    LinkedList<Object> linList = new LinkedList<Object>(Arrays.asList(new withMethod ("ok"), new withMethod("yes"), new withMethod("no"),new withMethod( "why"), new withMethod("who"),new withMethod( "what")));
    HashSet<Object> hSet = new HashSet<Object>(Arrays.asList(new withMethod ("ok"), new withMethod("yes"), new withMethod("no"),new withMethod( "why"), new withMethod("who"),new withMethod( "what")));
    LinkedHashSet<Object> lhSet = new LinkedHashSet<Object>(Arrays.asList(new withMethod ("ok"), new withMethod("yes"), new withMethod("no"),new withMethod( "why"), new withMethod("who"),new withMethod( "what")));
    useIt(arrList);
    useIt(linList);
    useIt(hSet);
    useIt(lhSet);
  }
}
   
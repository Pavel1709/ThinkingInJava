import java.util.*;
public class WildCard {
 public static void main(String[] args) {
  //! List<Number> n = new ArrayList<Integer>(); 
  //error: incompatible types: ArrayList<Integer> cannot be converted to List<Number>
  //!List<Number> nn = new ArrayList<Integer>();
  List<? extends Number> nnn = new ArrayList<Integer>();
  // error: incompatible types: ArrayList<Integer> cannot be converted to List<Number> List<Number> nn = new ArrayList<Integer>();
  //!nnn.add(new Integer(10));
  nnn.add(null);
  System.out.println(nnn.get(0));
 }
}


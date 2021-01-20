import java.util.*;
import net.mindview.util.*;
public class Schetchik {
  ArrayList<Integer> sch = new ArrayList<Integer>();
  static Map<String, ArrayList<Integer>> maper = new HashMap <String, ArrayList<Integer>>();
  public static void main(String[] args) {
   List<String> wordsInFile = new ArrayList<String>(new TextFile("Schetchik.java", "\\W+"));
   
   int l = 0;
   for(String s: wordsInFile) {
    l++;
    if (!maper.containsKey(s)) {
     ArrayList<Integer> sch = new ArrayList<Integer>();
     sch.add(l);
     maper.put(s, sch);
    }
    else {
     ArrayList<Integer> sh1 = maper.get(s);
     sh1.add(l);
     maper.put(s, sh1);
    }
   } 
   System.out.println(wordsInFile);
   System.out.println(maper);
  }
}
 
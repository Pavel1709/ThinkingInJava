import net.mindview.util.CountingGenerator;
import net.mindview.util.*;
import java.util.*;
public class DoubleGen {
 public static void main(String[] ags) {
  StringBuilder s = new StringBuilder();
  Generator<Character> g = new CountingGenerator.Character();
   for (int i = 0; i < 10; i++) {
    s.append(g.next());
   }
   System.out.println((s));
 }
}
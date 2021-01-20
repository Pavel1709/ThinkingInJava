import java.util.*;
import net.mindview.util.*;
public class ArrWithInt {
 public static void main(String[] args) {
  Random rand = new Random(47);
  Integer[] ints = new Integer[10];
  for(int i = 0; i < ints.length; i++) {
   int j = rand.nextInt();
   ints[i] = j;
  }
  System.out.println("Not sorted: " + Arrays.toString(ints));
  Arrays.sort(ints, Collections.reverseOrder());
  System.out.println("Sorted: " + Arrays.toString(ints));
 }
}
  
import java.util.*;
import net.mindview.util.*;
public class SomeType {
  public static void main(String[] args) {
   List<Integer> ints = New.list();
   for (int i = 0; i < 5; i++ ) {
    ints.add(i);
   }
   System.out.println(ints);
   String[] numbers = new String[]{"Zero", "One", "Two", "Three", "Four"};
   Map<String, Integer> nums= New.map();
   for (int i = 0; i < 5; i++ ) {
    nums.put(numbers[i], i);
   }
   System.out.println(nums);
  }
}
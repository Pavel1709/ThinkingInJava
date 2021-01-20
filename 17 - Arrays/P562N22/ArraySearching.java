import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public class ArraySearching {
  public static void main(String[] args) {
   Generator<Integer> gen = new RandomGenerator.Integer(30);
   int[] a = ConvertTo.primitive( Generated.array(new Integer[25], gen));
   print("Not sorted array: " + Arrays.toString(a));
   for (int i = 0; i <5; i++)
   while(true) {
    int r = gen.next();
    int location = Arrays.binarySearch(a, r); 
    if(location >= 0) {
      print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
    break; // Out of while loop
    }
    else{ System.out.println("Элемент " + r + " не найден"); }
   } 
   Arrays.sort(a);
   print("Not sorted array: " + Arrays.toString(a));
   for (int i = 0; i <5; i++)
   while(true) {
    int r = gen.next();
    int location = Arrays.binarySearch(a, r); 
    if(location >= 0) {
      print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
    break; // Out of while loop
    }
    else{ System.out.println("Элемент " + r + " не найден"); }
   }   
 }
}
//Вроде, все нормально
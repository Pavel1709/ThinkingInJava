import java.util.*;
public class DeeEqTest {
 public static void main(String[] args) {
  int[][] i1 = new int[5][];
  int[][] i2 = new int[5][];
  for(int j = 0; j < i1.length; j++) {
   i1[j] = new int[3];
   for (int k = 0; k < i1[j].length; k++) {
    i1[j][k] = 5;
   }
  }
  for(int j = 0; j < i2.length; j++) {
   i2[j] = new int[3];
   for (int k = 0; k < i2[j].length; k++) {
    i2[j][k] = 5;
   }
  }
  System.out.println(Arrays.deepEquals(i1, i2));
  System.out.println(Arrays.equals(i1, i2));
 }
}
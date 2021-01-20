import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class ArrayManipulator {
 public static double[][] makeDoubAr(int l, int m, int x, int y) {
  double[][] d = new double[l][];
  for (int j = 0; j < l; j++) {
   d[j] = new double[m];
   for (int k = 0; k < m; k ++) {
    d[j][k] = ThreadLocalRandom.current().nextDouble(x, y);
   }
  }
  return d;
 }
 public static void showDoubAr(double[][] d) {
  System.out.println(Arrays.deepToString(d));
 }
 public static void main(String[] args) {
  showDoubAr(makeDoubAr(5, 8, 100, 150));
  showDoubAr(makeDoubAr(6, 7, 0, 150));
  showDoubAr(makeDoubAr(7, 6, 7, 9));
  showDoubAr(makeDoubAr(8, 5, 5, 500));
  showDoubAr(makeDoubAr(9, 4, 500, 502));
 }
}
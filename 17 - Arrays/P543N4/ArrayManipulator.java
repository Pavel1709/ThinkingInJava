import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class ArrayManipulator {
 public static double[][][] makeDoubAr(int l, int m, int n, int x, int y) {
  double[][][] d = new double[l][][];
  for (int j = 0; j < l; j++) {
   d[j] = new double[m][];
   for (int k = 0; k < m; k ++) {
    d[j][k] = new double[n];
    for (int s = 0; s < n; s++) {
     d[j][k][s] = ThreadLocalRandom.current().nextDouble(x, y);
    }
   }
  }
  return d;
 }
 public static void showDoubAr(double[][][] d) {
  System.out.println(Arrays.deepToString(d));
 }
 public static void main(String[] args) {
  showDoubAr(makeDoubAr(2, 3, 4, 100, 150));
  showDoubAr(makeDoubAr(6, 7, 3, 0, 150));
  showDoubAr(makeDoubAr(7, 6, 4, 7, 9));
  showDoubAr(makeDoubAr(8, 5, 5, 5, 500));
  showDoubAr(makeDoubAr(9, 4, 6, 500, 502));
 }
}
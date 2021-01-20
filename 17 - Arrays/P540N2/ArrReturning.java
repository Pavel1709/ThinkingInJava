import java.util.*;
class BerylliumSphere {
 private static long counter;
 private final long id = counter++;
 public String toString() { return "Sphere " + id; }
}
public class ArrReturning {
 public static BerylliumSphere[] ret(int i) {
  BerylliumSphere[] bl = new BerylliumSphere[i];
  for (int j = 0; j < i; j++) {
   bl[j] = new BerylliumSphere();
  }
  return bl;
 }
 public static void main(String[] args) {
  Random r = new Random();
  System.out.println(Arrays.toString(ret(r.nextInt(100))));
 }
}
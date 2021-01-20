import java.util.*;
class BerylliumSphere {
 private static long counter;
 private final long id = counter++;
 public String toString() { return "Sphere " + id; }
}
public class AgrTwo {
 public BerylliumSphere[][] MakeTwoArgAr(int a, int b) {
  BerylliumSphere[][] bll = new BerylliumSphere[a][b];
  for (int i = 0; i < a; i++) {
   for (int j = 0; j < b; j++) {
    bll[i][j] = new BerylliumSphere(); 
   }
  }
  return bll;
 }
 public static void main(String[] args) {
  AgrTwo at = new AgrTwo();
  System.out.println(Arrays.deepToString(at.MakeTwoArgAr(3,3)));
 }
}
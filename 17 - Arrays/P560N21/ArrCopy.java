import java.util.*;
class BerylliumSphere implements Comparable<BerylliumSphere>, Comparator<BerylliumSphere>{
 private static long counter;
 private final long id = counter++;
 public String toString() { return "Sphere " + id; }
 public int i;
 public int compareTo(BerylliumSphere rv) {
  return (id <rv.id ? -1 :(i== rv.id ? 0 :1));
 }
 public int compare(BerylliumSphere b1, BerylliumSphere b2) {
  return (b1.id < b2.id ? -1: (b1.id == b2.id ? 0 : 1));
 }
}

public class ArrCopy {
 public static void main(String[] args) {
  BerylliumSphere[] b1 = new BerylliumSphere[5];
  Arrays.fill(b1, new BerylliumSphere());
  System.out.println("b1" + Arrays.toString(b1));
  BerylliumSphere[] b2 = new BerylliumSphere[5];
  Arrays.fill(b2, new BerylliumSphere());
  System.out.println("b2" + Arrays.toString(b2));
  System.arraycopy(b1, 0, b2, 1, 4);
  System.out.println("b2" + Arrays.toString(b2));
  Arrays.fill(b2, b1[1]);
  System.out.println("b2" + Arrays.toString(b2));
  for(int i = 0; i < b2.length; i++) {
   b1[i] = new BerylliumSphere();
  }
  System.out.println("b1" + Arrays.toString(b1));
  for(int i = 0; i < b2.length; i++) {
   b2[i] = new BerylliumSphere();
  }
  System.arraycopy(b1, 0, b2, 1, 4);
  System.out.println("b2" + Arrays.toString(b2));
  //новые объекты не создаются, заполняется уже существующими сылками
  Arrays.sort(b2);
  System.out.println("b2" + Arrays.toString(b2));
  Arrays.sort(b2, Collections.reverseOrder());
  System.out.println("b2" + Arrays.toString(b2));
 }
}
 
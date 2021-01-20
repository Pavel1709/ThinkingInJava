import java.util.*;
class OneEx implements Comparable<OneEx>{
 int i;
 OneEx(int i) {
  this.i = i;
 }
 public boolean equals(Object b) {
  return (b.getClass().getSimpleName() == "OneEx"  && this.i == ((OneEx)b).i ) ? true : false;
 } 
 public int compareTo(OneEx b) {
  return (this.i < b.i ? -1 : (this.i == b.i ? 0 : 1));
 }
 public String toString() {
  return   this.getClass().getSimpleName() + " " +i;
 }
}
public class ExecutorForOneEx {
 public static void main(String[] args) {
  OneEx[] oe = new OneEx[10];
  OneEx[] eo = new OneEx[10];
  Random r = new Random();
  int rr = r.nextInt(15);
  Arrays.fill(oe, new OneEx(r.nextInt(15)));
  Arrays.fill(eo, new OneEx(r.nextInt(15)));
  for (int i = 0; i < oe.length; i++) {
   oe[i] = new OneEx(r.nextInt(15));
  }
  System.out.println(Arrays.equals(eo, oe)); 
  int index = Arrays.binarySearch(oe, oe[1]);
  System.out.println(Arrays.toString(oe));
  System.out.println(index); 
  Arrays.sort(oe);
  int index2 = Arrays.binarySearch(oe, oe[1]);
  System.out.println(Arrays.toString(oe));
  System.out.println(index2);
 }
}
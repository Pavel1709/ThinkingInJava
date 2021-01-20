import java.util.*;
class OneEx {
 int i;
 OneEx(int i) {
  this.i = i;
 }
 public boolean equals(Object b) {
  return (b.getClass().getSimpleName() == "OneEx"  && this.i == ((OneEx)b).i ) ? true : false;
 } 
}
public class ExecutorForOneEx {
 public static void main(String[] args) {
  OneEx[] oe = new OneEx[10];
  OneEx[] eo = new OneEx[10];
  Arrays.fill(oe, new OneEx(2));
  Arrays.fill(eo, new OneEx(2));
  System.out.println(Arrays.equals(eo, oe)); 
 }
}
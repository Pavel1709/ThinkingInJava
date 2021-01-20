import net.mindview.util.*;
class SixTuple<A, B, C, D ,E, F> extends TwoTuple<A,B> {
 public final C third;
 public final D fourth;
 public final E fifth;
 public final F sixth;
 public SixTuple(A a, B b, C c, D d,E e, F f) {
  super(a, b);
  third = c;
  fourth = d;
  fifth = e;
  sixth = f;
 }
 public String toString() {
  return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + "," + sixth + ")";
 }
}
public class TupleTest {
 static SixTuple<String, Integer, Double, Long, Float, Boolean> f() {
  return new SixTuple<String, Integer, Double, Long, Float, Boolean>("hi", 7, 4.4, 10000000l, 5.55f, true );
 }
 public static void main(String[] args) {
  SixTuple<String, Integer, Double, Long, Float, Boolean> st = f();
  System.out.println(st);
 }
}
 
  


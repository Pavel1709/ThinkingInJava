//: generics/TupleTest2.java
import net.mindview.util.*;
import static net.mindview.util.Tuple.*;
 class Amphibian{}
 class Vehicle{}
 public class TupleTest2 {
 static TwoTuple<String,Integer> f() {
  return tuple("hi", 47); 
 }
 static TwoTuple f2() { 
  return tuple("hi", 47); 
 } 
 static ThreeTuple<Amphibian,String,Integer> g() {
  return tuple(new Amphibian(), "hi", 47); 
 }
 static FourTuple<Vehicle,Amphibian,String,Integer> h() {
  return tuple(new Vehicle(), new Amphibian(), "hi", 47); 
 }
 static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
  return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
 }
 public static void main(String[] args) {
  TwoTuple<String,Integer> ttsi = f(); 
  System.out.println(ttsi);
  //!TwoTuple<String,Integer> ttsi2 = f2();
  //!System.out.println(ttsi2);
  System.out.println(g());
  System.out.println(h());
  System.out.println(k()); 
 }
}
/*
TupleTest2.java:10: warning: [rawtypes] found raw type: TwoTuple
 static TwoTuple f2() { 
        ^
  missing type arguments for generic class TwoTuple<A,B>
  where A,B are type-variables:
    A extends Object declared in class TwoTuple
    B extends Object declared in class TwoTuple
TupleTest2.java:25: warning: [unchecked] unchecked conversion
  TwoTuple<String,Integer> ttsi2 = f2();
                                     ^
  required: TwoTuple<String,Integer>
  found:    TwoTuple
2 warnings
*/
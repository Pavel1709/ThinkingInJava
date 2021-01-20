//: arrays/ArrayOfGenerics.java
// It is possible to create arrays of generics. 
import java.util.*;
class BerylliumSphere {
 private static long counter;
 private final long id = counter++;
 public String toString() { return "Sphere " + id; }
}
public class ArrayOfGenerics { 
 @SuppressWarnings("unchecked")
 public static void main(String[] args) {
  List<List<String>> ls;
  List<List > la = new ArrayList<List >();
  //ls = (List<List<String>>) la; // incompatible types
  la.add(new ArrayList<String>());
  //List<Object> objects = (List<List<String>>)ls; //incompatible types
  List<Object> objects = new ArrayList<Object>();
  //objects.add(new ArrayList<Integer>());
  List<List<BerylliumSphere>> spheres = new ArrayList<List<BerylliumSphere>>(); 
  for(int i = 0; i < spheres.size(); i++)
   spheres.add(new ArrayList<BerylliumSphere>()); 
  for (int i = 0; i < spheres.size(); i++) {
   spheres.get(0).add(new BerylliumSphere());
  }
  for(List<BerylliumSphere> l: spheres) {
   for(BerylliumSphere  b: l) {
    System.out.println(b);
   }
  }
 }
}
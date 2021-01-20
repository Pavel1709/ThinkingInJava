//: arrays/ContainerComparison.java import java.util.*;
import static net.mindview.util.Print.*;
import net.mindview.util.CountingGenerator;
import net.mindview.util.*;
import java.util.*;
class BerylliumSphere {
 private static long counter;
 private final long id = counter++;
 public String toString() { return "Sphere " + id; }
}
class BerylliumSphereGen implements Generator<BerylliumSphere> {
 public BerylliumSphere next() {
  return new BerylliumSphere();
 }
}
public class ContainerComparison {
 public static void main(String[] args) { 
  BerylliumSphere[] spheres = new BerylliumSphere[10]; 
  for(int i = 0; i < 5; i++)
   spheres[i] = new BerylliumSphere(); 
  print(Arrays.toString(spheres));
  print(spheres[4]);
  List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
  for(int i = 0; i < 5; i++) 
   sphereList.add(new BerylliumSphere());
  print(sphereList); 
  print(sphereList.get(4));
  int[] integers = { 0, 1, 2, 3, 4, 5 }; 
  print(Arrays.toString(integers)); 
  print(integers[4]);
  List<Integer> intList = new ArrayList<Integer>( Arrays.asList(0, 1, 2, 3, 4, 5));
  intList.add(97); 
  print(intList); 
  print(intList.get(4));
  Generator<?> g = new BerylliumSphereGen();
  BerylliumSphere[] b = Generated.array(BerylliumSphere.class,new BerylliumSphereGen() , 10);
  print(Arrays.toString(b)); 
 }
}
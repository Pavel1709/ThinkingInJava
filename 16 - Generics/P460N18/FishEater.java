//: generics/BankTeller.java
// A very simple bank teller simulation. 
import java.util.*;
import net.mindview.util.*;
class SmallFish {
 private static long counter = 1;
 private final long id = counter++;
 private SmallFish() {}
 public String toString() { 
  return "SmallFish " + id; 
 } // A method to produce Generator objects:
 public static Generator<SmallFish> generator() {
  return new Generator<SmallFish>() {
   public SmallFish next() { return new SmallFish(); }
  }; 
 }
}
 class Generators {
public static <T> Collection<T>
 fill(Collection<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++) coll.add(gen.next());
    return coll;
  }
}
class BigFish {
 private static long counter = 1;
 private final long id = counter++;
 private BigFish() {}
 public String toString() { return "BigFish " + id; } // A single Generator object:
 public static Generator<BigFish> generator = new Generator<BigFish>() {
  public BigFish next() { return new BigFish(); }
 }; 
}
public class FishEater {
 public static void serve(BigFish t, SmallFish c) {
  System.out.println(t + " eats " + c +" in the ocean"); 
 }
 public static void main(String[] args) {
  Random rand = new Random(47);
  Queue<SmallFish> line = new LinkedList<SmallFish>(); 
  Generators.fill(line, SmallFish.generator(), 15);
  List<BigFish> bigFish = new ArrayList<BigFish>();
  Generators.fill(bigFish, BigFish.generator, 4);
  for(SmallFish c : line) 
  serve(bigFish.get(rand.nextInt(bigFish.size())), c);
 }
}
//: generics/Functional.java
import java.math.*;
import java.util.concurrent.atomic.*; 
import java.util.*;
import static net.mindview.util.Print.*;
// Different types of function objects:
interface Combiner<T> {
 T combine(T x, T y); 
}
interface UnaryFunction<R,T> { 
 R function(T x); 
}
 interface Collector<T> extends UnaryFunction<T,T> {
  T result(); // Extract result of collecting parameter
}
interface UnaryPredicate<T> { 
 boolean test(T x);
}
class Flower {
 String name;
 Flower(String name) { this.name = name; }
 Flower() { this.name = null; }
 public void set(String n) { this.name = n; }
 public String get() { return name; }
 public String toString() { return "Bucket " + name; }
}
class Candy {
 String name;
 Candy(String name) { this.name = name; }
 Candy() { this.name = null; }
 public void set(String n) { this.name = n; }
 public String get() { return name; }
 public String toString() { return "Candy " + name; }
}
public class Functional {
 // Calls the Combiner object on each element to combine 
 // it with a running result, which is finally returned: 
 public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) { 
  Iterator<T> it = seq.iterator(); 
  if(it.hasNext()) {
   T result = it.next(); while(it.hasNext())
   result = combiner.combine(result, it.next());
   return result;
  }
  // If seq is the empty list:
  return null;
  // Or throw exception
 }
 // Take a function object and call it on each object in 
 // the list, ignoring the return value. The function
 // object may act as a collecting parameter, so it is 
 // returned at the end.
 public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
  for(T t : seq) func.function(t);
   return func;
 }
 // Creates a list of results by calling a
 // function object for each object in the list: 
 public static <R,T> List<R> transform(Iterable<T> seq, UnaryFunction<R,T> func) {
  List<R> result = new ArrayList<R>(); 
  for(T t : seq)
   result.add(func.function(t)); 
  return result;
 }
 // Applies a unary predicate to each item in a sequence, 
 // and returns a list of items that produced "true": 
 public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
  List<T> result = new ArrayList<T>(); 
  for(T t : seq)
   if(pred.test(t)) 
    result.add(t);
  return result;
 }
 // To use the above generic methods, we need to create 
 // function objects to adapt to our particular needs: 
 static class IntegerAdder  implements Combiner<Integer> {
  public Integer combine(Integer x, Integer y) {
   return x + y; 
  }
 }
 static class FlowerMaker implements Combiner<Flower> {
  public Flower combine(Flower f1, Flower f2) {
   return new Flower(f1.get() + "," + f2.get());
  }
 }
 static class CandyMaker implements Combiner<Candy> {
  public Candy combine(Candy c1, Candy c2) {
   return new Candy(c1.get() + "," + c2.get());
  }
 }
 static class FlowerCollector implements Collector<Flower> {
  private Flower buket = new Flower("");
  public Flower function(Flower x) {
   buket = new Flower(buket.get() + " " + x.get()) ;
   return buket;
  }
  public Flower result() { 
   return new Flower(buket.get() + " is made."); 
  }
 }
 static class IntegerSubtracter implements Combiner<Integer> {
  public Integer combine(Integer x, Integer y) {
   return x - y; 
  }
 }
 static class BigDecimalAdder implements Combiner<BigDecimal> {
  public BigDecimal combine(BigDecimal x, BigDecimal y) {
   return x.add(y); 
  }
 }
 static class BigIntegerAdder implements Combiner<BigInteger> {
  public BigInteger combine(BigInteger x, BigInteger y) { 
   return x.add(y);
  } 
 }
 static class AtomicLongAdder implements Combiner<AtomicLong> {
  public AtomicLong combine(AtomicLong x, AtomicLong y) { 
   // Not clear whether this is meaningful:
   return new AtomicLong(x.addAndGet(y.get())); 
  }
 }
 // We can even make a UnaryFunction with an "ulp"
 // (Units in the last place):
 static class BigDecimalUlp implements UnaryFunction<BigDecimal,BigDecimal> {
  public BigDecimal function(BigDecimal x) {
   return x.ulp(); 
  }
 }
 static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
  private T bound;
  public GreaterThan(T bound) { 
   this.bound = bound; 
  } 
  public boolean test(T x) {
   return x.compareTo(bound) > 0; 
  }
 }
 static class MultiplyingIntegerCollector implements Collector<Integer> {
  private Integer val = 1;
  public Integer function(Integer x) {
   val *= x;
   return val; 
  }
  public Integer result() { return val; }
 }
 public static void main(String[] args) {
  // Generics, varargs & boxing working together: 
  List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7); 
  Integer result = reduce(li, new IntegerAdder()); 
  print(result);
  result = reduce(li, new IntegerSubtracter()); 
  print(result);
  print(filter(li, new GreaterThan<Integer>(4)));
  print(forEach(li,
  new MultiplyingIntegerCollector()).result());
  print(forEach(filter(li, new GreaterThan<Integer>(4)), new MultiplyingIntegerCollector()).result());
  MathContext mc = new MathContext(7); List<BigDecimal> lbd = Arrays.asList(
  new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
  new BigDecimal(3.3, mc), new BigDecimal(4.4, mc)); BigDecimal rbd = reduce(lbd, new BigDecimalAdder()); print(rbd);
  print(filter(lbd, new GreaterThan<BigDecimal>(new BigDecimal(3))));
  // Use the prime-generation facility of BigInteger: 
  List<BigInteger> lbi = new ArrayList<BigInteger>();
  BigInteger bi = BigInteger.valueOf(11); 
  for(int i = 0; i < 11; i++) {
   lbi.add(bi);
   bi = bi.nextProbablePrime(); 
  }
  print(lbi);
  BigInteger rbi = reduce(lbi, new BigIntegerAdder()); 
  print(rbi);
  // The sum of this list of primes is also prime: 
  print(rbi.isProbablePrime(5));
  List<AtomicLong> lal = Arrays.asList( new AtomicLong(11), new AtomicLong(47), new AtomicLong(74), new AtomicLong(133));
  AtomicLong ral = reduce(lal, new AtomicLongAdder()); print(ral);
  print(transform(lbd,new BigDecimalUlp()));
  List<Flower> fl = Arrays.asList(new Flower("Roza"), new Flower("Fialka"), new Flower("Tulpan"), new Flower("Pion"));
 Flower res = reduce(fl, new FlowerMaker());
 print(res);
 print("***************");
 List<Candy> la = Arrays.asList(new Candy("Choko pie"), new Candy("Twix"), new Candy(" Snickers"), new Candy("Mars"), new Candy("Baunti"));
 Candy res2 = reduce(la, new CandyMaker());
 print(res2);
 print("***************");
 List<Flower> toCollect = Arrays.asList(new Flower("Roza"), new Flower("Fialka"), new Flower("Tulpan"));
 print(forEach(toCollect, new FlowerCollector()).result());
 }
}
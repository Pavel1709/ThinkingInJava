import java.util.*;
import net.mindview.util.*;

class Product {
 private final int id;
 private String description;
 private double price;
 public Product(int IDnumber, String descr, double prc) {
  id = IDnumber;
  description = descr;
  price = prc;
  System.out.println(toString());
 }
 public String toString() {
  return id + ": " + description + ", price: $ "+  price;
 }
 public void priceChange(double change) {
  price += change;
 }
 public static Generator<Product> generator() {
  return new Generator<Product>() {
   private Random rand = new Random(47);
   public Product next() {
    return new Product( rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
   }
  };
 } 
}
class Generators {
public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++) coll.add(gen.next());
    return coll;
  }
}
class Package extends ArrayList<Product> {
 public Package(int nProds) {
  Generators.fill(this, Product.generator(), nProds);
 }
}
class Container extends ArrayList<Package> {
 public Container(int nPacks, int nProds) {
  for (int i = 0; i < nPacks; i++) 
   add(new Package(nProds));
 }
}
class CheckoutStans{}
class Office{}

public class Sudno extends ArrayList<Container> {
 private ArrayList<CheckoutStans> checkouts = new ArrayList<CheckoutStans>();
 private Office office = new Office();
 public Sudno(int nConts,int nPacks,int nProds) {
  for (int i = 0; i < nConts; i++) {
   add(new Container(nPacks, nProds ));
  }
 }
 public String toString() {
  StringBuilder result = new StringBuilder();
  for (Container c: this) {
   for (Package p: c) {
    for (Product  pr: p); {
     result.append(p);
     result.append("\n");
    }
   }
  }
  return result.toString();
 }
 public static void main(String[] args) {
  System.out.println(new Sudno(2,10,3));
 }
}

 
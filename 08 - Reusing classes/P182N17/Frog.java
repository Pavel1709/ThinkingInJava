class Amphibian {
 public void swim() {
  System.out.println("Amphibian Swimming");
 }
 public  void swims(Amphibian a) {
  a.swim();
 }
}
public class Frog extends Amphibian {
 @Override
 public void swim() {
  System.out.println("Frog Swimming");
 }

 @Override
 public void swims(Amphibian a) {
   System.out.print("Overriden ");
   a.swim();
 }
 public static void main(String[] args) {
  Frog f = new Frog();
  Amphibian a = new Amphibian();
  a.swims(f);
  f.swim();
 }
}
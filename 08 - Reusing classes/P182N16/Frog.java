class Amphibian {
 public void swim() {
  System.out.println("Swimming");
 }
 public static void swims(Amphibian a) {
  a.swim();
 }
}
public class Frog extends Amphibian {
 public static void main(String[] args) {
  Frog f = new Frog();
  swims(f);
  f.swim();
 }
}
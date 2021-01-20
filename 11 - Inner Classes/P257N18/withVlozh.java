public class withVlozh {
 static int s = 7;
 public static class Vlozh {
  public static void inc() {
   s++;
  }
 }
 public static Vlozh ret() {
  return new Vlozh();
 }
 public static void main(String[] args) {
  Vlozh v = new Vlozh();
  v.inc();
  System.out.println(s);
 }
}
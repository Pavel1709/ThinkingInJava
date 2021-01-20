interface Standable {
 void stand();
 void lie();
}
class Human implements Standable{
 public void stand() {
  System.out.println("Stand on two legs");
 }
 public void lie() {
  System.out.println("Lie on the back");
 }
 public void run() {
  System.out.println("Run with two legs");
 }
}
public class Manipulator {
 
 public <T extends Standable> void execurMehts(T x) {
   T obj = x;
   x.stand();
   x.lie();
 }
 public static void main(String[] args) {
  Manipulator mnpltr = new Manipulator();
  Human hmn = new Human();
  mnpltr.execurMehts(hmn);
 }
}
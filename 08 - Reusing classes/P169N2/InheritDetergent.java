import detergent.*;
public class InheritDetergent extends Detergent {
 public static void main(String[] args) {
  InheritDetergent d = new InheritDetergent();
  d.dilute();
  d.apply();
  d.scrub();
  d.sterilize();
  d.foam();
  System.out.println(d);
 }
  @Override 
  public void scrub() {
   append("I nheritDetergent.scrub()");
  }
  public void sterilize() {
   append(" sterilize()");
  }
}
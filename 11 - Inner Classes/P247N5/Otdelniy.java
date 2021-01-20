class Vneshny {
 public void one() {
  System.out.println("Vneshny.one()");
 }
  class Vnutrenniy {
  public void two() {
   System.out.println("Vneshny.Vnutrenniy.two()");
  }
 }
}
public class Otdelniy {
 public static void main(String [] args) {
  Vneshny v = new Vneshny();
  Vneshny.Vnutrenniy vv =  v.new Vnutrenniy();
  vv.two();
 }
}
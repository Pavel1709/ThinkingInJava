interface Int1{}
interface Int2{}
public class Realizer implements Int1, Int2 {
 public <T extends Int1>void meth1(T t) {
  System.out.println("meth1");
 }
 public <T extends Int1>void meth2(T t) {
  System.out.println("meth2");
 }
 public static void main(String[] args) {
  Realizer r = new Realizer();
  r.meth1(r);
  r.meth2(r);
 }
}
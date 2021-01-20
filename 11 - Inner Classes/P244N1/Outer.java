public class Outer {
 class Inner {
 }
 Inner getInner() {
  System.out.print("Получите ссылку на Inner");
  return new Inner();
 }
 public static void main(String[] args) {
  Outer o = new Outer();
  Outer.Inner i = o.getInner();
 }
}

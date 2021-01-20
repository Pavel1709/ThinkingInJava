public class Outer {
 private String s;
 public Outer( String s) {
  this.s = s;
 }
 class Inner {
  public String toString() {
   return s;
  }
 }
 Inner getInner() {
  System.out.println("Получите ссылку на Inner");
  return new Inner();
 }
 public static void main(String[] args) {
  Outer o = new Outer("HI");
  Outer.Inner i = o.getInner();
  System.out.println(i);
 }
}

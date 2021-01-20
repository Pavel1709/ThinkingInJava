public class Outer {
 private int j = 8;
 class Inner {
  private int i = 7;
  void VivodIsVnut() {
   System.out.println(j);
  }
 }
 void Vivod() {
  //System.out.println(i);
 }
 public static void main(String[] args) {
  Outer o = new Outer();
  o.Vivod();
  Outer.Inner ooo = o.new Inner();
  ooo.VivodIsVnut();
 }
}
//нет, внешнему классу закрытое поле внутреннего класса недоступно, а вот внутреннему классу закрытое поле внешнего - доступно.
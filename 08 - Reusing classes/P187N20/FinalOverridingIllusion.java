//: reusing/FinalOverridingIllusion.java // It only looks like you can override // a private or private final method.
import static net.mindview.util.Print.*;
class WithFinals {
 // Identical to "private" alone:
 private final void f() { 
  print("WithFinals.f()");
 } // Also automatically "final":
 private void g() { 
  print("WithFinals.g()"); 
 }
}
class OverridingPrivate extends WithFinals {
  @Override
  private final void f() { //method does not override or implement a method from a supertype. Теперь у нас не происходит лже-переопределения метода. Метод приватный, а следовательно недоступен никакому классу снаружи. Поэтому у определения тоже нет места быть.

   print("OverridingPrivate.f()"); 
  }
  @Override
  private void g() {
   print("OverridingPrivate.g()"); } //method does not override or implement a method from a supertype

  }
  class OverridingPrivate2 extends OverridingPrivate {
   public final void f() {
    print("OverridingPrivate2.f()"); 
   }
   public void g() { 
    print("OverridingPrivate2.g()");
   } 
}
public class FinalOverridingIllusion {
  public static void main(String[] args) {
   OverridingPrivate2 op2 = new OverridingPrivate2(); 
   op2.f();
   op2.g();
   // You can upcast:
  OverridingPrivate op = new OverridingPrivate();
  // But you can’t call the methods: 
   //   op.f();
   //  op.g();
  // Same here:
  WithFinals wf = op2;
  //! wf.f();
  //! wf.g();
 }
} /* Output: OverridingPrivate2.f() OverridingPrivate2.g() *///:~
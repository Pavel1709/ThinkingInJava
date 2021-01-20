class A {

 class B {
  B(int l) {
   System.out.println(l);
  }
 }
}
public class C {
 class D extends A.B {
  D(A a , int l) {
   a.super(l);
  }
 }
 public static void main(String[] args) {
  A a = new A();
  A.B b= a.new B(7);
  C c = new C();
  C.D d =c.new D(a , 5);
 }
}
class A{
 A(int a) {
  System.out.println("A");
 }
}
class B{
 B(int b) {
  System.out.println("B");
 }
}
public class C extends A {
 C() {
  super(8);
 }
 public static void main(String[] args) {
 B b = new B(10);
 C c = new C();
 } 
}
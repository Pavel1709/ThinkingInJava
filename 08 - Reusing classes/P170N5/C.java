class A{
 A() {
  System.out.println("A");
 }
}
class B{
 B() {
  System.out.println("B");
 }
}
public class C extends A {
 public static void main(String[] args) {
 B b = new B();
 C c = new C();
 } //ну, ничего необычного не заметил. Класс В имеет конструктор. печатающий В, при создании экземпляра в другом классе, класс с наследует класс а, поэтому при создании его экземпляра, мы видим вызов конструктора из А.
}
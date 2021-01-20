class Component1 {
 int i = 7;
 Component1() {
  System.out.println("Component1 called");
 }
}
class Component2 {
 Component2() {
  System.out.println("Component2 called");
 }
}
class Component3 {
 Component3() {
  System.out.println("Component3 called");
 }
}
class Root { 
 Root() {
  System.out.println("Root called");
 }
 static Component1 c1 = new Component1();
 Component2 c2 = new Component2();
 Component3 c3 = new Component3();
}

public class Stem extends Root {
 Stem() { 
  System.out.println("Stem called");
 }
 public static void main(String[] args) {
 Stem st = new Stem();
 System.out.println(c1.i);
 }
}
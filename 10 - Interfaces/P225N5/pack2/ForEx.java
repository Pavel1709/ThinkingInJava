package pack2;
import pack1.Example;

public class ForEx implements Example {
 public void first() {
  System.out.println("Implementation of the first method");
 }
 public String second() {
  return "Implementation of the first method";
 }
 public int third() {
  System.out.print("Implementation of  method № ");
  return 3;
 }
 public static void main(String[] args) {
  ForEx f = new ForEx();
  f.first();
  System.out.println(f.second());
  System.out.println(f.third());
 }
}
//javac -sourcepath ./ ./pack2/ForEx.java
//java  pack2.ForEx 
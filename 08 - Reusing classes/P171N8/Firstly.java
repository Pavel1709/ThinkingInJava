class First {
 First(String s) {
  System.out.println("First " + s);
 }
}
public class Firstly extends First{
 Firstly() {
  super("Hello");
  System.out.println("Firstly ");
 } 
 Firstly(String s) {
  super("Hello");
  System.out.println("Firstly " + s);
 }
 public static void main(String[] args) {
  Firstly ff = new Firstly( );
  Firstly f = new Firstly("Hi");
 }
}
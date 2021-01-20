public class StaticCheck {
 StaticCheck() {
   System.out.println("s =" + s);
   System.out.println("ss =" + ss);
 }
 static String s = "Something";
 static String ss;
 static {
  ss = "Anything";
 }
 static void printStatic() {
  StaticCheck c = new StaticCheck(); // создаем экземпляр, чтобы сработал конструктор.
  System.out.println(s);
  System.out.println(ss);
 }
 public static void main(String[] args) {
  printStatic();
 }
}
//: reusing/Beetle.java
// The full process of initialization. 
import static net.mindview.util.Print.*;
class Insect { 
 private int i = 9; 
 protected int j; 
 Insect() {
  print("i = " + i + ", j = " + j);
  j = 39; 
 }
 private static int x1 =
 printInit("static Insect.x1 initialized");
 static int printInit(String s) {
  print(s);
  return 47; 
 }
}
class Beetle extends Insect {
  int k = printInit("Beetle.k initialized"); 
 public Beetle() {
  print("k = " + k);
  print("j = " + j); 
 }
 private static int x2 =
 printInit("static Beetle.x2 initialized");

 
} 
 public class GoldBeetle extends Beetle {
  private int s = printInit("GoldBeetle.s initialized"); 
  public GoldBeetle() {
   print("k = " + k);
   print("j = " + j); 
   print("s = " + s); 
  }
  public static void main(String[] args) {
   print("GoldBeetle constructor");
   GoldBeetle gb = new GoldBeetle();
 } 
}
/* Вывод:
static Insect.x1 initialized //сначала инициализируются статические поля в порядке их написания(если имеет место обращение к ним, в данном случае мы  работаем в классе, который является наследником  класса, в котором данные поля находятся. Поэтому они тут и задействованы)
static Beetle.x2 initialized //То же самое, только
GoldBeetle constructor // работаем с содержимым мэйна
i = 9, j = 0 // создается экземпляр класса, сразу переходим к родительским классам, сначала инсекту, потом к битлу. Сначала инициализируются поля, потом можно приступить к выполнению конструкторов, тут это и происходит(Сначала конструктор самого базового класса)
Beetle.k initialized // так как с инсектом закончено,  инициализируются поля битла
k = 47 // затем работает констуктор битла
j = 39 // то же самое
GoldBeetle.s initialized //переходям к полям ГолдБитл
k = 47 //к контейнеру
j = 39 // -||-
s = 47 // -||-
*///:~

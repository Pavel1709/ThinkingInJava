abstract class basic {
 
 basic() {
  print();
 }
 abstract void print();
}
public class devider extends basic {

 int m = 7;
 
 void print() {
  System.out.println(m);
 }
 public static void main(String[] args) {
  devider dev = new devider();
  dev.print();
 }
} /* Output:
0
7
*/
//Вывод такой, поскольку сначала у нас выполняется конструктор базового класса, так как он выполняет метод print, логика которого определена только в классе-наследнике, то он выполняется в соответствии с этой логикой, то есть берется из класса наследника, но, так как переменные еще не инициализированы, то мы получаем ноль, то есть значение по умолчанию.  Затем уже выполняется наш метод из производного класса, переменная уже инициализирована.
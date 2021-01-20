package pack1;
public class CheckProtect {
 public void printProtect() {
  ShowProtect sp = new ShowProtect();
   System.out.println(sp.l); //  классы из одного пакета-> l  будет доступна
  }
}
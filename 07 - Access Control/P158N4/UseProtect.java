import pack1.*;
public class UseProtect {
 public static void main(String[] args) {
  ShowProtect sp = new ShowProtect();
   System.out.println(sp.l); // не получится, так как классы в разных пакетах, а l protected
  CheckProtect cp = new CheckProtect();
  cp.printProtect();// а тут получится, так как метод printProtect() выводит protected  член класса, находящегося в том же пакете
 }
}
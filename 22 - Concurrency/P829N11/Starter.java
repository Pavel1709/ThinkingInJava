class First implements Runnable{
 Doer d = new Doer();
 public void run() {
  d.change();
  System.out.println(this + " x = " + d.getX());
  System.out.println(this + " y = " + d.getY());
 }
}
class Second implements Runnable{
 Doer d = new Doer();
 public void run() {
  d.change();
  System.out.println(this + " x = " + d.getX());
  System.out.println(this + " y = " + d.getY());
 }
}
class Third implements Runnable{
 Doer d = new Doer();
 public void run() {
  d.change();
  System.out.println(this + " x = " + d.getX());
  System.out.println(this + " y = " + d.getY());
 }
}
public class Starter { 
 
 public static void main(String[] args) {
  Thread t1 = new Thread(new First());
  Thread t2 = new Thread(new Second()); 
  Thread t3 = new Thread(new Third());
  t1.start();
  t2.start();
  t3.start();
 }
}
/* с public synchronized void change() результат:
Third@51fe8d4c x = 256
Third@51fe8d4c y = 8192
First@6bf7bba7 x = 256
First@6bf7bba7 y = 8192
Second@50d4dc7 x = 256
Second@50d4dc7 y = 8192
статические поля получаются одинаковыми, что мы и ожидаем увидеть, однако, если убрать synchronized, результат может получиться следующим:
Third@50d4dc7 x = 8
Third@50d4dc7 y = 8192
Second@6bf7bba7 x = 256
Second@6bf7bba7 y = 8192
First@216fabe9 x = 8
First@216fabe9 y = 8192


*/
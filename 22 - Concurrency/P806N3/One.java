public class One implements Runnable {
 One() {
  System.out.println("Beginning message1");
 }
 public void run() {
  System.out.println(" first Run from One");
  Thread.yield();
  System.out.println(" second Run from One");
  Thread.yield();
  System.out.println(" third Run from One");
  Thread.yield();
  System.out.println("Final message1");
  return;
 }
}
public class Two implements Runnable {
 Two() {
  System.out.println("Beginning message2");
 }
 public void run() {
  System.out.println(" first Run from Two");
  Thread.yield();
  System.out.println(" second Run from Two");
  Thread.yield();
  System.out.println(" third Run from Two");
  Thread.yield();
  System.out.println("Final message2");
  return;
 }
}
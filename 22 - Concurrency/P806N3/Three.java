public class Three implements Runnable {
 Three() {
  System.out.println("Beginning message3");
 }
 public void run() {
  System.out.println(" first Run from Three");
  Thread.yield();
  System.out.println(" second Run from Three");
  Thread.yield();
  System.out.println(" third Run from Three");
  Thread.yield();
  System.out.println("Final message3");
  return;
 }
}
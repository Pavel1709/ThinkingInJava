public class MainThread {
 public static void main(String[] args) {
  Thread t1 = new Thread(new One());
  Thread t2 = new Thread(new Two());
  Thread t3 = new Thread(new Three());
  t1.start();
  t2.start();
  t3.start();
 }
}
 


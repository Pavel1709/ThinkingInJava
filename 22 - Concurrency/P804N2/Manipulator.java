public class Manipulator{
 public static void main(String[] args) {
  Thread t1 = new Thread(new Fibonacci1(6));
  Thread t2 = new Thread(new Fibonacci2(7));
  Thread t3 = new Thread(new Fibonacci3(8));
  t1.start();
  t2.start();
  t3.start();
 

 }
}
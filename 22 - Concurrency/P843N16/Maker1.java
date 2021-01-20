class Runner1 implements Runnable {
 ClassWithThreeMethods1 c1 = new ClassWithThreeMethods1();
 public void run() {
  try{
   c1.one(); 
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }
 }
}
class Runner2 implements Runnable {
 ClassWithThreeMethods1 c2 = new ClassWithThreeMethods1();
 public void run() {
  try{
   c2.two();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }
 }
}
class Runner3 implements Runnable {
 ClassWithThreeMethods1 c3 = new ClassWithThreeMethods1();
 public void run() {
  try{
   c3.three();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }  
 }
}
public class Maker1 {
 public static void main(String[] args) {
  Thread first = new Thread(new Runner1());
  Thread second = new Thread(new Runner2());
  Thread third = new Thread(new Runner3());  
  first.start();
  second.start();
  third.start();
 }
}

class Runner11 implements Runnable {
 ClassWithThreeMethods  c1 = new ClassWithThreeMethods();
 public void run() {
  try{
   c1.one(); 
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }
 }
}
class Runner22 implements Runnable {
 ClassWithThreeMethods  c2 = new ClassWithThreeMethods ();
 public void run() {
  try{
   c2.two();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }
 }
}
class Runner33 implements Runnable {
 ClassWithThreeMethods  c3 = new ClassWithThreeMethods ();
 public void run() {
  try{
   c3.three();
  }
  catch(InterruptedException e) {
   System.out.println(e);
  }  
 }
}
public class Maker  {
 public static void main(String[] args) {
  Thread first = new Thread(new Runner11());
  Thread second = new Thread(new Runner22());
  Thread third = new Thread(new Runner33());  
  first.start();
  second.start();
  third.start();
 }
}
//почему-то для одного объекта вс равно выполняются в одно и то же время. Почему - не понимаю.
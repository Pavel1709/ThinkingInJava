interface Interface {
 void doSomething();
 void somethingElse(String arg);
}
class RealObject implements Interface {
 public void doSomething() { 
  System.out.println("doSomething"); 
 } 
 public void somethingElse(String arg) {
  System.out.println("somethingElse " + arg); 
 }
}
class SimpleProxy implements Interface {
  private Interface proxied;
  public SimpleProxy(Interface proxied) {
   this.proxied = proxied; 
  }
  public void doSomething() { 
   System.out.println("SimpleProxy doSomething");
   proxied.doSomething(); 
  }
  public void somethingElse(String arg) { 
   System.out.println("SimpleProxy somethingElse " + arg);
   proxied.somethingElse(arg); }
  }
  public class SimpleProxyDemo {
   public static void consumer(Interface iface) {
    long time = System.nanoTime();
    iface.doSomething();
    System.out.println("Время вызова iface.doSomething() " + (System.nanoTime() - time));
    long time1 = System.nanoTime();
    iface.somethingElse("bonobo"); 
    System.out.println("Время вызова  iface.somethingElse() " + (System.nanoTime() - time1));
   }
  public static void main(String[] args) {
   long time = System.nanoTime();
    consumer(new RealObject());
    System.out.println("Время вызова consumer(new RealObject()) " + (System.nanoTime() - time));
    long time1 = System.nanoTime();
    consumer(new SimpleProxy(new RealObject()));
    System.out.println("Время вызова consumer(new SimpleProxy(new RealObject())) " + (System.nanoTime() - time1));
  }
} 
/*
doSomething
Время вызова iface.doSomething() 153151
somethingElse bonobo
Время вызова iface.somethingElse() 23899
Время вызова consumer(new RealObject()) 459168
SimpleProxy doSomething
doSomething
Время вызова iface.doSomething() 43970
SimpleProxy somethingElse bonobo
somethingElse bonobo
Время вызова iface.somethingElse() 34694
Время вызова consumer(new SimpleProxy(new RealObject())) 401796
*/
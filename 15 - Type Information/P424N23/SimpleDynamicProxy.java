//: typeinfo/SimpleDynamicProxy.java 
import java.lang.reflect.*;
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
class DynamicProxyHandler implements InvocationHandler {
 private static long count = 0;
 private Object proxied;
 public DynamicProxyHandler(Object proxied) {
  this.proxied = proxied; 
 }
 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
  System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
  if(args != null) 
   for(Object arg : args)
    System.out.println(" " + arg); 
   try{
     Object o=method.invoke(proxied, args);
     count++;
     return o;
    }catch(Exception e){
      System.out.println(e);
      return null;
    }
 } 

 public static void showCount(){
  System.out.println("Proxy is invoked "+count+" times!");
 }
}
public class SimpleDynamicProxy {
  public static void consumer(Interface iface) {
    long time = System.nanoTime();
    iface.doSomething();
    System.out.println("Время вызова iface.doSomething() " + (System.nanoTime() - time));
    long time1 = System.nanoTime();
    iface.somethingElse("bonobo"); 
    System.out.println("Время вызова  iface.somethingElse() " + (System.nanoTime() - time1));
  }
  public static void main(String[] args) {
   RealObject real = new RealObject();
   long l1 = System.nanoTime(); 
   consumer(real);
   System.out.println("Время вызова consumer(real) " + (System.nanoTime() - l1));
   // Insert a proxy and call again:
   Interface proxy = (Interface)Proxy.newProxyInstance(
   Interface.class.getClassLoader(), new Class[]{ Interface.class }, new DynamicProxyHandler(real));
   long l2 = System.nanoTime();
   consumer(proxy);
   System.out.println("Время вызова consumer(proxy) " + (System.nanoTime() - l2));
   DynamicProxyHandler.showCount();
  }
} /* doSomething
Время вызова iface.doSomething() 139416
somethingElse bonobo
Время вызова  iface.somethingElse() 31779
Время вызова consumer(real) 217628
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
doSomething
Время вызова iface.doSomething() 264536
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@4aa298b7
 bonobo
somethingElse bonobo
Время вызова  iface.somethingElse() 214424
Время вызова consumer(proxy) 557868*///:~

class Test {}
interface Testable {}
public class Tester extends Test implements Testable{
  void One() {}
 public static void main(String[] args) {
 
  try {
    Class<?> c = Class.forName(args[0]);
  System.out.println(c.getAnnotatedInterfaces());
  System.out.println(c.getAnnotatedSuperclass());
  System.out.println(c.getAnnotations());
  System.out.println(c.getCanonicalName());
  System.out.println(c.getClasses());
  System.out.println(c.getClassLoader());
  System.out.println(c.getComponentType());
  System.out.println(c.getConstructors());
  System.out.println(c.getDeclaredClasses());
  System.out.println(c.getDeclaredConstructors());
  System.out.println(c.getDeclaredFields());
  System.out.println(c.getDeclaredMethods());
  System.out.println(c.getDeclaringClass());
  System.out.println(c.getEnclosingClass());
  System.out.println(c.getEnclosingConstructor());
  System.out.println(c.getEnclosingMethod());
  System.out.println(c.getEnumConstants());
  System.out.println(c.getFields());
  System.out.println(c.getGenericInterfaces());
  System.out.println(c.getGenericSuperclass());
  System.out.println(c.getInterfaces());
  System.out.println(c.getMethods());
  System.out.println(c.getModifiers());
  System.out.println(c.getModifiers());
  System.out.println(c.getPackage());
  System.out.println(c.getSigners());
  System.out.println(c.getSimpleName());
  System.out.println(c.getSuperclass());
  System.out.println(c.getTypeName());
  System.out.println(c.getTypeParameters());
  } catch(ClassNotFoundException e) {
   System.out.println("No such class: " + e); 
  }  
 }
}
// java Tester java.util.Scanner
// java Tester Tester
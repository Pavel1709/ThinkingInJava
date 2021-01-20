//: typeinfo/toys/ToyTest.java
// Testing class Class.
package typeinfo.toys;
import java.lang.reflect.*;
import static net.mindview.util.Print.*;
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
class Toy {
  // Comment out the following default constructor
  // to see NoSuchMethodError from (*1*)
  Toy() {}
  Toy(Integer i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
  FancyToy() { super(1); }
}
public class ToyTest {
  static void printInfo(Class<?> cc) {
   print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
   print("Simple name: " + cc.getSimpleName());
   print("Canonical name : " + cc.getCanonicalName()); 
  }
  public static void main(String[] args) { 
   Class<?> c = null;
   Class<?> cc = null;
   try {
    c = Class.forName("typeinfo.toys.FancyToy"); 
   } catch(ClassNotFoundException e) {
    print("Can’t find FancyToy");
    System.exit(1); 
   }
   try {
    cc = Class.forName("typeinfo.toys.Toy"); 
   } catch(ClassNotFoundException e) {
    print("Can’t find FancyToy");
    System.exit(1); 
   }
   printInfo(c);
   for(Class<?> face : c.getInterfaces())
    printInfo(face);
   Class<?> up = c.getSuperclass(); 
   Object obj = null;
   try {
     // Requires default constructor:
     obj = up.newInstance();
   } catch(InstantiationException e) {
    print("Cannot instantiate");
    System.exit(1);
   } catch(IllegalAccessException e) {
    print("Cannot access");
    System.exit(1); }
    printInfo(obj.getClass());
    /*
    Constructor<?> con;
    try{ 
      con = cc.getConstructor(Integer.class);
    }
    catch(Exception e) {
      throw new RuntimeException(e);   
    }
    try {
     Toy t = (Toy) con.newInstance(0);
    } catch(InstantiationException e) {
     print("Cannot instantiate");
     System.exit(1);
    } catch(IllegalAccessException e) {
     print("Cannot access");
     System.exit(1); }
    catch(Exception e) {
     System.out.println("Ошибка");
    }
    */
     Constructor<?>[] cs=typeinfo.toys.Toy.class.getConstructors();
       for(Constructor<?> ccs : cs){
          if(ccs.getParameterTypes().length==1){
             Class<?>[] paraType=ccs.getParameterTypes();
               if(paraType[0]==int.class){
                  try{
                    Object o=ccs.newInstance(1);
                  }catch(Exception e){
                    System.out.println(e);
                  } //переписал этот отрывок кода из интернета. Мой код выдает исключение. Почему - не понимаю(он в комментарии)
               }
            }
        }
  }
} /* Output:Class name: typeinfo.toys.FancyToy is interface? [false] Simple name: FancyToy
Canonical name : typeinfo.toys.FancyToy
Class name: typeinfo.toys.HasBatteries is interface? [true] Simple name: HasBatteries
Canonical name : typeinfo.toys.HasBatteries
Class name: typeinfo.toys.Waterproof is interface? [true] Simple name: Waterproof
Canonical name : typeinfo.toys.Waterproof
Class name: typeinfo.toys.Shoots is interface? [true] Simple name: Shoots
Canonical name : typeinfo.toys.Shoots
Class name: typeinfo.toys.Toy is interface? [false] Simple name: Toy
Canonical name : typeinfo.toys.Toy
*///:~
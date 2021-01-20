import one.*;
import java.lang.reflect.*;
import java.lang.Class;
public class letsFindClosed {
 public static void main(String[] args) throws Exception{
  withDifferentMods wdm = new withDifferentMods(3);
  Class c = wdm.getClass();
  Method[] meths = c.getDeclaredMethods();
  for (Method m : meths) {
   m.setAccessible(true);
   System.out.println(m);
   m.invoke(wdm);
  }
 }
}
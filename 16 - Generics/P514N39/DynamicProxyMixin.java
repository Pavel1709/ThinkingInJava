//: generics/DynamicProxyMixin.java 
import java.lang.reflect.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Tuple.*;
interface TimeStamped { 
 long getStamp(); 
}
class TimeStampedImp implements TimeStamped {
  private final long timeStamp;
  public TimeStampedImp() {
   timeStamp = new Date().getTime(); 
  }
  public long getStamp() { 
   return timeStamp; 
  }
}
interface Colored {
 String getColor();
}
class ColoredClass implements Colored {
 private final String color;
 private final String[] colors = new String[]{"Black"," Blue", "Yellow"," White"," Red"," Purple"," Orange"," Brown", "Violate", "Pink", "Green", "Grey", "Silver", "Gold"};
Random rand = new Random();
 public ColoredClass() {
  this.color = colors[rand.nextInt(colors.length - 1)];
 }
 public String getColor() {
  return color;
 }
}
interface SerialNumbered { 
 long getSerialNumber();
}
class SerialNumberedImp implements SerialNumbered { 
 private static long counter = 1;
 private final long serialNumber = counter++;
 public long getSerialNumber() { 
  return serialNumber; 
 }
}
interface Basic {
  public void set(String val);
  public String get();
}
class BasicImp implements Basic {
 private String value;
 public void set(String val) { 
  value = val; 
 } 
 public String get() { 
  return value;
 }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Colored {
 private TimeStamped timeStamp = new TimeStampedImp();
 private SerialNumbered serialNumber = new SerialNumberedImp();
 private Colored color = new ColoredClass();
 public long getStamp() { 
  return timeStamp.getStamp(); 
 } 
 public long getSerialNumber() {
  return serialNumber.getSerialNumber(); 
 }
 public String getColor() {
  return color.getColor();
 }
}
class Mixins {
 public static void main(String[] args) {
  Mixin mixin1 = new Mixin(), mixin2 = new Mixin(); 
  mixin1.set("test string 1");
  mixin2.set("test string 2"); 
  System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber()+ " "+ mixin1.getColor());   
  System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber()+ " " + mixin2.getColor());
 }
}
class MixinProxy implements InvocationHandler { 
 Map<String,Object> delegatesByMethod;
 @SuppressWarnings("unchecked")
 public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
  delegatesByMethod = new HashMap<String,Object>(); 
  for(TwoTuple<Object,Class<?>> pair : pairs) {
   for(Method method : pair.second.getMethods()) {
    String methodName = method.getName();
    // The first interface in the map
    // implements the method.
    if (!delegatesByMethod.containsKey(methodName))
     delegatesByMethod.put(methodName, pair.first);
   } 
  }
 }
 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
  String methodName = method.getName();
  Object delegate = delegatesByMethod.get(methodName);
  return method.invoke(delegate, args);
 }
 @SuppressWarnings("unchecked")
 public static Object newInstance(TwoTuple<Object,Class<?>>... pairs) {
  Class<?>[] interfaces = new Class<?>[pairs.length]; 
  for(int i = 0; i < pairs.length; i++) {
   interfaces[i] = (Class)pairs[i].second; 
  }
  ClassLoader cl = pairs[0].first.getClass().getClassLoader();
  return Proxy.newProxyInstance( cl, interfaces, new MixinProxy(pairs));
 } 
}
public class DynamicProxyMixin {
 @SuppressWarnings("unchecked")
 public static void main(String[] args) { 
  Object mixin = MixinProxy.newInstance( tuple(new BasicImp(), Basic.class), tuple(new TimeStampedImp(), TimeStamped.class), tuple(new  SerialNumberedImp(),SerialNumbered.class), tuple(new ColoredClass(), Colored.class));
  Basic b = (Basic)mixin;
  TimeStamped t = (TimeStamped)mixin; 
  SerialNumbered s = (SerialNumbered)mixin;
  Colored c = (Colored)mixin; 
  b.set("Hello"); 
  System.out.println(b.get());
  System.out.println(t.getStamp()); 
  System.out.println(s.getSerialNumber());
  System.out.println(c.getColor());
 }
}
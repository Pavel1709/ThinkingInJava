//: generics/ClassTypeCapture.java
import java.util.*;
import java.lang.reflect.*;
class Building {}
class House extends Building {}
interface Factory<T> {
  T create();
}
class Foo2<T> {
  private T x;
  public <F extends Factory<T>> Foo2(F factory) {
   x = factory.create();
  }
}
class IntegerFactory implements Factory<Integer> {
  public Integer create() {
    return new Integer(0);
  }
}
class BuildingFactory implements Factory<Building> {
  public Building create() {
    return new Building();
  }
}
public class ClassTypeCapture<T> {
 Class<T> kind;
 Map<String,Factory<T>> a = new HashMap<String,Factory<T>>();
 void addType(String typename, Factory<T> kind) {
  a.put(typename, kind);
 }
 Object createNew(String typename) throws IllegalArgumentException{
  if (!a.containsKey(typename)) {
    throw new IllegalArgumentException("I didn't find " + typename + " !");
  }

   return a.get(typename).create();

 }
 public ClassTypeCapture(Class<T> kind) {
  this.kind = kind; 
 }
 public boolean f(Object arg) { 
  return kind.isInstance(arg);
 }
 public static void main(String[] args) {
  ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
  System.out.println(ctt1.f(new Building())); 
  System.out.println(ctt1.f(new House())); 
  ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);   
  System.out.println(ctt2.f(new Building())); 
  System.out.println(ctt2.f(new House()));
  ctt1.addType("Building", new BuildingFactory());
  Building b =(Building) ctt1.createNew("Building");
 }
} 

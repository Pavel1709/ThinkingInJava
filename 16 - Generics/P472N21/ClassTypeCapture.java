//: generics/ClassTypeCapture.java
import java.util.*;
class Building {}
class House extends Building {}
public class ClassTypeCapture<T> {
 Class<T> kind;
 Map<String,Class<?>> a = new HashMap<String,Class<?>>();
 void addType(String typename, Class<?> kind) {
  a.put(typename, kind);
 }
 Object createNew(String typename) throws IllegalArgumentException{
  if (!a.containsKey(typename)) {
    throw new IllegalArgumentException("I didn't find " + typename + " !");
  }
  try{
   return a.get(typename).newInstance();
  }
  catch (InstantiationException e) {
   throw new RuntimeException(e);
  } catch (IllegalAccessException e) {
  throw new RuntimeException(e);
  }
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
  ctt1.addType("Building", Building.class);
  ctt1.addType("House", House.class);
  Building b =(Building) ctt1.createNew("Building");
  Integer i = (Integer)ctt1.createNew("Integer");
 }
} 
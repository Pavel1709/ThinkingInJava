import java.util.*;
import typeinfo.pets.*;
class Generic1<T> {
 T x;
 Generic1(T x) {
  this.x = x;
 }
 public void set(T x) {
  System.out.println(x);
  this.x = x;
 }  
}
class Generic2<T> {
 Generic2(T x) {
  this.x = x;
 }
 T x;
 public T get() {
  System.out.println(x);
  return x;
 }  
}
public class ContraVariant {
 public static <E> void m1(Generic1<? super E> t, E e) {
  t.set(e);
 }
 public static <E> void m2(Generic2<? extends E> t) {
  t.get();
 }
 public static void main(String[] args) {
     PetCreator creator = new ForNameCreator();
     m1(new Generic1<Object>(creator.randomPet()), creator.randomPet());
     m2(new Generic2<Pet>(creator.randomPet()));
 }
}

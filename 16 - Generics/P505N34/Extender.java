abstract class SelfBounded<T extends SelfBounded<T>> {
 T t;
 abstract T getAndSet(T t) ;
 T execute(T t) {
  return getAndSet(t);
 }
}
class Extender extends SelfBounded<Extender> {
 Extender getAndSet(Extender t) {
  this.t = t;
  return t;
 }
 public static void main(String[] args) {
  Extender ex = new Extender();
  ex.execute(ex);
  System.out.println(ex.execute(ex));
 }
}
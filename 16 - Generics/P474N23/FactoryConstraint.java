interface FactoryI<T> {
  T create(T x);
}
class Foo2<T> {
 private T x;
 public <F extends FactoryI<T>> Foo2(F factory, T i) {
  x = factory.create(i); 
 }
}
class IntegerFactory implements FactoryI<Integer> {
   @Override
  public Integer create(Integer i) {
    return new Integer(i);
  }
}
class Widget {
  public static class Factory implements FactoryI<Widget> {
    @Override
    public Widget create(Widget w) {
      return new Widget();
    } 
  }
}
public class FactoryConstraint {
  public static void main(String[] args) {
      Foo2<Integer> foo2 = new Foo2<Integer>(new IntegerFactory(), 7);
      Foo2<Widget> foo21 = new Foo2<Widget>(new Widget.Factory(), new Widget()); 
      System.out.println(foo2);
      System.out.println(foo21);
  }
}
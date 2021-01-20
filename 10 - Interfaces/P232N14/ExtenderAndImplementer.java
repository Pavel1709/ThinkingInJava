interface One {
 void first();
 void second();
}
interface Two {
 void third();
 void fourth();
}
interface Three {
 void fifth();
 void sixth();
}
interface Four extends One, Two, Three {
 void seventh();
}
class FirstClass {
 void FirstClassMeth() {}
}
public class ExtenderAndImplementer extends FirstClass implements Four  {
  public void first() {}
  public void second() {}
  public void third() {}
  public void fourth() {}
  public void fifth() {}
  public void sixth() {}
  public void seventh() {}
  static void methOne(One o) {}
  static void methTwo(Two t) {}
  static void methThree(Three th) {}
  static void methFour(Four f) {}
  public static void main(String[] args) {
   ExtenderAndImplementer e = new ExtenderAndImplementer();
   methOne(e);
   methTwo(e);
   methThree(e);
   methFour(e);
  }
}
interface Base {
  void methOne();
}
interface ExtenderOne extends Base {
  void methOneOne();
}
interface ExtenderTwo extends Base,ExtenderOne  {
   void methOneTwo();
}
public class Realizer implements Base, ExtenderOne, ExtenderTwo {
 public void methOne() {}
 public void methOneOne() {}
 public void methOneTwo() {}
 static Realizer r = new Realizer();
 public static void Real() {
  r.methOneTwo();
  r.methOneOne();
  r.methOne();
 }
 public static void main(String[] args) {
  Real();
 }
}

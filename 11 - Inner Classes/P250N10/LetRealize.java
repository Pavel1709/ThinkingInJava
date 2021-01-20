interface First {
 void f();
 void g();
}
public class LetRealize  {
  public First m() {
   if(1 > 0) {
    class Realizator implements First {
     public void f() {
      System.out.println("First.f()");
     }
     public void g() {
      System.out.println("First.g()");
     }
    }
    
   return new Realizator();
  }
   return null;
   
  }
  public static void main(String[] args) {
    LetRealize lr = new LetRealize();
    First ff = lr.m();
    ff.f();
    ff.g();
  }
}
    
interface First {
 void f();
 void g();
}
public class LetRealize  {
  public First m() {
   return new First(){
    public void f() {
     System.out.println("First.f()");
    }
    public void g() {
     System.out.println("First.g()");
    }
   };
   
  }
  public static void main(String[] args) {
    LetRealize lr = new LetRealize();
    First ff = lr.m();
    ff.f();
    ff.g();
  }
}
    
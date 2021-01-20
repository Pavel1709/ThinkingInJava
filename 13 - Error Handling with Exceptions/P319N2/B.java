class A {
 void t() {
  System.out.println("A.t()");
 }
}
public class B{
 public static void main(String[] args) {
  A a = null;
   //! a.t();
  try{ 
    a.t();
  }
  catch(Exception e) {
   System.out.println("Ссылка пуста");
  }
 }
}
class ExceptionOne extends Exception {}
class ExceptionTwo extends ExceptionOne {}
class ExceptionThree extends ExceptionTwo {}
class A {
 void execute() throws ExceptionOne {
  throw new ExceptionOne();
 }
}
class B extends A {
 void execute() throws ExceptionTwo {
  throw new ExceptionTwo();
 }
}
class C extends B {
 void execute() throws ExceptionThree {
  throw new ExceptionThree();
 }
}
public class Executor {
 public static void main(String[] args) {
  A x = new C();
  try{
   x.execute();
  }
  catch(ExceptionThree e) {
   System.out.println("ExceptionThree перехвачено");
  }
  catch(ExceptionTwo e) {
   System.out.println("ExceptionTwo перехвачено");
  }
  catch(ExceptionOne e) {
   System.out.println("ExceptionOne перехвачено");
  }
 }
}
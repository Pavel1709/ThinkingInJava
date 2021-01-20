interface OpenedInter {
 void f();
 void g();
}
public class OpenedOuter {

 private class ClosedInner implements OpenedInter {
  public void f() {
   System.out.println("OpenedInter.f()") ;
  }
  public void g() {
   System.out.println("OpenedInter.g()") ;
  }
  void another() {
   System.out.println("Hi");
  }
 }
 OpenedInter returning() {
  return new ClosedInner();
 }
 public static void main(String[] args) {
  OpenedOuter oo = new OpenedOuter();
  OpenedInter oi = oo.returning(); //высходящее
  ClosedInner ci = (ClosedInner) oo.returning(); ///нисходящее
  ci.f();
  ci.another();
  oo.returning().f();
  ((ClosedInner)oo.returning()).f(); //автор решения обещает ту ошибкуБ однако ее не происходит. Автор книги тоже намекает на то, что тут должно произойти что-то типа ошибки. Так в чем же дело? 
 }
}
//Выполнено нисходящее преобразование к закрытому внутреннему классу, однако методы из него доступны, непонятно, что автор хотел этим показать. Либо же я неправильно понял и выполнил задачу.
//Я посмотрел решение в интрнете. Автор решения тоже делает нисходящее преобразование. Однако в том месте, где он обещает ошибку, ее не происходит.
/*
// innerclasses/Ex11.java
// TIJ4 Chapter Innerclasses, Exercise 11, page 356
/* Create a private inner class that implements a public interface.
* Write a method that returns a reference to an instance of the private
* inner class, upcast to the interface. Show that the inner class is 
* completely hidden by trying to downcast to it.
*/

/* public interface Ex11Interface {
*	void say(String s); 
* }
*/

class Test {
	private class Inner implements Ex11Interface {
		public void say(String s) {
			System.out.println(s); 
		}
	}
	Ex11Interface f() {
		return new Inner();
	}
}
public class Ex11 {	
	public static void main(String[] args) {
		Test t = new Test();
		t.f().say("hi");
		// Error: cannot find symbol: class Inner:
		// ((Inner)t.f()).say("hello");
	} 
}
/*
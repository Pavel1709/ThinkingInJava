class Construct {
 Construct(){
  System.out.println("Construct");
 }
}
public class Extender extends Construct {
 Extender() {
  System.out.println("Extender");
 }

 public static void main(String[] args) {
  Extender ex = new Extender(); // пункт b - сначала сработает конструктор Construct(), а уже только потом Extender()
 }
}
  //Я не понимаю пункт а. Что значит-"покажите, что конструктор базового класса всегда вызывается"? Как же это показать, если он не будет вызываться без создания экземпляра класса наследника,например, или без создания экземпляра класса его самого? Я почитал в интернете, что люди пишут, там, ка мне показалось, тоже написан полный бред:
/*
class A
{
  public A()
  {
    System.out.println( "Super class constructor" );
  }
}
public class B extends A
{
  /*
   * Having constructors with prints will show super before sub
   * Remove both constructors to prove always called (compiler default). //PM>>> И что это нам дает? Н уберем мы два конструктора B? Конструктор А так или иначе без создания экземпляра вызываться не будет.
   */
/*
  public B()
  {
    this( 10 );
  }
  public B( int i )
  {
    System.out.println( "Sub class constructor" );
  }
  public static void main( String[] arg )
  {
    B b = new B();
  }
}

*/


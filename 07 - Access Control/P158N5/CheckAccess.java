public class CheckAccess {
 public static void main(String[] args) {
  Access ac = new Access();
   System.out.println("i1 though main" + ac.i1); //получится, так как i1 public
   System.out.println("i2 though main" + ac.i2); //получится, так как i2 protected, те действует в пределах пакета
   System.out.println("i3 though main" + ac.i3); //получится, так как i3 default , те действует в пределах пакета
   //  System.out.println("i4 though main" + ac.i4); // не получится, так как i4 private, те действует в пределах класса
   System.out.println();
   ac.meth1(); //получится, так как meth1() public
   ac.meth2(); //получится, так как meth2() protected, те действует в пределах пакета
   ac.meth3(); //получится, так как meth3() default , те действует в пределах пакета
   // ac.meth4(); // не получится, так как meth4() private, те действует в пределах класса
 }
}
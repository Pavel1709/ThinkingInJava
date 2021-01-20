public class Closed {
 private int i = 8;
 private int getI() {
  return i;
 }
 IntClosed f() {
  return new IntClosed(){
   {
    System.out.println(i);
    i++;
    getI();
    System.out.println(i);
   }
  };
 } 
 public static void main(String[] args) {
  Closed closed = new Closed();
   closed.f();
 }
}
interface IntClosed {
}
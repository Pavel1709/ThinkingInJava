public class Closed {
 private int i = 8;
 private int getI() {
  return i;
 }
 class IntClosed{
  public void ChangeI() {
   System.out.println(i);
   i++;
   getI();
   System.out.println(i);
  }
 }
 public void obj() {
  IntClosed intc = new IntClosed();
  intc.ChangeI();
  System.out.println(i);
 }
 public static void main(String[] args) {
  Closed closed = new Closed();
   closed.obj();
 }
}
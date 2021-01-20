abstract class WithoutStandCons {
 static int i;
 WithoutStandCons(int i) {
  this.i = i;
 }
}
public class Returner {
 WithoutStandCons ret(int i) {
  return new WithoutStandCons(i){
   {System.out.println("Ссылка вернулась "); }
  };
 }
 public static void main(String[] args) {
  Returner r = new Returner(); 
  r.ret(5);
  System.out.println(WithoutStandCons.i);
 }
}

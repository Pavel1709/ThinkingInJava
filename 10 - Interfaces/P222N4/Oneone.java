abstract class One {
 
}
public class Oneone extends One {
 static void link(One o) {
  System.out.println("One");
 }
 public static void main(String[] args) {
  
  Oneone oo = new Oneone();
   Oneone.link((One)oo);

 }
}
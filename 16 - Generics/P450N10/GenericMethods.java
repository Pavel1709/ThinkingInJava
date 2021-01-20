public class GenericMethods {
 public  void f(Object x ) {
  System.out.println(x.getClass().getName());  
 }
 public static void main(String[] args) {
  GenericMethods gm = new GenericMethods(); 
   gm.f((Object)"");
   gm.f((Object)1);
   gm.f((Object)1.0); 
   gm.f((Object)1.0F); 
   gm.f((Object)'c'); 
   gm.f((Object)gm);
 }
}
import java.util.*;
 
class Candy {
 static { System.out.println("Loading Candy"); }
}
class Gum {
 static { System.out.println("Loading Gum"); } 
}
class Cookie {
 static { System.out.println("Loading Cookie"); }
}
public class SweetShop {
  public static void main(String[] args) {
    System.out.println("inside main");
    Scanner s = new Scanner(System.in);
    String cls = s.nextLine();
    while(cls.equals("Candy") || cls.equals("Gum") || cls.equals("Cookie")) {
     try {
       Class.forName(cls);
     }
     catch(ClassNotFoundException e) {
      System.out.println("Couldn’t find " + cls); 
     }
     System.out.printf("After Class.forName(\"%s\") \n" , cls); 
      cls = s.nextLine();
     }
    }

} /* Output:
inside main
Loading Candy
After creating Candy Loading Gum
After Class.forName("Gum") Loading Cookie
After creating Cookie *///:~
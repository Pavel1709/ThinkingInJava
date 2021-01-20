import java.util.*;
public class Gerbil {
 public int gerbilNumber;
 Gerbil(int gerbilNumber) {
  this.gerbilNumber = gerbilNumber;
 }
 void hop() {
  System.out.println("gerbilNumber: " + gerbilNumber);
 }
 static Map<Gerbil, String> gerbils = new HashMap<Gerbil, String>();
 static List<String> gerbilsNames = new ArrayList<String>(Arrays.asList("Tom", "Jack", "Ivan", "Bob", "John", "Jipsy", "Jholy", "Ginger", "Anton" , "Anya"));
 public static void main(String[] args) {
  for (int i = 0; i < 10; i++) {
   gerbils.put(new Gerbil(i), gerbilsNames.get(i) );
  }
  Iterator<Gerbil> it = gerbils.keySet().iterator();
  int i = 0;
  while(it.hasNext()) {
      
     Gerbil g = it.next();
     System.out.println(gerbilsNames.get(i));
     g.hop();
     i++;
  }

 }
}
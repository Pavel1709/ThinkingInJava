import java.util.*;
public class Gerbil {
 public int gerbilNumber;
 Gerbil(int gerbilNumber) {
  this.gerbilNumber = gerbilNumber;
 }
 void hop() {
  System.out.println("gerbilNumber: " + gerbilNumber);
 }
 static ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
 
 public static void main(String[] args) {
  
  for (int i = 0; i < 10; i++) {
   gerbils.add(new Gerbil(i));
  }
  Iterator<Gerbil> it = gerbils.iterator();
  while (it.hasNext()) {
   Gerbil g = it.next();
   System.out.println(g);
   g.hop();
  }
 }
}
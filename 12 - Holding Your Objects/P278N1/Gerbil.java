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
  for(Gerbil g: gerbils) {
   System.out.println(g);
   g.hop();
  }
 }
}
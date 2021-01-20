import java.util.*;
public class Slim {
 public enum States {
  GOOD, NORMAL, NOT_OK, BAD
 }
 public String s;
 private static int counter = 0;
 private final int id = counter++;
 Random r = new Random();
 int l;
 public Slim() {
  l = r.nextInt(4);
  switch(l) {
   case 0: s = States.GOOD.toString();
   break;
   case 1: s = States.NORMAL.toString();
   break;
   case 2: s = States.NOT_OK.toString();
   break;
   case 3: s = States.BAD.toString();
   break;
  }
 }
 public void operation() { System.out.println(this); }
 public String toString() { return "Slim id: " + id + " Slim state: " + s; }
}
  
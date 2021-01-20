import java.util.*;
public class Stringer {
 static int a = 5;
 static long b = 5000000000l;
 static float c = 5.55f;
 static double d = 555.555;
 public String toString() {
  return(String.format("%d %d  %f %f", a, b, c, d));
 }
 public static void main(String[] args) {
  Stringer str = new Stringer();
  System.out.println(str);
  System.out.println(String.format("%x %x  %e %e", a, b, c, d));
  Formatter stb = new Formatter(System.out);
  stb.format("%x %x  %e %e", a, b, c, d);
 }
}
import java.math.*;
import java.util.*;
public class Conversion {
 public static void main(String[] args) {
  Formatter f = new Formatter(System.out);
  char u ='a';
  f.format("%5s %5S %5c %5C %5b %5B %5h %5H" , u, u, u, u, u, u, u, u);
  int v = 121;
  f.format("%5s %5S %5d %5x %5X   %5c %5C %5b %5B %5h %5H" ,   v, v, v, v, v, v, v, v, v, v, v);
  BigInteger w = new BigInteger("5000000000000");
  f.format("%5s %5S %5d %5x %5X %5b %5B %5h %5H" ,   w, w, w, w, w, w, w, w, w);
  double x = 179.543;
  f.format("%5s %5S %5e %5E %5f   %5b %5B %5h %5H" , x , x, x, x, x, x, x, x, x);
  Conversion con = new Conversion();
  f.format("%5s %5S %5b %5B %5h %5H" , con, con, con, con, con, con);
  boolean z = false;
  f.format("%5s %5S  %5b %5B %5h %5H" , z, z, z, z, z, z);
 }
}
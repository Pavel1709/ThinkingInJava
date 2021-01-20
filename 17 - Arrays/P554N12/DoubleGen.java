import net.mindview.util.CountingGenerator;
import net.mindview.util.*;
import java.util.*;
public class DoubleGen {
 public static void main(String[] ags) {
  double[] d = new double[10];
  Generator<Double> g = new CountingGenerator.Double();
   for (int i = 0; i < d.length; i++) {
    d[i] = g.next();
   }
   System.out.println(Arrays.toString(d));
 }
}
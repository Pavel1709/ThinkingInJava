import java.math.*;
import java.lang.*;
import java.util.*;
import net.mindview.util.*;
interface SkipGenerator<T> extends net.mindview.util.Generator<T> {
 T next();
}
public class BigDecimalGenerator {
 static class BigDecimal implements SkipGenerator<java.math.BigDecimal> {
  private java.math.BigDecimal value = new java.math.BigDecimal("0.0");
  double result = value.doubleValue();
  public java.math.BigDecimal next() {
   result += 1.0;
   return new java.math.BigDecimal(result);
  } 
 }
 public static void main(String[] args) {
  java.math.BigDecimal[] b = new java.math.BigDecimal[5];
  b = Generated.array(b, new BigDecimalGenerator.BigDecimal());
  System.out.println(Arrays.toString(b));
  java.math.BigDecimal[] c;
  c = Generated.array(java.math.BigDecimal.class, new BigDecimalGenerator.BigDecimal(), 25);
  System.out.println(Arrays.toString(c));
 }
}
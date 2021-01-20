// Test the tools that use generators to fill arrays. 
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public class TestArrayGeneration {
  public static void main(String[] args) {
   int size = 6;
   boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class, new SkipGenerator1.Boolean(true), size));
   print("a1 = " + Arrays.toString(a1));
   byte[] a2 = ConvertTo.primitive(Generated.array( Byte.class, new SkipGenerator1.Byte((byte)4), size)); 
   print("a2 = " + Arrays.toString(a2));
   char[] a3 = ConvertTo.primitive(Generated.array(Character.class, new SkipGenerator1.Character(5), size)); 
   print("a3 = " + Arrays.toString(a3));
   short[] a4 = ConvertTo.primitive(Generated.array( Short.class, new SkipGenerator1.Short((short)1), size)); 
   print("a4 = " + Arrays.toString(a4));
   int[] a5 = ConvertTo.primitive(Generated.array( Integer.class, new SkipGenerator1.Integer(55), size)); 
   print("a5 = " + Arrays.toString(a5));
   long[] a6 = ConvertTo.primitive(Generated.array( Long.class, new SkipGenerator1.Long(45), size));
   print("a6 = " + Arrays.toString(a6));
   float[] a7 = ConvertTo.primitive(Generated.array( Float.class, new SkipGenerator1.Float(5.55f), size)); 
   print("a7 = " + Arrays.toString(a7));
   double[] a8 = ConvertTo.primitive(Generated.array( Double.class, new SkipGenerator1.Double(7.55), size)); 
   print("a8 = " + Arrays.toString(a8));
  }
}
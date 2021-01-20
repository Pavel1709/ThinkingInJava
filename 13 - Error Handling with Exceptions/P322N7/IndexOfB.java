import java.util.logging.*;
import java.io.*;
public class IndexOfB  {
  private static Logger logger = Logger.getLogger("IndexOfB");
   public static void logEx(Exception e) {
   StringWriter trace = new StringWriter();
   e.printStackTrace(new PrintWriter(trace));
   logger.severe(trace.toString());
  }
 public static void main(String[] args) {
  Integer[] is = new Integer[9];
  try {
   for (int i = 0; i <10; i++) {
    is[i] = i;
   }
  }
  catch(ArrayIndexOutOfBoundsException iob) {
   System.out.println("Вы пытаетесь работать с несуществующим элементом массива");
   logEx(iob);
  }
 }
}
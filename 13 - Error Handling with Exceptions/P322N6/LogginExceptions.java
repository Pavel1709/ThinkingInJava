import java.util.logging.*;
import java.io.*;

class FirstEx extends Exception {
 private static Logger logger = Logger.getLogger("FirstEx");
 public FirstEx() {
  StringWriter trace = new StringWriter();
  printStackTrace(new PrintWriter(trace));
  logger.severe(trace.toString());
 }
}
class SecondEx extends Exception {
 private static Logger logger = Logger.getLogger("SecondEx");
 public SecondEx() {
  StringWriter trace = new StringWriter();
  printStackTrace(new PrintWriter(trace));
  logger.severe(trace.toString());
 }
}
public class LogginExceptions {
 public static void main(String[] args) {
  try{
   throw  new FirstEx();
  }
  catch(FirstEx f) {
   System.out.println("Обработано иск1");
  }
  try{
   throw  new SecondEx();
  }
  catch(SecondEx f) {
   System.out.println("Обработано иск2");
  }
 }
}
 
   
   
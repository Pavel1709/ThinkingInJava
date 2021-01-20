//: exceptions/LostMessage.java 
// How an exception can be lost.
class VeryImportantException extends Exception {
  public String toString() {
  return "A very important exception!";
 }
}
class HoHumException extends Exception {
  public String toString() {
   return "A trivial exception"; 
  }
}
class ThirdException extends Exception {
  public String toString() {
   return "The third exception"; 
  }
}
public class LostMessage {
  void f() throws VeryImportantException {
    throw new VeryImportantException();
  }
  void dispose() throws HoHumException {
    throw new HoHumException();
  }
  void third() throws ThirdException {
   throw new ThirdException();
  }
  public static void main(String[] args) {
   try {
    LostMessage lm = new LostMessage();
    try {
     lm.f(); 
    } 
    finally {
     try{ 
      lm.dispose(); 
     }
     finally {
      lm.third();
     }
     lm.dispose(); 
    }
   } 
   catch(Exception e) {
    System.out.println(e); 
   }
  }
} /* Output:
A trivial exception *///:~
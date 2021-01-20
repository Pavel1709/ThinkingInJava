public class VozbCheck {
 public static void main(String[] args) throws NewException {
  try {
   throw new NewException("ok");
  }
  catch (NewException ne) {
   ne.v();
  } 
 
 }
}
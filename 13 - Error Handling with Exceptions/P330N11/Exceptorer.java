class NewException extends Exception{}
class AnotherException  extends Exception{}
public class Exceptorer {
 public void g() throws NewException {
  throw new NewException();
 }
 public void f() throws RuntimeException{
  try{
   g();
  }
  catch(NewException ne) {
   //AnotherException ae = new AnotherException();
   //ae.initCause(ne);
   throw new RuntimeException(ne);
  }
 }
 public static void main(String[] args)  {
  try{
  Exceptorer exe = new Exceptorer();
  exe.f();
  }
  catch(RuntimeException aee){
   aee.printStackTrace(System.out);
  }
   //catch(NewException nee){
   // nee.printStackTrace(System.out);
   //}
 }
}
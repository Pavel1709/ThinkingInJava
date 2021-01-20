class NewException extends Exception{}
class AnotherException  extends Exception{}
public class Exceptor {
 public void g() throws NewException {
  throw new NewException();
 }
 public void f() throws AnotherException{
  try{
   g();
  }
  catch(NewException ne) {
   AnotherException ae = new AnotherException();
   ae.initCause(ne);
   throw  ae;
  }
 }
 public static void main(String[] args)  {
  try{
  Exceptor exe = new Exceptor();
  exe.f();}
  catch(AnotherException aee){
   aee.printStackTrace(System.out);
  }
  //catch(NewException nee){
  // nee.printStackTrace(System.out);
  //}
 }
}
class ExceptionOne extends Exception {

}
class ExceptionTwo extends Exception {
 ExceptionTwo(Exception e) throws Exception {
     throw e;
 }
}
class ExceptionThree extends Exception{
 ExceptionThree(Exception e) throws Exception {
     throw e;
 }
}
public class AllTheCatcher {
 public void vozb() throws ExceptionTwo, ExceptionOne, ExceptionThree, Exception   {
     throw new ExceptionTwo(new ExceptionThree(new ExceptionOne())) ;
 }
 public static void main(String[] args) {
  AllTheCatcher a = new AllTheCatcher();
  try {
   a.vozb();
  }
  catch( Exception  e) {
   System.out.println(" перехвачено");
  }
 }
}

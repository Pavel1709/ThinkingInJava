class ExecptionOne extends Exception {}
public class FallingConstructor {
 FallingConstructor() throws ExecptionOne {
  throw new ExecptionOne();
 }
 public static void main(String[] args) {
  try {
   FallingConstructor fc = new FallingConstructor();
  }
  catch(ExecptionOne e){
   System.out.println("Перехвачено");
  }
 }
}
class ExecptionOne extends Exception {}
public class FallingConstructor {
 withDisp wd;
 FallingConstructor() throws ExecptionOne {
  try {
   wd = new withDisp();
   throw new ExecptionOne();
  }
  catch(ExecptionOne e) {
   System.out.println("Перехвачено ExecptionOne ");
  }
  catch(Exception e) {
   System.out.println("Перехвачено ");
  }
  try {
  withDisp wdw = new withDisp();
   try {
    wdw.dispose();   
   }
   catch(Exception e) {
    System.out.println("Перехвачено ");
   }
  }
  catch(Exception e) {
   System.out.println("Перехвачено ");
  }
 }
 public void dispose() {
   System.out.println("Освобождено FallingConstructor.dispose");
 }
 public static void main(String[] args) {
  try {
   FallingConstructor fc = new FallingConstructor();
   try {
    fc.dispose();
   }  
   catch(Exception e) {
    System.out.println("Перехвачено fc.dispose()");
   }
  }
  catch(ExecptionOne e){
   System.out.println("Перехвачено ExecptionOne");
  }
  catch(Exception e) {
   System.out.println("Перехвачено ");
  }
 }
}
class withDisp {
 public void dispose() {
  System.out.println("Освобождено");
 }
}
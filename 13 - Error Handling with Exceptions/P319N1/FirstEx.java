
public class FirstEx {
 public static void main(String[] args) throws Exception{
  try {
   throw new Exception("this.");
  }
  catch(Exception e) {
    e.printStackTrace( );
  }
  finally {
   System.out.print("Caught");
  }
 }
}
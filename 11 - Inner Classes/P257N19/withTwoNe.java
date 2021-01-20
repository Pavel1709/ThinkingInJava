public class withTwoNe {
 static class FirstNe {
  static class SecondNe {
  }
   static SecondNe returning2() {
    return new SecondNe();
   }
 } 
 static FirstNe returning1() {
  return new FirstNe();
 }

 public static void main(String[] args) {
  FirstNe f = new FirstNe();
  FirstNe.SecondNe s = new FirstNe.SecondNe(); 
 }
}
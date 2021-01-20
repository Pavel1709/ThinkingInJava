public class withTwoIn {
 class FirstInner {
  class SecondInner {
  }
   SecondInner returning2() {
    return new SecondInner();
   }
 } 
 FirstInner returning1() {
  return new FirstInner();
 }

 public static void main(String[] args) {
  withTwoIn w1 = new withTwoIn();
  withTwoIn.FirstInner fi = w1.returning1();
  withTwoIn.FirstInner.SecondInner se = fi.returning2();
 }
}
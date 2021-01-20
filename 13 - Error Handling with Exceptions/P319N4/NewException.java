class NewException extends Exception {
 String s;
 NewException(String s) {
  this.s = s;
 }
 void v() {
  System.out.println(s);
 }
 public static void main(String[] args) {
  try {
   throw new NewException("ok");
  }
  catch (NewException n) {
   n.v();
  } 
 }
}
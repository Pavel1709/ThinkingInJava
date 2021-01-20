class NewException extends RuntimeException {
 String s;
 NewException(String s) {
  this.s = s;
 }
 void v() {
  System.out.println(s);
 }
 public static void main(String[] args) {
   NewException n = new NewException("ok");
   n.v();
   throw new NewException("ok");
 }
}
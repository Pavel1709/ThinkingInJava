public class Covariant {
 public static void main(String[] args) {
  Number[] is = new Integer[5];
   for (int i = 0; i < 5; i ++) {
    is[i] = (new Integer(i));
    System.out.println(is[i]);
  }
 }
}
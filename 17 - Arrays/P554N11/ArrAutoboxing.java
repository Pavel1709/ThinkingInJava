public class ArrAutoboxing {
 public static void main(String args) {
  Integer[] i = new Integer[5];
  int[] ii = new int[5];
  ii[1] = i[1]; //работает
  i[1] = ii[1]; 
  i = ii; //не работает
  ii = i; // автораспаковка тоже не работает
 }
}
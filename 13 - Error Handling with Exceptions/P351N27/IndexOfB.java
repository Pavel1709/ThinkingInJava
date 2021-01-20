import java.util.*;
public class IndexOfB {
 public static void main(String[] args) {
  Integer[] is = new Integer[9];
  try {
   for (int i = 0; i <10; i++) {
    is[i] = i;
   }
  }
  catch(Exception iob) {
   throw new RuntimeException(iob);
  }
 }
}
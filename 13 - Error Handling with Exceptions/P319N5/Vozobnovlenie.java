import java.util.*;
public class Vozobnovlenie {
 public static void main(String[] args) {
  ArrayList<String> vs = new ArrayList<String>();
  boolean b = true;
  while (b) {
   try {
    for (int i = 0; i < 5; i++) {
     System.out.println(vs.get(i));
    }
     b = false;
   }
   catch(IndexOutOfBoundsException ioo) {
    String s = "Вы пытаетесь обратиться к элементу за рамками контейнера";
    System.out.println(s);
    vs.add("ok"); 
   }
  }
 }
}

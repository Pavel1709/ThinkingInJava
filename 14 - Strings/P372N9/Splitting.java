import java.util.*;

public class Splitting {
 public static String knights = "Then, when you have found the shrubbery, you must " + "cut down the mightiest tree in the forest... " + "with... a herring!";
 public static void split(String regex) {
  System.out.println(knights.replaceAll("[A|E|I|O|U|a|e|i|o|u]" , regex));
 }
 public static void main(String[] args) {
  split("_");
 }
}
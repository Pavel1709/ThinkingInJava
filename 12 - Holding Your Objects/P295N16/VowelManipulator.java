import java.util.*;
import net.mindview.util.*;

public class VowelManipulator {
 static Set<String> vowels = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
 static int amountOfVow = 0;
 static int amountOfVowInFile = 0;
 static Set<String> wordsInFile = new TreeSet<String>(new TextFile("VowelManipulator.java", "\\W+"));
 public static void main(String[] args) {
  Collections.addAll(vowels, "A E I O U".split(" "));
  System.out.println("Введите слово(На английском), в отором хотите подсчитать гласные буквы");
  Scanner s = new Scanner(System.in);
  String word = s.nextLine();
  for (String ss: word.split("")) {
   if (vowels.contains(ss)) {
    amountOfVow++;
   }
  }
  System.out.println("Количество гласных в вашем слове:" + amountOfVow);
  for (String sss: wordsInFile) {
   for(String v: vowels) {
    if ( sss.contains(v)) {
      amountOfVowInFile++;
    }
   }
  }
  System.out.println(wordsInFile);
  System.out.println(amountOfVowInFile);
 }
}
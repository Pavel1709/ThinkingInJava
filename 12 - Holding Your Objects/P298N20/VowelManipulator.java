import java.util.*;
import net.mindview.util.*;
public class VowelManipulator {
 static Set<String> vowels = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
 static int amountOfVow = 0;
 static int amountOfVowInFile = 0;
 static Set<String> wordsInFile = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
 public static void main(String[] args) {
  wordsInFile.addAll(new TextFile("VowelManipulator.java", "\\W+"));
  Collections.addAll(vowels, "A E I O U".split(" "));
  HashMap<String, Integer> occurance = new HashMap<String, Integer>();
  for(String s: vowels) {
   occurance.put(s, 0);
  }
  System.out.println("Введите слово(На английском), в котором хотите подсчитать гласные буквы");
  Scanner sc = new Scanner(System.in);
  String word = sc.nextLine();
  for (String ss: word.split("")) {
   if (vowels.contains(ss) || vowels.contains(ss.toLowerCase())|| vowels.contains(ss.toUpperCase())) {
    amountOfVow++;
    occurance.put(ss, (occurance.get(ss.toUpperCase()))+1);
   }
  }
  System.out.println("Количество гласных в вашем слове:" + amountOfVow);
  for (String sss: wordsInFile) {
   for(String v: vowels) {
    if ( sss.contains(v) || sss.contains(v.toLowerCase()) || sss.contains(v.toUpperCase())) {
      amountOfVowInFile++;
      occurance.put(v, (occurance.get(v.toUpperCase()))+1);
    }
   }
  }
  System.out.println(wordsInFile);
  System.out.println(amountOfVowInFile);
  System.out.println(occurance);
 }
}
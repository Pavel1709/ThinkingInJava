import java.util.*;
import net.mindview.util.*;
public class WordCounting {
 static Map<String, Integer> words = new HashMap<String, Integer>();
 static List<String> wordsFromFile = new ArrayList<String>( );
 public static void main(String[] args) {
  wordsFromFile.addAll(new TextFile("WordCounting.java", "\\W+"));
  for (String s: wordsFromFile) {
   words.put(s, 0);
  }

  for (int i = 0; i < wordsFromFile.size(); i++){
   words.put(wordsFromFile.get(i), (words.get(wordsFromFile.get(i)))+1);
  }
  System.out.println(words);


 }
}
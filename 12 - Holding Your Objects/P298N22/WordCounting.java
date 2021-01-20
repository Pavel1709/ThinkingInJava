import java.util.*;
import net.mindview.util.*;
public class WordCounting {
 static Set<Worder> words = new LinkedHashSet<Worder>();
 static List<String> wordsFromFile = new ArrayList<String>( );
 public static void main(String[] args) {
  wordsFromFile.addAll(new TextFile("WordCounting.java", "\\W+"));
  for (String s: wordsFromFile) {
   words.forEach(d -> {
    if (d.w.equals(s)) {
     d.i = d.i + 1;
    }
   });
    words.add(new Worder(s));
  }
  for(Worder ww: words) {
   for(Worder www: words) {
     if (ww.w.equals(www.w) && (ww.i < www.i)) {
       ww.i = 0;
     }
   }
  }
  Set<Worder> wordsCopy = new LinkedHashSet<Worder>();
  for(Worder ss: words) {
   if (ss.i>0) {
    wordsCopy.add(ss);
   }
  }
    for(Worder s: wordsCopy ) {
   
   System.out.println(s.w+ " " + s.i);
  }

 }
}
class Worder {
 
 String w;
 int i;
 Worder(String w) {
   this.w = w;
   i++;
 }
}
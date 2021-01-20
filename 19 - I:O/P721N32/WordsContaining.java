import java.util.*;
import nu.xom.*;
import java.io.*;

public class WordsContaining {
 public static void main(String[] args) throws Exception, FileNotFoundException{
  ArrayList<String> words = new ArrayList<String>(new TextFile("WordsContaining.java", "\\W+"));
  System.out.println(words);
  System.out.println(countWords(words)); 
  HashMap<String,Integer> map =countWords(words);
  Element root = new Element("program");
  
  for(Map.Entry<String, Integer> pair : map.entrySet()) {
   Element  wordAndAmount = new Element("wordAndAmount"); 
   Element word = new Element("word"); 
   word.appendChild(pair.getKey());
   Element amount = new Element("amount");
   amount.appendChild(pair.getValue().toString());
   wordAndAmount.appendChild(word);
   wordAndAmount.appendChild(amount);
   root.appendChild(wordAndAmount);
  }
  Document doc = new Document(root);
  Person.format(System.out, doc);
  Person.format(new BufferedOutputStream(new FileOutputStream("Words.xml")), doc);
 }
 public static HashMap<String,Integer> countWords(ArrayList<String> a) {
  HashMap<String,Integer> map = new HashMap<String,Integer>();
  for(String w: a) {
   if (!map.keySet().contains(w)) {
    map.put(w , 1);
   }
   else {
    map.put(w , map.get(w) + 1);
   }
  }
  return map;
 }
 
}
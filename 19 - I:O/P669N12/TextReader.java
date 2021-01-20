import java.io.*;
import java.util.*;
public class TextReader {
 public static void main(String[] args) throws IOException{
  List<String> textList = new LinkedList<String>();
  BufferedReader in = new BufferedReader(new FileReader(args[0]));
  String s;
  while((s = in.readLine()) != null) {
   textList.add(s);
  }
  String file = "TextReader.out";
  PrintWriter out = new PrintWriter(file);
  in.close();
  ListIterator<String> it = textList.listIterator(textList.size());
  while (it.hasPrevious()) {
   System.out.println(it.previous());
  }
  System.out.println("_________________________________________");
  int linecount = 1;
  for(String str: textList) {
    out.println(linecount++ + ": " + str);
  }
  out.close();
  System.out.println(BufferedInputFile.read(file));
 }
}
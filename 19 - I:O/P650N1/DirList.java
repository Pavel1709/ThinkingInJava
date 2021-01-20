//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList {
  public static void main(String[] args) {
    File path = new File(".");
    //String file = read("DirList.java");
    String[] list;
      list = path.list(new DirFilter(args[0]));
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for(String dirItem : list)
      System.out.println(dirItem);
  }
}

class DirFilter implements FilenameFilter {
  private Pattern pattern;
  String file;
  ArrayList<String> words;
  ArrayList<String> cons ;
  public DirFilter(String...regex) {
     file = TextFile.read("DirList.java");
     words =new ArrayList<String>(Arrays.asList(file.split(" ")));
     cons =new ArrayList<String>(Arrays.asList(regex));
  }
  public boolean accept(File dir, String name) {
    boolean a = false;
    for (int i = 0; i < cons.size(); i++) {
     if (words.contains(cons.get(i))) {
      a = true;
     }
     else {
      a = false;
     }
    }
     return a;
    
  }
}  
import java.util.*;
import java.util.regex.*;
import java.io.*;
final class SortedDirList {
  static File path;
  String[] list;
 SortedDirList(String info, String... args) {
     path = new File(info);
if(args.length == 0)
      list =  list();
    else
      list = list(new DirFilter(args[0]));
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    for(String dirItem : list)
      System.out.println(dirItem);
 }
  public static String[] list() {
     return path.list(); 
  }
  public static String[] list(FilenameFilter f){
      return path.list(f);
  }
}
public class Executor {
 public static void main(String[] args) {
  SortedDirList std = new SortedDirList(".");
  SortedDirList std2 = new SortedDirList(".", "b.*");
 }
}
class DirFilter implements FilenameFilter {
  private Pattern pattern;
  public DirFilter(String regex) {
    pattern = Pattern.compile(regex);
  }
  public boolean accept(File dir, String name) {
    return pattern.matcher(name).matches();
  }

}
 
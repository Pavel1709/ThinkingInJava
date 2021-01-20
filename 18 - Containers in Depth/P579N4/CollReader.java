import java.util.*;
import net.mindview.util.*;
public class CollReader {
 public static Collection<String> collReturner1(String fileName) {
  String[] sa = TextFile.read(fileName).split(" ");
  return Arrays.asList(sa);
 }
 public static Collection<String> collReturner2(String fileName) {
  return new TreeSet<String>(new TextFile(fileName, "\\W+"));
 }
 public static void main(String[] args) {
  System.out.println(CollReader.collReturner1("Help.txt"));
  System.out.println(CollReader.collReturner2("Help.txt"));
 }
}
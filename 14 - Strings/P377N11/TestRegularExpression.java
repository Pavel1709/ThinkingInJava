import java.util.regex.*;
import static net.mindview.util.Print.*;

public class TestRegularExpression {
 public static void main(String[] args) {
  if (args.length < 2) {
   print("Usage:\njava TestRegularExpression " + "characterSequence regularExpression+");
   System.exit(0);
  }
  print("input: \""+ args[0] + "\"");
  for(String arg: args) {
   print("Regular expression: \"" + arg + "\"");
   Pattern p = Pattern.compile(arg);
   Matcher m = p.matcher(args[0]);
   while(m.find()) {
    print("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
   }
  }
 }
}
/*
pavel1709@mbp-pavel desktop % java TestRegularExpression  "Arline ate eight apples and one orange while Anita hadn’t any" "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
input: "Arline ate eight apples and one orange while Anita hadn’t any"
Regular expression: "Arline ate eight apples and one orange while Anita hadn’t any"
Match "Arline ate eight apples and one orange while Anita hadn’t any" at positions 0-60
Regular expression: "(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
Match "Arline" at positions 0-5
Match " ate" at positions 6-9
Match " one" at positions 27-30
Match " orange" at positions 31-37
Match " Anita" at positions 44-49
*/
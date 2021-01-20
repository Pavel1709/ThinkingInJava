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
//java TestRegularExpression "Java now has regular expressions"  ^Java "\Breg.*" "n.w\s+h(a|i)s" "s?" "s*" "s+" "s{4}" "S{1}." "s{0,3}"
/*
Match "Java now has regular expressions" at positions 0-31
Regular expression: "^Java"
Match "Java" at positions 0-3
Regular expression: "\Breg.*"
Regular expression: "n.w\s+h(a|i)s"
Match "now has" at positions 5-11
Regular expression: "s?"
Match "" at positions 0--1
Match "" at positions 1-0
Match "" at positions 2-1
Match "" at positions 3-2
Match "" at positions 4-3
Match "" at positions 5-4
Match "" at positions 6-5
Match "" at positions 7-6
Match "" at positions 8-7
Match "" at positions 9-8
Match "" at positions 10-9
Match "s" at positions 11-11
Match "" at positions 12-11
Match "" at positions 13-12
Match "" at positions 14-13
Match "" at positions 15-14
Match "" at positions 16-15
Match "" at positions 17-16
Match "" at positions 18-17
Match "" at positions 19-18
Match "" at positions 20-19
Match "" at positions 21-20
Match "" at positions 22-21
Match "" at positions 23-22
Match "" at positions 24-23
Match "" at positions 25-24
Match "s" at positions 26-26
Match "s" at positions 27-27
Match "" at positions 28-27
Match "" at positions 29-28
Match "" at positions 30-29
Match "s" at positions 31-31
Match "" at positions 32-31
Regular expression: "s*"
Match "" at positions 0--1
Match "" at positions 1-0
Match "" at positions 2-1
Match "" at positions 3-2
Match "" at positions 4-3
Match "" at positions 5-4
Match "" at positions 6-5
Match "" at positions 7-6
Match "" at positions 8-7
Match "" at positions 9-8
Match "" at positions 10-9
Match "s" at positions 11-11
Match "" at positions 12-11
Match "" at positions 13-12
Match "" at positions 14-13
Match "" at positions 15-14
Match "" at positions 16-15
Match "" at positions 17-16
Match "" at positions 18-17
Match "" at positions 19-18
Match "" at positions 20-19
Match "" at positions 21-20
Match "" at positions 22-21
Match "" at positions 23-22
Match "" at positions 24-23
Match "" at positions 25-24
Match "ss" at positions 26-27
Match "" at positions 28-27
Match "" at positions 29-28
Match "" at positions 30-29
Match "s" at positions 31-31
Match "" at positions 32-31
Regular expression: "s+"
Match "s" at positions 11-11
Match "ss" at positions 26-27
Match "s" at positions 31-31
Regular expression: "s{4}"
Regular expression: "S{1}."
Regular expression: "s{0,3}"
Match "" at positions 0--1
Match "" at positions 1-0
Match "" at positions 2-1
Match "" at positions 3-2
Match "" at positions 4-3
Match "" at positions 5-4
Match "" at positions 6-5
Match "" at positions 7-6
Match "" at positions 8-7
Match "" at positions 9-8
Match "" at positions 10-9
Match "s" at positions 11-11
Match "" at positions 12-11
Match "" at positions 13-12
Match "" at positions 14-13
Match "" at positions 15-14
Match "" at positions 16-15
Match "" at positions 17-16
Match "" at positions 18-17
Match "" at positions 19-18
Match "" at positions 20-19
Match "" at positions 21-20
Match "" at positions 22-21
Match "" at positions 23-22
Match "" at positions 24-23
Match "" at positions 25-24
Match "ss" at positions 26-27
Match "" at positions 28-27
Match "" at positions 29-28
Match "" at positions 30-29
Match "s" at positions 31-31
Match "" at positions 32-31
*/
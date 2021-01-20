//: strings/JGrep.java
// A very simple version of the "grep" program. // {Args: JGrep.java "\\b[Ssct]\\w+"}
import java.util.regex.*;
import net.mindview.util.*;
public class JGrep {
  public static void main(String[] args) throws Exception {
   if(args.length < 2) {
    System.out.println("Usage: java JGrep file regex");
    System.exit(0); 
   }
   Pattern p = Pattern.compile(args[1], args[2] );
   // Iterate through the lines of the input file: 
   int index = 0;
   Matcher m = p.matcher("");
   for(String line : new TextFile(args[0])) {
    m.reset(line); 
    while(m.find())
     System.out.println(index++ + ": " + m.group() + ": " + m.start());
   } 
  }
}
/*
java JGrep JGrep.java "\\b[Ssct]\\w+" "Pattern.CASE_INSENSITIVE | Pattern.MULTILINE"
0: strings: 4
1: simple: 10
2: the: 28
3: Ssct: 74
4: class: 7
5: static: 9
6: String: 26
7: throws: 41
8: System: 4
9: System: 4
10: compile: 23
11: through: 14
12: the: 22
13: the: 35
14: String: 7
15: System: 5
16: start: 62
*/
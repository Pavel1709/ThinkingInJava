//: strings/JGrep.java
// A very simple version of the "grep" program. 
// {Args: JGrep.java "\\b[Ssct]\\w+"}
import java.util.regex.*;
import net.mindview.util.*;
import java.io.*;
public class JGrep {
  public static void main(String[] args) throws Exception {
   if(args.length < 2) {
    System.out.println("Usage: java JGrep file regex");
    System.exit(0); 
   }
   String file = null;
   String fille = args[0];
   File[] files;

    files = new File(fille).listFiles();
   for( File f : files) {
    System.out.println(f);
    String s = f.getName();
    Pattern p = Pattern.compile("\\w+.java");
    Matcher m = p.matcher(s);
     if(m.find())
     file = m.group();
   }
   Pattern p = Pattern.compile(args[1]);
   // Iterate through the lines of the input file: 
   int index = 0;
   Matcher m = p.matcher("");
   for(String line : new TextFile(file)) {
    m.reset(line); 
    while(m.find())
     System.out.println(index++ + ": " + m.group() + ": " + m.start());
   } 
  }
}
/*
java JGrep "/Users/pavel1709/Desktop/P387N16/" "\\b[Ssct]\\w+"
/Users/pavel1709/Desktop/P387N16/.DS_Store
/Users/pavel1709/Desktop/P387N16/JGrep.java
/Users/pavel1709/Desktop/P387N16/JGrep.class
0: strings: 4
1: simple: 10
2: the: 28
3: Ssct: 26
4: class: 7
5: static: 9
6: String: 26
7: throws: 41
8: System: 4
9: System: 4
10: String: 3
11: String: 3
12: System: 4
13: String: 4
14: compile: 24
15: compile: 23
16: through: 14
17: the: 22
18: the: 35
19: String: 7
20: System: 5
21: start: 62
22: Ssct: 27
23: strings: 3
24: simple: 3
25: the: 3
26: Ssct: 3
27: class: 3
28: static: 3
29: String: 3
30: throws: 3
31: System: 3
32: System: 3
33: compile: 4
34: through: 4
35: the: 4
36: the: 4
37: String: 4
38: System: 4
39: start: 4
*/
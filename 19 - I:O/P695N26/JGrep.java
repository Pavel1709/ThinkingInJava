//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
import java.util.regex.*;
import net.mindview.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.nio.charset.*;
public class JGrep {
  public static void main(String[] args) throws Exception {
    if(args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }
    Pattern p = Pattern.compile(args[1]);
    // Iterate through the lines of the input file:
    int index = 0;
    FileChannel fc = new RandomAccessFile(args[0].toString(), "rw").getChannel();
    MappedByteBuffer in = fc.map(FileChannel.MapMode.READ_ONLY, 0, new File(args[0]).length());
    String[] sa = Charset.forName(System.getProperty("file.encoding")).decode(in).toString().split("\n");
    Matcher m = p.matcher(""); 
 
    for(String line : sa) {
     m.reset(line);
     while(m.find())
      System.out.println(index++ + ": " +  m.group() + ": " + m.start());
    }
    fc.close();
  }
}  

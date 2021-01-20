//: io/BasicFileOutput.java
import java.io.*;

public class BasicFileOutput {
  static String file = "BasicFileOutput.out";
  public static void main(String[] args) throws IOException {
    Long l = System.currentTimeMillis();
    BufferedReader in = new BufferedReader(
      new StringReader(
        BufferedInputFile.read("BasicFileOutput.java")));
    PrintWriter out = new PrintWriter(
      new BufferedWriter(new FileWriter(file)));
    int lineCount = 1;
    String s;
    while((s = in.readLine()) != null )
      out.println(lineCount++ + ": " + s);
    out.close();
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
   System.out.println(System.currentTimeMillis() - l);
   System.out.println("______________________________");
  Long ll = System.currentTimeMillis();
 
    LineNumberReader inn = new LineNumberReader(
      new StringReader(
        BufferedInputFile.read("BasicFileOutput.java")));
    PrintWriter outt = new PrintWriter(
      new BufferedWriter(new FileWriter(file)));
    int lineCounts = 1;
    String ss;
    while((ss = inn.readLine()) != null )
      outt.println(lineCounts++ + ": " + ss);
    outt.close();
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
   System.out.println(System.currentTimeMillis() - ll);
  }
} 

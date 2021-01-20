//: io/Echo.java
// How to read from standard input.
// {RunByHand}
import java.io.*;
public class Echo {
  public static void main(String[] args)
  throws IOException {
    BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
     BufferedReader in = new BufferedReader(
      new StringReader(
        BufferedInputFile.read(stdin.readLine())));
    String s;
    while((s = in.readLine()) != null && s.length()!= 0)
      System.out.println(s.toUpperCase());
    // An empty line or Ctrl-Z terminates the program
  }
} ///:~

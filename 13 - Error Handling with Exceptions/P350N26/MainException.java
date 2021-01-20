//: exceptions/MainException.java 
import java.io.*;
public class MainException {
   // Pass all exceptions to the console:
   public static void main(String[] args) throws Exception {
    // Open the file: 
    FileInputStream file = new FileInputStream("MaiException.java"); 
    // Use the file ...
    // Close the file:
    file.close();
   }
} ///:~
/*
Exception in thread "main" java.io.FileNotFoundException: MaiException.java (No such file or directory)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at MainException.main(MainException.java:7)
*/
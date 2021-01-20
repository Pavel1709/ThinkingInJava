//: net/mindview/util/BinaryFile.java
// Utility for reading files in binary form.
import java.io.*;

public class BinaryFile {
  public static byte[] read(File bFile) throws IOException{
    BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
    try {
      byte[] data = new byte[bf.available()];
      bf.read(data);
      return data;
    } finally {
      bf.close();
    }
  }
  public static byte[]
  read(String bFile) throws IOException {
    return read(new File(bFile).getAbsoluteFile());
  }
 
  public static void main(String[] args) throws IOException{
    for(File file : Directory.walk(".", ".*\\.class").files) {
      byte[] ba = read(file);
      for(int i = 0; i < 4; i++)
       System.out.print(Integer.toHexString(ba[i] & 0xff).toUpperCase()); 
      System.out.println();
    }
  }
} ///:~

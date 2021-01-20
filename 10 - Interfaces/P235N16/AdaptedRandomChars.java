import java.util.*;
import java.nio.*;
 class RandomChars {
  public static Random rand = new Random(100);
  public int next(int l) { 
   return rand.nextInt(l) ;
  }
 }
 public class AdaptedRandomChars extends RandomChars implements Readable {
  private int count;
  public AdaptedRandomChars(int count) {
   this.count = count;
  }
  public int read(CharBuffer cb) {
   if (count-- == 0) 
    return -1;
    for (int i = 0; i < 5; i++) {
    cb.append((char) next(100));
    }
    return cb.length();
  }
  public static void main(String[] args) {
   Scanner s = new Scanner(new AdaptedRandomChars(12));
    while(s.hasNextLine()) {
     System.out.print(s.nextLine());
    }
  }
}
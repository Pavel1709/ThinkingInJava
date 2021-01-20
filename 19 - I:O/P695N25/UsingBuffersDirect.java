//: io/UsingBuffersDirect.java
import java.nio.*;
import static net.mindview.util.Print.*;

public class UsingBuffersDirect {
  private static void symmetricScramble(CharBuffer buffer){
    while(buffer.hasRemaining()) {
      buffer.mark();
      char c1 = buffer.get();
      char c2 = buffer.get();
      buffer.reset();
      buffer.put(c2).put(c1);
    }
  }
  public static void main(String[] args) {
    char[] data = "UsingBuffersDirect".toCharArray();
    ByteBuffer bb = ByteBuffer.allocateDirect(data.length * 2);
    CharBuffer cb = bb.asCharBuffer();
    cb.put(data);
    print(cb.rewind());
    symmetricScramble(cb);
    print(cb.rewind());
    symmetricScramble(cb);
    print(cb.rewind());
  }
} /* Output:
UsingBuffersDirect
sUniBgfuefsr
UsingBuffersDirect
*///:~

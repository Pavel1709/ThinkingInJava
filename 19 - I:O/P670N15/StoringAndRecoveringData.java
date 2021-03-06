//: io/StoringAndRecoveringData.java
import java.io.*;

public class StoringAndRecoveringData {
  public static void main(String[] args)
  throws IOException {
    DataOutputStream out = new DataOutputStream(
      new BufferedOutputStream(
        new FileOutputStream("Data.txt")));
    out.writeDouble(3.14159);
    out.writeUTF("That was pi");
    out.writeDouble(1.41413);
    out.writeUTF("Square root of 2");
    out.writeBoolean(true);
    out.writeByte(1);
    out.writeChar(44);
    out.writeFloat(3.33f);
    out.writeInt(10);
    out.writeLong(3333333l);
    out.writeShort(3);

    out.close();
    DataInputStream in = new DataInputStream(
      new BufferedInputStream(
        new FileInputStream("Data.txt")));
    System.out.println(in.readDouble());
    // Only readUTF() will recover the
    // Java-UTF String properly:
    System.out.println(in.readUTF());
    System.out.println(in.readDouble());
    System.out.println(in.readUTF());
    System.out.println(in.readBoolean());
    System.out.println(in.readByte());
    System.out.println(in.readChar());
    System.out.println(in.readFloat());
    System.out.println(in.readInt());
    System.out.println(in.readLong());
    System.out.println(in.readShort());

  }
} /* Output:
3.14159
That was pi
1.41413
Square root of 2
*///:~

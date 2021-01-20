//: io/Blips.java
// Simple use of Externalizable & a pitfall.
import java.io.*;
import static net.mindview.util.Print.*;

class Blip1 implements Externalizable {
  public Blip1() {
    print("Blip1 Constructor");
  }
  public void writeExternal(ObjectOutput out)
      throws IOException {
    print("Blip1.writeExternal");
  }
  public void readExternal(ObjectInput in)
     throws IOException, ClassNotFoundException {
    print("Blip1.readExternal");
  }
}

public class BlipCheck implements Externalizable {
  //Blip2() {
   // print("Blip2 Constructor");
  //}
  public void writeExternal(ObjectOutput out)
      throws IOException {
    print("Blip2.writeExternal");
  }
  public void readExternal(ObjectInput in)
     throws IOException, ClassNotFoundException {
    print("Blip2.readExternal");
  }
}

class Blips {
  public static void main(String[] args)
  throws IOException, ClassNotFoundException {
    print("Constructing objects:");
    Blip1 b1 = new Blip1();
    Blip2 b2 = new Blip2(); 
    BlipCheck bc = new BlipCheck();
    ObjectOutputStream o = new ObjectOutputStream(
      new FileOutputStream("Blips.out"));
    print("Saving objects:");
    o.writeObject(b1);
    o.writeObject(b2);
    o.writeObject(bc);
    o.close();
    // Now get them back:
    ObjectInputStream in = new ObjectInputStream(
      new FileInputStream("Blips.out"));
    print("Recovering b1:");
    b1 = (Blip1)in.readObject();
    print("Recovering b2:");
    b2 = (Blip2)in.readObject();
    print("Recovering bc:");
    bc = (BlipCheck)in.readObject();
  }
} /* Output:
Constructing objects:
Blip1 Constructor
Blip2 Constructor
Saving objects:
Blip1.writeExternal
Blip2.writeExternal
Recovering b1:
Blip1 Constructor
Blip1.readExternal
*///:~
/*
Constructing objects:
Blip1 Constructor
Blip2 Constructor
Saving objects:
Blip1.writeExternal
Blip2.writeExternal
Blip2.writeExternal
Recovering b1:
Blip1 Constructor
Blip1.readExternal
Recovering b2:
Exception in thread "main" java.io.InvalidClassException: Blip2; no valid constructor
	at java.io.ObjectStreamClass$ExceptionInfo.newInvalidClassException(ObjectStreamClass.java:169)
	at java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:874)
	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2097)
	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1624)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:464)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:422)
	at Blips.main(BlipCheck.java:54)
*/
/*Программа работает правильно посколько мы придаем объекту Blip2 cвойство "долгоживучести", поэтому даже после его удаления из программы он продолжает существовать.  Если первая версия программы скомпилирована(и запущена), то объект действительно будет найден, и обновленная версия программы будет работать. Если не запустить изначальную версию, то информации о таком объекте не будет. Исключение в конце появляется из-за того, что в изначальной версии конструктор не был объявлен публичным, его можно было избежать.
*/
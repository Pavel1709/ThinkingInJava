import java.io.*;
import java.util.*;
class SerialRealizer implements Serializable {
 AnotherSerialRealizer ar;
 SerialRealizer() {}
 public String toString() {
  return "good";
 }
}
class AnotherSerialRealizer implements Serializable {
 AnotherSerialRealizer() {}
}
public class Executor {
 public static void main(String[] args) throws IOException, ClassNotFoundException{
  SerialRealizer sr = new SerialRealizer();
  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ser.out"));
  out.writeObject("Ser storage\n");
  out.writeObject(sr);
  out.close(); 
  ObjectInputStream in = new ObjectInputStream(new FileInputStream("ser.out")); 
  String s = (String)in.readObject();
  SerialRealizer sr2 = (SerialRealizer)in.readObject(); 
  System.out.println(s + "sr2 = " + sr2);
 }
}
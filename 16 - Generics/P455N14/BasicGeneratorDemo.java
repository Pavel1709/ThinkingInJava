//: generics/BasicGeneratorDemo.java
import net.mindview.util.*;
public class BasicGeneratorDemo {
  public static void main(String[] args) {
   Generator<CountedObject> gen =new BasicGenerator<CountedObject>(CountedObject.class);
    for(int i = 0; i < 5; i++) 
     System.out.println(gen.next());
  }
}
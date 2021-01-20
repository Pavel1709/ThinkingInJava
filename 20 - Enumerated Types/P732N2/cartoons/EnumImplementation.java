//: enumerated/cartoons/EnumImplementation.java
// An enum can implement an interface
package cartoons;
import java.util.*;
import net.mindview.util.*;

enum CartoonCharacter {
  SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
  private static Random rand = new Random(47);
  public static CartoonCharacter next() {
    return values()[rand.nextInt(values().length)];
  }
}

public class EnumImplementation {
  public static <T> void printNext(CartoonCharacter rg) {
    System.out.print(rg.next() + ", ");
  }
  public static void main(String[] args) {
    // Choose any instance:
    CartoonCharacter cc = CartoonCharacter.BOB;
    for(int i = 0; i < 10; i++)
      printNext(cc);
  }
} /* Output:
BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY, SLAPPY,
*///:~
//Плюс в том: что теперь наш код не привязан к интерфейсу: мы не обязаны имплементировать его методы, можем создать, например, перегруженную версию next или вообще назвать его по-другому, однако, в этом же и минус, так как код не такой гибкий, и, например, для того, чтобы наш код подходил под метод printNext, нужно перегружать этот метод конкретно под него, так как код под любой класс имплементриующий генератор не подойдет.
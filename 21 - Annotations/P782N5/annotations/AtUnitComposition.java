//: annotations/AtUnitComposition.java
// Creating non-embedded tests.
package annotations;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class AtUnitComposition extends AtUnitExample1{
  AtUnitExample1 testObject = new AtUnitExample1();
  @Test boolean _methodOne() {
    System.out.println(testObject);
    return
       methodOne().equals("This is methodOne");
  }
  @Test boolean _methodTwo() {
    System.out.println(testObject);
    return methodTwo() == 2;
  }
  public static void main(String[] args) throws Exception {
    OSExecute.command(
     "java  net.mindview.atunit.AtUnit annotations/AtUnitComposition");
  }
} /* Output:
annotations.AtUnitComposition
  . _methodOne annotations.AtUnitExample1@45ee12a7

  . _methodTwo annotations.AtUnitExample1@330bedb4
This is methodTwo

OK (2 tests)
*///:~

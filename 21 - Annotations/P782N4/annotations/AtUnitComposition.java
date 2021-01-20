//: annotations/AtUnitComposition.java
// Creating non-embedded tests.
package annotations;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class AtUnitComposition {
  AtUnitExample1 testObject = new AtUnitExample1();
  @Test boolean _methodOne() {
    System.out.println(testObject);
    return
      testObject.methodOne().equals("This is methodOne");
  }
  @Test boolean _methodTwo() {
    System.out.println(testObject);
    return testObject.methodTwo() == 2;
  }
  public static void main(String[] args) throws Exception {
    OSExecute.command(
     "java  net.mindview.atunit.AtUnit annotations/AtUnitComposition");
  }
} /* Output:
annotations.AtUnitComposition
  . _methodTwo annotations.AtUnitExample1@45ee12a7
This is methodTwo

  . _methodOne annotations.AtUnitExample1@330bedb4

OK (2 tests)


*///:~

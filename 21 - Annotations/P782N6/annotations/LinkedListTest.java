//: annotations/LinkedListTest.java
package annotations;
import java.util.*;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class LinkedListTest {
  LinkedList<String> testObject = new LinkedList<String>();
  @Test void initialization() {
    assert testObject.isEmpty();
  }
  @Test void _contains() {
    testObject.add("one");
    assert testObject.contains("one");
  }
  @Test void _remove() {
    testObject.add("one");
    testObject.remove("one");
    assert testObject.isEmpty();
  }
  public static void main(String[] args) throws Exception {
    OSExecute.command(
      "java net.mindview.atunit.AtUnit annotations/LinkedListTest");
  }
} /* Output:
annotations.LinkedListTest
  . initialization
  . _remove
  . _contains
OK (3 tests)
*///:~

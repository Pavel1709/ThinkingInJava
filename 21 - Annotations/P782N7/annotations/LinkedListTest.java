//: annotations/LinkedListTest.java
package annotations;
import java.util.*;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class LinkedListTest extends LinkedList<String>{
  //LinkedList<String> testObject = new LinkedList<String>();
  @Test void initialization() {
    assert  isEmpty();
  }
  @Test void _contains() {
    add("one");
    assert  contains("one");
  }
  @Test void _remove() {
    add("one");
    remove("one");
    assert  isEmpty();
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

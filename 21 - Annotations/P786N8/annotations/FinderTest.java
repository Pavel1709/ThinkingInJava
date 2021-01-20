package annotations;
import net.mindview.atunit.*;
import net.mindview.util.*;

public class FinderTest extends Finder<String> {
  
  @Test void _put() {
  put("hi");
  assert i.equals("hi");
 }
 @Test void _find() {
  put("hi");
  assert callFind().equals("hi");
 }
 public static void main(String[] args) {
  OSExecute.command("java net.mindview.atunit.AtUnit FinderTest");
 }
}
/*
/FinderTest
annotations.FinderTest
  . _find 
  . _put 
OK (2 tests)
*/
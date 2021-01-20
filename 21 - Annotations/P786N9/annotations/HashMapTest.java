package annotations;
import java.util.*;
import net.mindview.atunit.*; 
import net.mindview.util.*;
public class HashMapTest {
 HashMap<String, Integer> testObject = new HashMap<String, Integer>();
 @Test void initialization() {
  assert testObject.isEmpty();
 }
 @Test void _containsKey() {
  testObject.put("One", 1);
  assert testObject.containsKey("One");
 }
 @Test void _remove() { 
  testObject.put("one", 3);
  testObject.remove("one");assert 
  testObject.isEmpty(); 
 }
 @Test void _containsValue () {
  testObject.put("One", 6);
  assert testObject.containsValue(6);
 }
 public static void main(String[] args) throws Exception { 
  OSExecute.command("java net.mindview.atunit.AtUnit annotations.HashMapTest"); 
 }
}
/*
annotations.HashMapTest
  . initialization 
  . _containsKey 
  . _remove 
  . _containsValue 
OK (4 tests)
*/
package annotations;
import java.io.*;
import net.mindview.atunit.*; 
import net.mindview.util.*;
public class ToDoListTest  extends ToDoList{
 ToDoList.ToDoItem t = new ToDoList.ToDoItem("Hi", 'c', 10);
 ToDoList toDoList = new ToDoList();
 @Test void _compareTo() {
  assert t.compareTo(new ToDoList.ToDoItem("Hi", 'c', 10)) == 0;
 }
 @Test void _add() {
  toDoList.add(new ToDoList.ToDoItem("Hi", 'c', 10));
  assert toDoList.isEmpty();
 }
 public static void main(String[] args) {
  OSExecute.command("java net.mindview.atunit.AtUnit ToDoListTest");
 }
}
/*
annotations.ToDoListTest
  . _add java.lang.AssertionError
(failed)
  . _compareTo 
(2 tests)

>>> 1 FAILURE <<<
  annotations.ToDoListTest: _add
*/
package annotations;
import net.mindview.atunit.*;
import net.mindview.util.*;
public class Finder<T> {
 T i ;
 public void put(T i) {
  this.i = i;
 } 
 private T find() {
  return i;
 }
 @TestProperty public T callFind() {
  return find(); 
 }
}
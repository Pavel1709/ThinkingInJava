import typeinfo.pets.*;
import java.util.*;
public class CollectionSequence  {
 List<Pet> petList = Pets.arrayList(8); 
 public List<Pet> getList() {
  return petList;
 }
/* 
 public int size() { return pets.size(); } 
 public Iterator<Pet> iterator() {
  return new Iterator<Pet>() { 
   private int index = 0;
   public boolean hasNext() {
    return index < pets.length; 
   }
  public Pet next() { return pets[index++]; }
  public void remove() { // Not implemented
     throw new UnsupportedOperationException();
  }
  }; 
 }
*/
  public static void main(String[] args) {
   CollectionSequence c = new CollectionSequence();
   InterfaceVsIterator.display(c.getList()); 
   InterfaceVsIterator.display(c.getList().iterator());
 }
}
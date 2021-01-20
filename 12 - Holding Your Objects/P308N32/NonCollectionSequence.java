//: holding/NonCollectionSequence.java 
import typeinfo.pets.*;
import java.util.*;
class PetSequence {
 protected Pet[] pets = Pets.createArray(8);
}
public class NonCollectionSequence extends PetSequence implements Iterable<Pet>{
  
  public Iterator<Pet> iterator() {
   return new Iterator<Pet>() { 
    private int index = 0; 
    public boolean hasNext() {
     return index < pets.length;
    }
    public Pet next() { 
     return pets[index++];
    }
    public void remove() { 
     // Not implemented
     throw new UnsupportedOperationException();
    }
   }; 
  }
  public Iterable<Pet> reversed() {
   return new Iterable<Pet>() {
    public Iterator<Pet> iterator() {
     return new Iterator<Pet>() {
      int current = pets.length - 1;
      public boolean hasNext() {
       return current > - 1;
      }
      public Pet next() {
       return pets[current--];
      }
      public void remove() {
       throw new UnsupportedOperationException();
      }
     };
    }  
   };
  }
  public Iterable<Pet> randomized() {
   return new Iterable<Pet>() {
     public Iterator<Pet> iterator() {
      List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
      Collections.shuffle(shuffled, new Random(47));
      return shuffled.iterator();
     }
   };
  }

 public static void main(String[] args) { 
  NonCollectionSequence nc = new NonCollectionSequence();
  for (Pet p: nc.reversed()) {
   // InterfaceVsIterator.display(p);
    System.out.print(p.id() + ":" + p + " ");
  }
  System.out.println(); 
  for (Pet p: nc.randomized()) {
    // InterfaceVsIterator.display(p);
     System.out.print(p.id() + ":" + p + " ");
  }
  System.out.println(); 
  for (Pet p: nc)  {
     //InterfaceVsIterator.display(p);
     System.out.print(p.id() + ":" + p + " ");
  }
  System.out.println(); 
 }
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx *///:~
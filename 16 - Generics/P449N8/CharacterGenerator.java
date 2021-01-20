
//: generics/coffee/CoffeeGenerator.java // Generate different types of Coffee: package generics.coffee;
import java.util.*;
import net.mindview.util.*;
public class CharacterGenerator implements Generator<Character>, Iterable<Character> {
 private Class[] types = { SuperMan.class, BatMan.class, SpiderMan.class, Octopus.class,  Joker.class, Venom.class,};
 private static Random rand = new Random(47); 
 public CharacterGenerator() {}
 private int size = 0;
 public CharacterGenerator(int sz) { size = sz; } 
 public Character next() {
   try {
     return (Character) types[rand.nextInt(types.length)].newInstance(); // Report programmer errors at run time:
    } catch(Exception e) {
      throw new RuntimeException(e);
    } 
 }
 class CharacterIterator implements Iterator<Character> { 
  int count = size;
  public boolean hasNext() { 
   return count > 0; 
  } 
  public Character next() {
   count--;
   return CharacterGenerator.this.next(); 
  }
  public void remove() { // Not implemented
   throw new UnsupportedOperationException();
  }
 };
 public Iterator<Character> iterator() {
  return new CharacterIterator();
 }
 public static void main(String[] args) { 
  CharacterGenerator gen = new CharacterGenerator();
  for(int i = 0; i < 5; i++)
   System.out.println(gen.next()); 
  for(Character c : new CharacterGenerator(5))
   System.out.println(c); 
 }
} 
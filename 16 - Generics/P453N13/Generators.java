import java.util.*;
import net.mindview.util.*;
//import generics.coffee.*;
public class Generators {
 public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++)
   coll.add(gen.next());
  return coll;
 }
 public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++)
   coll.add(gen.next());
  return coll;
 } 
 public static <T> Queue<T> fill(Queue<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++)
   coll.add(gen.next());
  return coll;
 }
 public static <T> Set<T> fill(Set<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++)
   coll.add(gen.next());
  return coll;
 }
 public static <T> LinkedList<T> fill(LinkedList<T> coll, Generator<T> gen, int n) {
  for(int i = 0; i < n; i++)
   coll.add(gen.next());
  return coll;
 }
 public static void main(String[] args) {
  Collection<Character> character = fill( new ArrayList<Character>(), new CharacterGenerator(), 4);   
  for(Character c : character)
   System.out.println(c); 
  Collection<Integer> fnumbers = fill( new ArrayList<Integer>(), new Fibonacci(), 12);    
  for(int i : fnumbers)
   System.out.print(i + ", "); 
  Collection<Integer> nums = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
  System.out.println(nums.getClass().getSimpleName());
  LinkedList<Integer> lnums = fill(new LinkedList<Integer>(), new Fibonacci(), 12);
  System.out.println(lnums.getClass().getSimpleName());
 }
}
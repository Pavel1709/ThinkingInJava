//: generics/RandomList.java 
import java.util.*;
public class RandomList<T> {
 private ArrayList<T> storage = new ArrayList<T>(); 
 private Random rand = new Random(47);
 public void add(T item) { 
  storage.add(item); 
 } 
 public T select() {
  return storage.get(rand.nextInt(storage.size())); 
 }
 public static void main(String[] args) { 
  RandomList<String> rs = new RandomList<String>(); 
  RandomList<Integer> rs2 = new RandomList<Integer>();
  RandomList<RandomList> rs3 = new RandomList<RandomList>();
  for(String s: ("The quick brown fox jumped over " + "the lazy brown dog").split(" "))       
   rs.add(s);
  for(int i = 0; i < 11; i++) {
   rs2.add(i);
   rs3.add(new RandomList());
   System.out.println(rs.select() + " ");
  }
  for(int i = 0; i < 11; i++)
   System.out.println(rs2.select() + " ");
  for(int i = 0; i < 11; i++)
   System.out.println(rs3.select() + " ");
 }
}
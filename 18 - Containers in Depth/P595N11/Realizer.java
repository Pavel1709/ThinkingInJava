import java.util.*;
class Element implements Comparable<Integer>{
 Random rand = new Random();
 Integer i;
 public Element() {
  i = rand.nextInt(100);
 }
 public int compareTo(Integer i) {
  return (this.i < i ? -1 : (this.i == i ? 0 : 1));
 }
 public String toString() {
  return i + "";
 }
 
}
public class Realizer {
 public static void main(String[] args) {
  PriorityQueue<Element> pq = new PriorityQueue<Element>();
  for (int i = 0; i < 15; i++) {
   pq.add(new Element());
  }
  while(!pq.isEmpty()) {
   System.out.println(pq.poll());
  }
 }
}
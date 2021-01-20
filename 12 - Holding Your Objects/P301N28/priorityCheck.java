import java.util.*;
public class priorityCheck {
 public static void main(String[] args) {
  PriorityQueue<Double> pq = new PriorityQueue<Double>();
  Random r = new Random();
  for (int i = 0; i <r.nextInt(100); i++) {
   pq.offer(r.nextDouble());
  }
  int l = pq.size();
  PriorityQueue<Double> pq1 = new PriorityQueue<Double>(l, Collections.reverseOrder());
  pq1.addAll(pq);
  for (int j = 0; j < l; j++) {
   System.out.println(pq.poll());
  }
  
  for (int j = 0; j < l; j++) {
   System.out.println(pq1.poll());
  }
 }
}
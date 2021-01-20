import java.util.*;
class Command {
 String s;
 Command(String s) {
  this.s = s;
 }
 void operation() {
  System.out.println(s);
 }
}
class QueueStudy{
 Queue<Command> q = new LinkedList<Command>();
 Queue<Command> fillTheQueue(String str) {
  q.offer(new Command(str));
  return q;
 }
}
public class Perebirator {
 void prerbor(Queue q) {
     int l = q.size();
  for(int i = 0; i < l; i++) {
   System.out.println(q.peek()); 
   ((Command)q.peek()).operation();
    q.remove();
  }
 }
 public static void main(String[] args) {
  QueueStudy qs = new QueueStudy();
  qs.fillTheQueue("One");
  qs.fillTheQueue("Two");
  qs.fillTheQueue("Three");
  qs.fillTheQueue("Four");
  qs.fillTheQueue("Five");
  qs.fillTheQueue("Six");
  qs.fillTheQueue("Seven");
  qs.fillTheQueue("Eight");
  Perebirator prb = new Perebirator();
  prb.prerbor(qs.q);
 }
}
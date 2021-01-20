import java.util.*;
class Something {
 
}
public class quTest {
 public static void main(String[] args) {
  PriorityQueue<Something> sq = new PriorityQueue<Something>();
  sq.offer(new Something( ));
  //!sq.offer(new Something( ));java.lang.ClassCastException: Something cannot be cast to java.lang.Comparable

  //!sq.offer(new Something( )); java.lang.ClassCastException: Something cannot be cast to java.lang.Comparable

  System.out.println(sq.size());
 Queue<Something> sq1 = new LinkedList<Something>();
// однако, если повторить то же самое с LinkedList, то все будет нормально
  sq1.offer(new Something( ));
  sq1.offer(new Something( ));
  sq1.offer(new Something( ));
  System.out.println(sq1.size());

 PriorityQueue<Integer> sq2 = new PriorityQueue<Integer>();
 sq2.offer(5);
 sq2.offer(6);
 sq2.offer(new Integer(5));
 sq2.offer(new Integer(8)); //а тут получилось, видимо, из-за автораспаковки

 System.out.println(sq2.size());
 }
}
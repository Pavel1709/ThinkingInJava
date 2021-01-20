import java.util.*;
public class ArrLinkedList {
 public static void main(String[] args) {
  List<String> counArList = new ArrayList<String>(Countries.names(Countries.DATA.length)); 
  List<String> counLiList = new LinkedList<String>(Countries.names(Countries.DATA.length));
  Iterator<String> it1 = counLiList.iterator();
  Iterator<String> it2 = counArList.iterator();
  System.out.println("LinkedList ");
  while (it1.hasNext()) {
   System.out.println(it1.next());
  }
  System.out.println("ArrayList ");
  while (it2.hasNext()) {
   System.out.println(it2.next());
  }
  ListIterator<String> itti1 = counLiList.listIterator();
  ListIterator<String> itti =  counArList.listIterator(counArList.size());
  while (itti1.hasNext()) {
   itti.add(  itti1.next());
  }
  ListIterator<String> itti2 = counLiList.listIterator(counLiList.size());
  ListIterator<String> itti22 = counArList.listIterator(counLiList.size());
  while (itti2.hasPrevious()) {
   itti22.add( itti2.previous());
  }
  System.out.println("LinkedList ");
  System.out.println(counLiList);
  System.out.println("ArrayList ");
  System.out.println(counArList);  
 }
}
import java.util.*;
class FastTraversalLinkedList<T>   {
 List<T> ll = new LinkedList<T>();
 List<T> al = new ArrayList<T>();
 public void insert(int index, T element) {
  ll.add(index,element);
  al = new ArrayList<T>(ll);
 }
 public int size() {
  return ll.size();
 }
 public void addAll(Collection<T> c) {
  ll.addAll(c);
  al = new ArrayList<T>(ll);
 }
 public void add(T t) {
  al.add(t);
  ll = new ArrayList<T>(al);
 }
 public void clear() {
  ll.clear();
  al = new ArrayList<T>(ll);
 }
 public T remove(int index) {
  T t = ll.get(index);
  ll.remove(index);
  al = new ArrayList<T>(ll);
  return t;
 }
 public T get(int index) {
  return al.get(index);
 }
 public void iteradd(T t) {
  ListIterator<T> it = al.listIterator();
  while(it.hasNext()) {
   it.add(t);
   it.next();
  }
  ll = new ArrayList<T>(al);
 }
 public ListIterator<T> listIterator(int index) {
  return al.listIterator(index);
 }
}

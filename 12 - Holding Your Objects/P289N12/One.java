public class One {
 static List<Integer> ints = new ArrayList<Integer>();
 public static void main(String[] args) {
  for (int i = 0; i < 10; i++) {
   ints.add(i);
  }
  List<Integer> mints = new ArrayList<Integer>();
  mints.addAll(ints);
  ListIterator<Integer> li = ints.listIterator();
  ListIterator<Integer> mi = mints.listIterator();
  while (li.hasNext()) {
     li.next();
  }  

  while (mi.hasNext()) {
     mi.next();
     mi.set(li.previous() ); 
  }

  System.out.println(mints);

 }
}

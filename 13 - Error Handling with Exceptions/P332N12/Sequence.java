//: innerclasses/Sequence.java // Holds a sequence of Objects.
interface Selector {
  boolean end();
  Object current();
  void next();
}
public class Sequence { 
private Object[] items;
 private int next = 0;
 public Sequence(int size) {
  items = new Object[size];
 }
 public void add(Object x) throws ArrayIndexOutOfBoundsException {
  try {
   //if(next < items.length) 
    items[next++] = x;
  }
  catch(ArrayIndexOutOfBoundsException ae) {
   System.out.println("Вы вышли за размеры массива");
   throw new RuntimeException(ae);
  }
 }
 private class SequenceSelector implements Selector {
  private int i = 0;
  public boolean end() { 
   return i == items.length; 
  }
  public Object current() { 
   return items[i]; 
  }
  public void next() {
   if(i < items.length) i++; 
  }
 }
 public Selector selector() {
    return new SequenceSelector();
 }
 public static void main(String[] args) { 
  Sequence sequence = new Sequence(10); 
  for(int i = 0; i < 11; i++)
  try {
   sequence.add(Integer.toString(i));
  }
  catch(ArrayIndexOutOfBoundsException e) {
   e.printStackTrace(System.out);
  }
   Selector selector = sequence.selector();
   while(!selector.end()) {
    System.out.print(selector.current() + " ");
    selector.next(); 
   }
  }
} /* Output: 0123456789 *///:~
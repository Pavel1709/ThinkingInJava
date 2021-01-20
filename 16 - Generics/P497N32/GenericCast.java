//: generics/GenericCast.java
class FixedSizeStack<T> {
 private int index = 0;
 private Object[] storage;
 public FixedSizeStack(int size) {
  storage = new Object[size];
 }
 public void push(T item) { 
  storage[index++] = item; 
 } 
 @SuppressWarnings("unchecked")
 public T pop() {
  return (T)storage[index--]; 
/*
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
	at FixedSizeStack.pop(GenericCast.java:13)
	at GenericCast.main(GenericCast.java:27)
*/
 }
}
public class GenericCast {
 public static final int SIZE = 10; 
 public static void main(String[] args) {
  FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
  for(String s : "A B C D E F G H I J".split(" ")) 
   strings.push(s);
  //for(int i = 0; i <= SIZE; i++) { //Exception in thread "main" 
  //java.lang.ArrayIndexOutOfBoundsException: -1
  //at FixedSizeStack.pop(GenericCast.java:13)
  //at GenericCast.main(GenericCast.java:23)
  for(int i = 0; i <  SIZE; i++) { 
   String s = strings.pop();
   System.out.print(s + " "); 
  }
 }
} /* Output: JIHGFEDCBA *///:~

/**
 *
 * @author pavel1709
 */
//: arrays/ArrayOfGenericType.java
// Arrays of generic types won’t compile.
public class ArrayOfGenericType<T> { 
 T[] array; // OK
 @SuppressWarnings("unchecked") 
 public ArrayOfGenericType(int size) {
  //! array = new T[size]; // Illegal
  array = (T[])new Object[size]; // "unchecked" Warning 
 }
 // Illegal:
 //! public <U> U[] makeArray() { return new U[10]; }
 public static void main(String[] args) {
   String[] s= new String[5];
   //!s[0] = 5;
   //Object[] o = new int[5]; 
   Object[] o = new Object[5];
   Object[] o2 = new Integer[5]; 
   o[0] = 5;

  }
 } ///:~
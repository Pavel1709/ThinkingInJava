//: net/mindview/util/CountingIntegerList.java
// List of any length, containing sample data.
 
import java.util.*;

public class CountingStringList
extends AbstractList<String> {
  private int size;
  public CountingStringList(int size) {
    this.size = size < 0 ? 0 : size;
  }
  public String get(int index) {
    return String.valueOf(index);
  }
  public int size() { return size; }
  public static void main(String[] args) {
    System.out.println(new CountingStringList(30));
  }
} /* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
*///:~

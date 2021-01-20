import java.util.*;
class Integer implements Comparator<Integer>,Comparable<Integer> {
  int i;
  Integer(int i) {
      this.i = i;
  }
    @Override
    public int compare(Integer o1, Integer o2) {
      return (o1.i < o2.i ? -1 : (o1.i == o2.i ? 0 : 1)); 
    }
    public String toString() {
        return i + "";
    }


    @Override
    public int compareTo(Integer o) {
     return (i < o.i ? -1 : (i == o.i ? 0 : 1));   
    }
}
    

public class PythonList {
 public static void main(String[] args) {
  Integer[] aList = new Integer[]{new Integer(1),new Integer(2), new Integer(3), new Integer(4), new Integer(5)};
  System.out.println(aList.getClass().getSimpleName());
  System.out.println(Arrays.toString(aList));
  System.out.println(aList[4]);
  Integer[] aList2 = new Integer[]{new Integer(1),new Integer(2), new Integer(3), new Integer(4), new Integer(5),   new Integer(6)};
  aList = aList2; 
  Integer[] aList3 = new Integer[]{new Integer(1),new Integer(2), new Integer(3), new Integer(4), new Integer(5),   new Integer(6), new Integer(7),   new Integer(8)};
  aList = aList3; 
  Integer[] aSlice = new Integer[2];
  System.arraycopy(aList, 2, aSlice, 0, 1);
  MyList.getReversed(aList);
  System.out.println(Arrays.toString(aList));
 }
}
class MyList{
 public static Integer[]  getReversed(Integer[]  arr) {
  Arrays.sort(arr, Collections.reverseOrder());
  return arr;
 }
}
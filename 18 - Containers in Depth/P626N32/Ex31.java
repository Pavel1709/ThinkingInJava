import java.util.*;
import static net.mindview.util.Print.*;

class StringsHolder {
	private int size = 0;
	private int[] sArray = new int[size];
	// Can add only Strings:
	// (Resizing and copying will degrade performance)
	public void add(int s) { 
		size += 1;
		int[] temp = new int[size];
		for(int i = 0; i < sArray.length; i++) temp[i] = sArray[i];
		temp[size - 1] = s;
		sArray = temp;
	}
	// get() returns only Strings:
	public int get(int i) {
		if(-1 < i && i < size) return sArray[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < sArray.length; i++) sb.append((sArray[i] + " "));
		return sb.toString();		
	}	
        public void set(int i, int j) {
		if(-1 < i && i < size) sArray[i] = j;
		else throw new ArrayIndexOutOfBoundsException(i);
	}	
}

// Alternate to eliminate resizing time for fixed size StringsHolder2:
class StringsHolder2 { 
	private int size = 1000;
	private int index = 0;
	private int[] sArray = new int[size];
	// Can add only Strings:
	public void add(int s) {
		if(index < size) sArray[index++] = s;
	}
	// get() returns only Strings:
	public int get(int i) {
		if(-1 < i && i < size) return sArray[i];
		else throw new ArrayIndexOutOfBoundsException(i);
	}
        public void set(int i, int j) {
		if(-1 < i && i < size) sArray[i] = j;
		else throw new ArrayIndexOutOfBoundsException(i);
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < sArray.length; i++) sb.append((sArray[i] + " "));
		return sb.toString();		
	}	
}

public class Ex31 {
	static long addTimeTest(StringsHolder sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.add(5);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long addTimeTest(ArrayList<Integer> list, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) list.add(5);
		long stop = System.nanoTime();
		return (stop - start)/reps;
	}
	static long getTimeTest(StringsHolder sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long getTimeTest(ArrayList<Integer> list, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) list.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;
	}
	static long addTimeTest(StringsHolder2 sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.add(5);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
	static long getTimeTest(StringsHolder2 sh, int reps) {
		long start = System.nanoTime();
		for(int i = 0; i < reps; i++) sh.get(i);
		long stop = System.nanoTime();
		return (stop - start)/reps;		
	}
        static long getTimeOfIncrement(StringsHolder2 sh, int reps) {
         long start = System.nanoTime();
         for(int i = 0; i < reps; i++)
          sh.set(i,sh.get(i)+1);
         long stop = System.nanoTime();
         return (stop - start)/reps;	
        }
        static long getTimeOfIncrement(StringsHolder  sh, int reps) {
         long start = System.nanoTime();
         for(int i = 0; i < reps; i++)
          sh.set(i,sh.get(i)+1);
         long stop = System.nanoTime();
         return (stop - start)/reps;	
        }
          static long getTimeOfIncrement(ArrayList<Integer> list, int reps) {
         long start = System.nanoTime();
         for(int i = 0; i < reps; i++)
          list.set(i,list.get(i)+1);
         long stop = System.nanoTime();
         return (stop - start)/reps;	
        }
	public static void main(String[] args) {		
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringsHolder sh = new StringsHolder();
		print("Add times (nanoseconds):");
		print("Mean of 1000:");	
		print("ArrayList add(): " + addTimeTest(list, 1000));
		print("StringsHolder add(): " + addTimeTest(sh, 1000));
		print("Mean of 10000:");	
		print("ArrayList add(): " + addTimeTest(list, 10000));
		print("StringsHolder add(): " + addTimeTest(sh, 10000));
		print();
		print("Get times (nanoseconds):");
		print("Mean of 10000:");
		print("ArrayList get(): " + getTimeTest(list, 10000));
		print("StringsHolder get(): " + getTimeTest(sh, 10000));
		print();
                print("Increment times (nanoseconds):");
		print("Mean of 1000:");
		print("ArrayList increment(): " + getTimeOfIncrement(list, 1000));
                print("StringsHolder  increment(): " + getTimeOfIncrement(sh , 1000));	
		print("Using alternate fixed size (1000) StringsHolder2");
		print("eliminates resizing and copying:");
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		StringsHolder2 sh2 = new StringsHolder2();
		print("Add times (nanoseconds):");
		print("Mean of 1000:");	
		print("ArrayList add(): " + addTimeTest(list2, 1000));
		print("StringsHolder2 add(): " + addTimeTest(sh2, 1000));
		print();
		print("Get times (nanoseconds):");
		print("Mean of 1000:");
		print("ArrayList get(): " + getTimeTest(list2, 1000));
		print("StringsHolder2 get(): " + getTimeTest(sh2, 1000));	
                print();
		print("Increment times (nanoseconds):");
		print("Mean of 1000:");
		print("ArrayList increment(): " + getTimeOfIncrement(list2, 1000));
		print("StringsHolder2 increment(): " + getTimeOfIncrement(sh2, 1000));     	
	}
}
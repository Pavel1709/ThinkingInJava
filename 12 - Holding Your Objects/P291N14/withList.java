import java.util.*;
public class withList {
    public static void main(String[] args) {
       Random r = new Random();
       List<Integer> copyLister = new LinkedList<Integer>();
       adder(copyLister , 4);
       adder(copyLister , 5);
       adder(copyLister , 6);
       adder(copyLister , 7);
        adder(copyLister , 8);
       System.out.println(copyLister);
        
    }
    public static void adder(List<Integer> lister, int j) { 
        ListIterator<Integer> it1 = lister.listIterator(Math.round(lister.size()/2));
        it1.add(j);    
    }
}

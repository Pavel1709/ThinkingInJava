mport java.util.*;

 
class A {}
 class SortSet<T> extends LinkedList<T>{
   T t;
   public int compareTo(T t) {
    return (this.t.hashCode() < t.hashCode() ? -1 : (this.t.hashCode() == t.hashCode() ? 0 : 1));
   }
   public boolean add(T t) {
	if(!this.contains(t)) {
	    Iterator<T> it = this.iterator();
		int index = 0;
		while(it.hasNext()) {
                        this.t = it.next();
			if(compareTo(t) < 1) 
			  index++;
			}
			add(index, t);
			return true;
		}
		return false;
	}
}
public class Executor {
    public static void main(String[] args) {
       SortSet<A> ss = new SortSet<A>();
       ss.add(new A());
       ss.add(new A());
       ss.add(new A());	
       ss.add(new A());
       System.out.println(ss);
       SortSet<Integer> ss2 = new SortSet<Integer>();
       ss2.add(6);
       ss2.add(8);
       ss2.add(2);
       ss2.add(4);
       ss2.add(2);
       ss2.add(8);
       System.out.println(ss2);
       SortSet<String> ss3 = new SortSet<String>();
       ss3.add("three");
       ss3.add("thr");
       ss3.add("seven");
       ss3.add("hi");
       ss3.add("two");
       ss3.add("one");
       ss3.add("aa");
       ss3.add("ab");
       ss3.add("bb");
       ss3.add("abb");
       System.out.println(ss3);
    }
    
}
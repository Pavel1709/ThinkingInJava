import java.util.*;
public class Comp  implements Comparable<Comp> {
        String s1;
        String s2;
    Comp(String s1, String s2) {
     this.s1 = s1;
     this.s2 = s2;
    }
    public String toString() {
     return s1 + " " +s1.hashCode() + " "+ s2 +" " + s2.hashCode();
    }
    public static void main(String[] args) {
     List<Comp> al = new ArrayList<Comp>();
     Comp[] ar = new Comp[4];
     al.add(new Comp(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     al.add(new Comp(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     al.add(new Comp(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     al.add(new Comp(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     Collections.sort(al);
     System.out.println("ArrayList " + al);
     for(int i = 0; i < ar.length; i++) {
       ar[i] = new Comp(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next());
     }
     Arrays.sort(ar);
     System.out.println("Array " + Arrays.toString(ar));
     List<Compar> alc = new ArrayList<Compar>();
     Compar[] arc = new Compar[4];
     alc.add(new Compar(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     alc.add(new Compar(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     alc.add(new Compar(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     alc.add(new Compar(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next()));
     Collections.sort(alc,new Compar());
     System.out.println("ArrayList " + alc);
     for(int i = 0; i < arc.length; i++) {
       arc[i] = new Compar(new RandomGenerator.String(5).next(),new RandomGenerator.String(5).next());
     }
     Arrays.sort(arc,new Compar());
     System.out.println("Array " + Arrays.toString(arc));
     Compar key = alc.get(3);
     int index = Collections.binarySearch(alc, key, new Compar());
     System.out.println(index);
    }
    @Override
    public int compareTo(Comp o) {
        return ( s1.hashCode() < o.s1.hashCode() ? -1 : (o.s1.hashCode() == s1.hashCode() ? 0 :  1));
    }
   
}
class Compar implements Comparator<Compar> {
    String s1;
    String s2;
    Compar() {}
    Compar(String s1, String s2) {
     this.s1 = s1;
     this.s2 = s2;
    }
    @Override
    public int compare(Compar o1, Compar o2) {
      return ( o1.s2.hashCode() < o2.s2.hashCode() ? -1 : (o1.s2.hashCode() == o2.s2.hashCode() ? 0 :  1));   
    }
    public String toString() {
     return s1 + " " +s1.hashCode() + " "+ s2 +" " + s2.hashCode();
    }
}
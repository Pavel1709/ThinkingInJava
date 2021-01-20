public class Generator {
 public static ArrayList<String> characters = new ArrayList<String>(Arrays.asList(
  "Gomer Simpson",
  "March Simpson",
  "Bart Simpson",
  "Liza Simpsom",
  "Dog",
  "Cat",
  "Cat")
  );
 
   public static void next(Collection c) {
     
       for (String s: characters) {
           c.add(s);
       }
    }
     

   public static void main(String[] args) {
       ArrayList<String> a = new ArrayList<String>();
       LinkedList<String> l = new LinkedList<String>();
       HashSet<String>  h = new HashSet<String>();
       LinkedHashSet<String> lh = new LinkedHashSet<String>();
       TreeSet<String> t  = new TreeSet<String>();
       next(a);
       next(l);
       next(h);
       next(lh);
       next(t);
       System.out.println(a);
       System.out.println(l);
       System.out.println(h);
       System.out.println(lh);
       System.out.println(t);
       
   }
}
   
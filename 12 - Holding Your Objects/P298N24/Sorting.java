public class Sorting {
 
   static  Map<String, String> notSortedYet = new LinkedHashMap<String, String>(); 
    
    public static void main(String[] args) {
     notSortedYet.put("A"," Should be 1 ");
     notSortedYet.put("F"," Should be 3 ");
     notSortedYet.put("R"," Should be 4");
     notSortedYet.put("E","Should be 2 ");
     notSortedYet.put("W"," Should be  6");
     notSortedYet.put("Z"," Should be  8");
     notSortedYet.put("X"," Should be  7");
     notSortedYet.put("T"," Should be 5 ");
    System.out.println(notSortedYet);
     Map<String, String> keys = new TreeMap<String, String>();
     for( Map.Entry<String, String> pair:  notSortedYet.entrySet() ) {
      keys.put(pair.getKey(), pair.getValue());
     }
     notSortedYet.clear();
     
      notSortedYet.putAll(keys);
      System.out.println(notSortedYet);
    }
    
}

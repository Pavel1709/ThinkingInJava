public class AlternativeArrayOfLinks2 {
 public static void main( String ... args) {

  Elements[] elements = new Elements[]{
   new Elements("First"),
   new Elements("Second"),
   new Elements("Third"),
   new Elements("Forth"),
   new Elements("Fifth"),
  };
 }
}
class Elements {
 Elements(String S) {
  System.out.println(S);
 }
}
 
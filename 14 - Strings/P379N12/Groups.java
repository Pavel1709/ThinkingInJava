//: strings/Groups.java
import java.util.regex.*;
import java.util.*;
import static net.mindview.util.Print.*;
public class Groups {
 static public final String POEM = "Twas brillig, and the slithy toves\n" + "Did gyre and gimble in the wabe.\n" + "All mimsy were the borogoves,\n" + "And the mome raths outgrabe.\n\n" + "Beware the Jabberwock, my son,\n" + "The jaws that bite, the claws that catch.\n" + "Beware the Jubjub bird, and shun\n" + "The frumious Bandersnatch.";
 public static void main(String[] args) {
  Set<String> unique = new HashSet<String>();       
  Matcher m = Pattern.compile("(?m)(\\s+\\p{Lower}+)(\\s+ || $)").matcher(POEM);
  while(m.find()) { 
    unique.add("[" + m.group() + "]");
  }
  System.out.println(unique);
 }
} /* Output:
[the slithy toves][the][slithy toves][slithy][toves]
[in the wabe.][in][the wabe.][the][wabe.]
[were the borogoves,][were][the borogoves,][the][borogoves,] [mome raths outgrabe.][mome][raths outgrabe.][raths][outgrabe.] [Jabberwock, my son,][Jabberwock,][my son,][my][son,]
[claws that catch.][claws][that catch.][that][catch.]
[bird, and shun][bird,][and shun][and][shun]
[The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
*///:~
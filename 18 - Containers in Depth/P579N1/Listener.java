import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public class Listener {
 public static void main(String[] args) {     
  List<String> countryArList = new ArrayList<String>(Countries.names(10));
  List<String> countryLiList = new LinkedList<String>(Countries.names(10));
  Collections.sort(countryArList);
  Collections.sort(countryLiList);
  for (int i = 0; i <10; i ++) {
   Collections.shuffle(countryArList);
   System.out.println("ArList " +countryArList);
  }
  for (int i = 0; i <10; i ++) {
   Collections.shuffle(countryLiList);
   System.out.println("LiList " + countryLiList);
  }
 }
}
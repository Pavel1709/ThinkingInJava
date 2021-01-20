import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public class SetTest {
 public static void main(String[] args) {
  Set<String> aCousTreeSet = new TreeSet<String>(Countries.names(Countries.DATA.length));
  Set<String> aCousHashSet = new HashSet<String>(Countries.names(Countries.DATA.length));
  Set<String> aCousLinkedHashSet = new LinkedHashSet<String>(Countries.names(Countries.DATA.length));
  aCousTreeSet.addAll(aCousTreeSet);
  aCousHashSet.addAll(aCousHashSet);
  aCousLinkedHashSet.addAll(aCousLinkedHashSet);
  print(aCousTreeSet);
  print(aCousHashSet);
  print(aCousLinkedHashSet);
 }
}
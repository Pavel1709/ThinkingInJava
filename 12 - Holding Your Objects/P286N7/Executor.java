import java.util.*;
class Tip  {
 int number = 0;
 Tip() {
  number++;
 }
}
public class Executor {
 public static void main(String[] args) {
 Tip [] tips = new Tip[]{
  new Tip(),
  new Tip(),
  new Tip(),
  new Tip(),
  new Tip(),
 };
 List<Tip> tipses = new ArrayList<Tip>();
 System.out.println(tipses);
 tipses.addAll(Arrays.asList(tips));
 System.out.println(tipses);
 List<Tip> subTipses =  tipses.subList(1,3);
 System.out.println(subTipses);
 tipses.removeAll(subTipses);
 System.out.println(tipses);
 }
}
 
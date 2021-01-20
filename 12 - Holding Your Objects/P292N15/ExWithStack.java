import net.mindview.util.*;
public class ExWithStack {
 public static void main(String[] args) {
  Stack<String> stack = new Stack<String>();
  String[] c = "+U+n+c—+e+r+t—+a-+i-+n+t+y—+ -+r+u—+l+e+s—".split("");
  for (int i = 0; i < c.length; i++) {
    if (c[i].equals("+")) {
      stack.push(c[i+1]);
    }
    if(c[i].equals("—")) {
        System.out.println(stack.pop());
    }
  }
 }
}
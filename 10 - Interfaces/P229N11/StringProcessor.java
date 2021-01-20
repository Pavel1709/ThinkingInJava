
import java.util.*;

public abstract class StringProcessor implements Processor {
 public String name() {
  return getClass().getSimpleName();
 }
 public abstract String process(Object input);
 public static String s = "If she weighs the same as a duck, she is made of wood.";
 public static void main(String[] args) {
  Apply.process(new Upcase(), s);
  Apply.process(new Downcase(), s);
  Apply.process(new Splitter(), s);
  Apply.process(new Perest(), s);
 }
}
class Upcase extends StringProcessor {
 public String process(Object input) {
  return ((String)input).toUpperCase();
 }
}
class Downcase extends StringProcessor {
 public String process(Object input) {
  return ((String)input).toLowerCase();
 }
}
class Splitter extends StringProcessor {
 public String process(Object input) {
  return Arrays.toString(((String)input).split(" "));
 }
}
class Perest extends StringProcessor {
 public String process(Object input) {
  String[] ss = ((String)input).split("");
  String sss = "";
  for (int i = 0; i <  ss.length; i+=2) {
    String l = ss[i];
    ss[i] = ss[i+1];
    ss[i+1] = l;
    sss+= ss[i] +ss[i+1];
  }
    return sss;
  }
}
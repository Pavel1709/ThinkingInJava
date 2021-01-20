final class Basic {
 int b = 7;
 String c = "No way";
 private int finalniy() {
  return b;
 }
}
public class InheriFinal extends Basic {
 static int l;
 public static void main() {
  l = finalniy();
 }
}
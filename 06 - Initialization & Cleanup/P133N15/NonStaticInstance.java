public class NonStaticInstance {
String s;
{
 s = "Something";
 System.out.println(s);
}
 public static void main(String[] args) {
  NonStaticIn nsi = new NonStaticIn();
 }
}
public class ProtectedDATA {
 public static void main(String[] args) { 
  ProtectedDATA pd = new ProtectedDATA();
  pd.workWithProtect();
 }
 void workWithProtect() {
  Protect prtct = new Protect();
  int k = prtct.l + prtct.m;
  System.out.println(k);
  prtct.protectedMethod();
 }
}
class Protect {
 protected int l = 7;
 protected int m = 5;
 protected void protectedMethod() {
  int n = l - m;
  System.out.println(n);
 }
}
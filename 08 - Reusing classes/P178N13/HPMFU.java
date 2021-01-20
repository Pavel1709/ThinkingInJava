 class MFU {
 public String work(String c) {
  System.out.println("Printing");
  return c;
 }
 public int work(int i) {
  System.out.println("Scaning");
  return i;
 }
 public long work(long l) {
  System.out.println("Xeroxing");
  return l;
 }
}
public class HPMFU extends MFU {
  public float work(float f) {
  System.out.println("HP is working");
  return f;
 }
 public static void main(String[] args) {
  HPMFU h = new HPMFU();
  h.work(1.1f);
  h.work(10000000000000000L);
  h.work(5);
  h.work("");
 }
}
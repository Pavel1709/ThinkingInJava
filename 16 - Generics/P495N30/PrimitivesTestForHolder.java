public class PrimitivesTestForHolder {
 public static void main(String[] args) {
  Holder<Integer> intgr = new Holder<Integer>();
  int i = 7;
  intgr.set(i);
  int j =intgr.get();
  System.out.println(j);
  Holder<Character> chrctr = new Holder<Character>();
  char c = 50;
  chrctr.set(c);
  char cc = chrctr.get();
  System.out.println(cc);
  Holder<Boolean> bln = new Holder<Boolean>();
  boolean b = true;
  bln.set(b);
  boolean bb = bln.get();
  System.out.println(bb);
  Holder<Byte> bt = new Holder<Byte>();
  byte bait = 1;
  bt.set(bait);
  byte bbait = bt.get();
  System.out.println(bbait);
  Holder<Double> dbl = new Holder<Double>();
  double d = 4.44;
  dbl.set(d);
  double dd = dbl.get();
  System.out.println(dd);
  Holder<Float> flt = new Holder<Float>();
  float f = 5.55f;
  flt.set(f);
  double ff = flt.get();
  System.out.println(ff);
  Holder<Long> lng = new Holder<Long>();
  long l = 555L;
  lng.set(l);
  long ll = lng.get();
  System.out.println(ll);
  Holder<Short> shrt = new Holder<Short>();
  short s = 1;
  shrt.set(s);
  short ss = shrt.get();
  System.out.println(ss);
 }
}
class Access {
 public int i1 = 1;
 protected int i2 = 2;
 int i3 = 3;
 private int i4 = 4;
 public void meth1() {
  System.out.println("i1 through meth1 " + i1);
  System.out.println("i2 through meth1 " + i2);
  System.out.println("i3 through meth1 " + i3);
  System.out.println("i4 through meth1 " + i4);
  System.out.println();
 }
 protected void meth2() {
  System.out.println("i1 through meth2 " + i1);
  System.out.println("i2 through meth2 " + i2);
  System.out.println("i3 through meth2 " + i3);
  System.out.println("i4 through meth2 " + i4);
  System.out.println();
 }
 void meth3() {
  System.out.println("i1 through meth3 " + i1);
  System.out.println("i2 through meth3 " + i2);
  System.out.println("i3 through meth3 " + i3);
  System.out.println("i4 through meth3 " + i4);
  System.out.println();
  }
 private void meth4() {
  System.out.println("i1 through meth4 " + i1);
  System.out.println("i2 through meth4 " + i2);
  System.out.println("i3 through meth4 " + i3);
  System.out.println("i4 through meth4 " + i4);
  System.out.println(); 
 }
}
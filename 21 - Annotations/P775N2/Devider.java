//: annotations/Devider.java
// APT-based annotation processing.
 

@ExtractInterface("IDevider")
public class Devider {
  public int devide(int x, int y) {
    int total = 0;
    do {    
      total++;
    } while ( (x = minus(x, y)) >= y);
     System.out.println(x + " в остатке");
    return total;
    
  }
  private int minus(int x, int y) { return x - y; }
  public static void main(String[] args) {
    Devider m = new Devider();
    System.out.println("100/5 = " + m.devide(101, 5));
  }
} /* Output:
11*16 = 176
*///:~

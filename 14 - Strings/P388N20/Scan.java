import java.util.*;
public class Scan {
 int i;
 long l;
 float f;
 double d;
 String s;

 Scan(String ss) {
  String mas[] = ss.split(" ");
  i = Integer.parseInt(mas[0]);
  l = Long.parseLong(mas[1]);
  f = Float.parseFloat(mas[2]);
  d = Double.parseDouble(mas[3]);
  s = mas[4];
 }
 public String toString() {
     return i + " " + l +" " + f + " " + d+ " " + s; 
 } 
 public static void main(String[] args) {
   System.out.println("Введите следующие значения через пробел: int long  float double String");
   Scanner sc = new Scanner(System.in);
   String ss = sc.nextLine();
   Scan scan = new Scan(ss);
   System.out.println(scan);
 }
}
  
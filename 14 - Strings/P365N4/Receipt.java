//: strings/Receipt.java 
import java.util.*;
public class Receipt {
 private double total = 0;
 private static final int A = 15;
 private static final int B =  5;
 private static final int C = 10;
  private String s1 = "%-" + A + "s " + "%" + B + "s " + "%" + C + "s\n";
  private String s2 = "%-" + A + ".15s %" + B + "d %" + C + ".2f\n";
  private String s3 = "%-" + A + ".15s %" + B + "s %" + C + ".2f\n";
 private Formatter f = new Formatter(System.out); 
 public void printTitle() {
  f.format(s1, "Item", "Qty", "Price");
  f.format(s1, "----", "---", "-----"); 
 }
 public void print(String name, int qty, double price) {
  f.format(s2, name, qty, price);
  total += price; 
 }
 public void printTotal() {
  f.format(s3, "Tax", "", total*0.06); 
  f.format(s1, "", "", "-----"); 
  f.format(s3, "Total", "", total * 1.06); }
 public static void main(String[] args) {
  Receipt receipt = new Receipt(); 
  receipt.printTitle();
  receipt.print("Jack’s Magic Beans", 4, 4.25); 
  receipt.print("Princess Peas", 3, 5.1); 
  receipt.print("Three Bears Porridge", 1, 14.29); 
  receipt.printTotal();
}
}
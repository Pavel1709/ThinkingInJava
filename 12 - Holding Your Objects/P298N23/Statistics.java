//: holding/Statistics.java
// Simple demonstration of HashMap. 
import java.util.*;
public class Statistics {
  public static void main(String[] args) {
   System.out.println("Хотите провести тест?(Да или Нет)");
   Scanner s = new Scanner(System.in);
   Random rand = new Random(47);
   Map<Integer,Integer> m = new HashMap<Integer,Integer>();  
   String jel = s.nextLine();
   while (jel.equals("Да")) {
    int cif = 0;
    int maxVal = 0;
    for(int i = 0; i < 10000; i++) {
     // Produce a number between 0 and 20:
     int r = rand.nextInt(20);
     Integer freq = m.get(r);
     m.put(r, freq == null ? 1 : freq + 1);
    }
    for (int l = 0; l < m.keySet().size(); l++) {
     
      if (m.get(l) > maxVal) {
       cif = l;
       maxVal=m.get(l);
       }
    }
    System.out.println(m); 
    System.out.println("Чаще всего повторяется "+ cif + "("+ maxVal + "раз)");
    System.out.println("Хотите провести еще один тест?(Да или Нет)"); 
    jel = s.nextLine();
    m.clear();
    cif = 0;
     maxVal = 0;
   }
  }
}
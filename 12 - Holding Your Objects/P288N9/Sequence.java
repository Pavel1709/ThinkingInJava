import java.util.*;
public class Sequence { 
 int value;
 public Sequence(int o) {
  this.value = o;
 }
 int getVal() {
     return value;
 }
 public static void main(String[] args) { 
 
  ArrayList<Sequence> sequence = new ArrayList<Sequence>(); 
  for(int i = 0; i < 10; i++)
   sequence.add(new Sequence(i)); 
   Iterator itit = sequence.iterator();
   while( itit.hasNext()) {
    Sequence s = (Sequence) itit.next();
    System.out.println(s.value);
    }
  }
}
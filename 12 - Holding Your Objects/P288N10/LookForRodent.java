 import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

 
class Rodent {
 public void rod() {
  System.out.println("Грызун");
 }
 static public Rodent ret(Rodent rodent) {
  return rodent;
 }
 public String toString() {
  return "Rodent";
 }
}
class Mouse extends Rodent{
 public void rod() {
  System.out.println("Мышь");
 }

 public String toString() {
  return "Mouse";
 }
}
class Hamster extends Rodent{
 public void rod() {
  System.out.println("Хомяк");
 }

 public String toString() {
  return "Hamster";
 }
}
class Vole extends Rodent{
 public void rod() {
  System.out.println("Полевка");
 }

 public String toString() {
  return "Vole";
 }
}
public class LookForRodent {
 public static void main(String[] args) {
  ArrayList<Rodent> rodents = new ArrayList<Rodent>(Arrays.asList(new Mouse(),new Hamster(),new Vole()));
  Iterator<Rodent> iter = rodents.iterator();
  while (iter.hasNext()) {
   Rodent i =   iter.next();
   i.rod();
   System.out.println(Rodent.ret(i));
  }
 }
}

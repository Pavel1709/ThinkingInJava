 interface Rodent {
 public void rod();
 static public Rodent ret(Rodent rodent) {
  return rodent;
 }

}
class Mouse implements Rodent{
 public void rod() {
  System.out.println("Мышь");
 }

 public String toString() {
  return "Mouse";
 }
}
class Hamster implements Rodent{
 public void rod() {
  System.out.println("Хомяк");
 }

 public String toString() {
  return "Hamster";
 }
}
class Vole implements Rodent{
 public void rod() {
  System.out.println("Полевка");
 }

 public String toString() {
  return "Vole";
 }
}
public class LookForRodent {
 public static void main(String[] args) {
  Rodent[] rodents = {
   new Mouse(),
   new Hamster(),
   new Vole(),
  };
  for(Rodent i: rodents) {
  i.rod();
  System.out.println(Rodent.ret(i));
  }
 }
}

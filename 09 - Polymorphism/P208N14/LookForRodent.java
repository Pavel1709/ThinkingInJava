class Characteristics  {
 private static long counter = 0;
 private final long id = counter++;
 Characteristics() {
  System.out.println("Creating" + this);
 }
 public String toString() {
  return "Characteristic" + id;
 }
}
 class Rodent {
  Characteristics c = new Characteristics();
  //Rodent r = new Rodent();
  //Mouse m = new Mouse();
  //Hamster h = new Hamster();
  //Vole v = new Vole();
  Rodent() {
   System.out.println("Object rodent");
  }
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
 Characteristics c = new Characteristics();

 //Rodent r = new Rodent();
 //Mouse m = new Mouse();
 //Hamster h = new Hamster();
 //Vole v = new Vole();
 Mouse() {
  System.out.println("Object mouse");
 }
 public void rod() {
  System.out.println("Мышь");
 }

 public String toString() {
  return "Mouse";
 }
}
class Hamster extends Rodent{
 Characteristics c = new Characteristics();
  //Rodent r = new Rodent();
   Mouse m = new Mouse();
  //Hamster h = new Hamster();
  // Vole v = new Vole();
 Hamster() {
  System.out.println("Object Hamster");
 }
 public void rod() {
  System.out.println("Хомяк");
 }

 public String toString() {
  return "Hamster";
 }
}
class Vole extends Rodent{
 Characteristics c = new Characteristics();
  //Rodent r = new Rodent();
   Mouse m = new Mouse();
   Hamster h = new Hamster();
  //Vole v = new Vole();
  Vole() {
  System.out.println("Object Vole");
 }
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

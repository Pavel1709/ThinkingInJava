 class Rodent {
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
 public void finalize() {
   System.out.println("Rodent finalized");
  }
 static public Rodent ret(Rodent rodent) {
  return rodent;
 }
 public String toString() {
  return "Rodent";
 }
}
class Mouse extends Rodent{
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
  public void finalize() {
   System.out.println("Mouse finalized");
  }
}
class Hamster extends Rodent{
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
 public void finalize() {
   System.out.println("Hamster finalized");
  }
}
class Vole extends Rodent{
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
  public void finalize() {
   System.out.println("Vole finalized");
  }
}
class Fin {
 public void finalize() {
  System.out.println("Checked");
 }
}
public class LookForRodent {
public void finalize() {
   System.out.println("Vole finalized");
  }
 public static void main(String[] args) {
  Rodent[] rodents = {
   new Mouse(),
   new Hamster(),
   new Vole(),
  };
  for(Rodent i: rodents) {
  i.rod();
  System.out.println(Rodent.ret(i));
  //i.finalize();
   System.gc();
    }
   new Fin();
   new Mouse();
   new Hamster();
   new Vole();
   System.gc();


 }
}

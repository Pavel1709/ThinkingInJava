  enum Wheels {
 Unicycle, Bicycle, Tricycle;
}
 class Cycle {
 public void riding(Wheels w) {
  System.out.println("Ride");
 }
 
}
 class Unicycle extends Cycle {
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
 }
 public void balance() {
  System.out.println("Unicycle.Balance");
 }
}
 class Bicycle extends Cycle {
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
 }
 public void balance() {
  System.out.println("Bicycle.Balance");
 }
}
 class Tricycle extends Cycle {
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
 }
}
public class Ride {

 
 public void LetsRide(Cycle c) {
  if (c.getClass().toString().charAt(6) == 'U' ) {
   c.riding(Wheels.Unicycle);
  }
  else  if (c.getClass().toString().charAt(6) == 'B' ) {
   c.riding(Wheels.Bicycle);
  }
  else if (c.getClass().toString().charAt(6) == 'T' ) {
   c.riding(Wheels.Tricycle);
  }
 }
 public static void main(String[] args) {
  Cycle[] c = {
  new Unicycle(),
  new Bicycle(),
  new Tricycle(),
  };
 ((Unicycle)c[0]).balance(); // здесь надо выполнить нисходящее преобразоваине, то есть преобразование от базового типа к производному(вниз по иерархии)
 ((Bicycle)c[1]).balance(); // здесь надо выполнить нисходящее преобразоваине, то есть преобразование от базового типа к производному(вниз по иерархии)
 // c[2].balance(); //здесь не выполнится, так как такого метода просто навсего нет
 Ride r = new Ride();
 Unicycle u = new Unicycle();
 r.LetsRide(u);
 }
}
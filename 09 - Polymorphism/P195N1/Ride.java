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
}
 class Bicycle extends Cycle {
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
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
 Ride r = new Ride();
 Unicycle u = new Unicycle();
 r.LetsRide(u);
 }
}
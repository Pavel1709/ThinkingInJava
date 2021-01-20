  enum Wheels {
 Unicycle, Bicycle, Tricycle;
}
 class Cycle {
 int amountOfWheels;
 public void riding(Wheels w) {
  System.out.println("Ride");
 }
 public int wheels() {
  return amountOfWheels;
 }
}
 class Unicycle extends Cycle {
  int amountOfWheels = 1;
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
  System.out.println(wheels());
 }
  public int wheels() {
  return amountOfWheels;
 }
}
 class Bicycle extends Cycle {
  int amountOfWheels = 2;
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
  System.out.println(wheels());
 }
  public int wheels() {
  return amountOfWheels;
 }
}
 class Tricycle extends Cycle {
  int amountOfWheels = 3;
 public void riding(Wheels w) {
  System.out.println("Ride "+w);
   System.out.println(wheels());
 }
  public int wheels() {
  return amountOfWheels;
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
 Tricycle t = new Tricycle();

 r.LetsRide(u);
 r.LetsRide(t);
 }
}
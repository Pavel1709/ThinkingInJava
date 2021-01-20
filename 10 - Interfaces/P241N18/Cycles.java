enum Wheels {
 Unicycle, Bicycle, Tricycle;
}
interface Cycle {
 void riding();
}
interface CycleFactory {
 Cycle getCycle();
}
 class Bicycle implements Cycle{
 public void riding() {
  System.out.println("Ride "+Wheels.Bicycle);
 }
}
 class Unicycle implements Cycle{
 public void riding() {
  System.out.println("Ride "+Wheels.Unicycle);
 }
}
 class Tricycle implements Cycle{
 public void riding() {
  System.out.println("Ride "+Wheels.Tricycle);
 }
}
 class BicycleFactory implements CycleFactory {
 public Cycle getCycle() {
  return new Bicycle();
 }
}
 class UnicycleFactory implements CycleFactory {
 public Cycle getCycle() {
  return new Unicycle();
 }
}
 class TricycleFactory implements CycleFactory {
 public Cycle getCycle() {
  return new Tricycle();
 }
}
public class Cycles {
 public static void letsRide(CycleFactory cf) {
  Cycle c = cf.getCycle();
  c.riding();
 }
 public static void main(String[] args) {
  letsRide(new TricycleFactory());
  letsRide(new UnicycleFactory());
  letsRide(new BicycleFactory());
 }
}

 
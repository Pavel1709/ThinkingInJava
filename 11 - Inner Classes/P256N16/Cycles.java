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
 static CycleFactory bicycleFactory = new CycleFactory() {
  public Cycle getCycle() {
   return new Bicycle();
  }
 };
}
 class Unicycle implements Cycle{
 public void riding() {
  System.out.println("Ride "+Wheels.Unicycle);
 }
 static CycleFactory unicycleFactory = new CycleFactory() {
  public Cycle getCycle() {
   return new Unicycle();
  } 
 };
}
 class Tricycle implements Cycle{
 public void riding() {
  System.out.println("Ride "+Wheels.Tricycle);
 }
 static CycleFactory tricycleFactory = new CycleFactory() {
  public Cycle getCycle() {
   return new Tricycle();
  } 
 };
}
public class Cycles {
 public static void letsRide(CycleFactory cf) {
  Cycle c = cf.getCycle();
  c.riding();
 }
 public static void main(String[] args) {
  letsRide(Tricycle.tricycleFactory );
  letsRide(Unicycle.unicycleFactory );
  letsRide(Bicycle.bicycleFactory );
 }
}

 
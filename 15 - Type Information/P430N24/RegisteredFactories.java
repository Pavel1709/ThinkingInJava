//: typeinfo/RegisteredFactories.java
// Registering Class Factories in the base class.
import typeinfo.factory.*;
import java.util.*;
import net.mindview.util.*;
class Part {
 public String toString() {
  return getClass().getSimpleName(); 
 }
 static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
 static {
  // Collections.addAll() gives an "unchecked generic 
  // array creation ... for varargs parameter" warning. 
  partFactories.add(new FuelFilter.Factory()); 
  partFactories.add(new AirFilter.Factory()); 
  partFactories.add(new CabinAirFilter.Factory()); 
  partFactories.add(new OilFilter.Factory()); 
  partFactories.add(new FanBelt.Factory()); 
  partFactories.add(new PowerSteeringBelt.Factory());
  partFactories.add(new GeneratorBelt.Factory());
 }
 private static Random rand = new Random(47); 
 public static Part createRandom() {
  int n = rand.nextInt(partFactories.size());
  return partFactories.get(n).create(); 
 }
}
class Filter extends Part {}
class FuelFilter extends Filter {
 // Create a Class Factory for each specific type: 
 public static class Factory implements typeinfo.factory.Factory<FuelFilter> {
    public FuelFilter create() { return new FuelFilter(); }
  }
}
class AirFilter extends Filter {
 public static class Factory implements typeinfo.factory.Factory<AirFilter> {
    public AirFilter create() { return new AirFilter(); }
  }
 public static class NullAirFilter extends AirFilter implements Null {
   public static class Factory implements typeinfo.factory.Factory<NullAirFilter> {
    public NullAirFilter create() { return new NullAirFilter(); }
  }
 }
}
class CabinAirFilter extends Filter {
 public static class Factory implements typeinfo.factory.Factory<CabinAirFilter> {
    public CabinAirFilter create() {
      return new CabinAirFilter();
    }
 }
 public static class NullCabinAirFilter extends CabinAirFilter implements Null {
   public static class Factory implements typeinfo.factory.Factory<NullCabinAirFilter> {
    public NullCabinAirFilter create() { return new NullCabinAirFilter(); }
  }
 }
}
class OilFilter extends Filter {
 public static class Factory implements typeinfo.factory.Factory<OilFilter> {
    public OilFilter create() { return new OilFilter(); }
 }
 public static class NullOilFilter extends OilFilter implements Null {
   public static class Factory implements typeinfo.factory.Factory<NullOilFilter> {
    public NullOilFilter create() { return new NullOilFilter(); }
  }
 }
}
class Belt extends Part {}
class FanBelt extends Belt {
 public static class Factory implements typeinfo.factory.Factory<FanBelt> {
    public FanBelt create() { return new FanBelt(); }
 }
 public static class NullFanBelt extends FanBelt implements Null {
   public static class Factory implements typeinfo.factory.Factory<NullFanBelt> {
    public NullFanBelt create() { return new NullFanBelt(); }
  }
 }
}
class GeneratorBelt extends Belt {
 public static class Factory implements typeinfo.factory.Factory<GeneratorBelt> {
    public GeneratorBelt create() {
      return new GeneratorBelt();
    } 
 }
 public static class NullGeneratorBelt extends GeneratorBelt implements Null {
   public static class Factory implements typeinfo.factory.Factory<NullGeneratorBelt> {
    public NullGeneratorBelt create() { return new NullGeneratorBelt(); }
  }
 }
}
class PowerSteeringBelt extends Belt {
public static class Factory
implements typeinfo.factory.Factory<PowerSteeringBelt> {
    public PowerSteeringBelt create() {
      return new PowerSteeringBelt();
    }
 } 
 public static class NullPowerSteeringBelt extends PowerSteeringBelt implements Null {
   public static class Factory implements typeinfo.factory.Factory<NullPowerSteeringBelt> {
    public NullPowerSteeringBelt create() { return new NullPowerSteeringBelt(); }
  }
 }
}
public class RegisteredFactories {
  public static void main(String[] args) {
   for(int i = 0; i < 10; i++) 
   System.out.println(Part.createRandom());
  }
} /* Output: GeneratorBelt CabinAirFilter GeneratorBelt AirFilter PowerSteeringBelt CabinAirFilter FuelFilter PowerSteeringBelt PowerSteeringBelt FuelFilter
*///:~
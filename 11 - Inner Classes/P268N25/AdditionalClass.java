import innerclasses.controller.*;
public class AdditionalClass extends GreenhouseControls{
 private boolean uvlazhneno = false;
 public class vklUvlazh extends Event {
  public vklUvlazh(long delayTime) {
   super(delayTime);
  }
  public void action() {
   uvlazhneno = true;
  }
  public String toString() {
   return "Система увылажнения запущена";
  }
 }
  public class ViklUvlazh extends Event {
  public ViklUvlazh(long delayTime) {
   super(delayTime);
  }
  public void action() {
   uvlazhneno = false;
  }
  public String toString() {
   return "Система увлажнения выключена";
  }
 }
}
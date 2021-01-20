//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
 
import java.util.*;
import java.io.*;
public class GreenhouseController {
  public static void main(String[] args) throws IOException{
    GreenhouseControls gc = new GreenhouseControls();
    BufferedReader in = new BufferedReader(new FileReader("file.txt"));
    HashMap<String, Long> hm = new HashMap<String, Long>();
    String s;
    Event[] e = new Event[1];
    while((s = in.readLine()) != null) {
     String[] els = new String[2];
     els = s.split(" ");
     hm.put(els[0], Long.parseLong(els[1]));
     els = new String[2];
    }
    for(Map.Entry<String, Long> pair: hm.entrySet()) {
     if (pair.getKey().equals("Bell")) {
      gc.addEvent(gc.new Bell(pair.getValue()));
     }
     if (pair.getKey().equals("ThermostatNight")) {
      gc.addEvent(gc.new ThermostatNight(pair.getValue()));
     }
     if (pair.getKey().equals("LightOn")) {
      gc.addEvent(gc.new LightOn(pair.getValue()));
     }
     if (pair.getKey().equals("LightOff")) {
      gc.addEvent(gc.new LightOff(pair.getValue()));
     }
     if (pair.getKey().equals("WaterOn")) {
      gc.addEvent(gc.new WaterOn(pair.getValue()));
     }
     if (pair.getKey().equals("WaterOff")) {
      gc.addEvent(gc.new WaterOff(pair.getValue()));
     }
     if (pair.getKey().equals("ThermostatDay")) {
      gc.addEvent(gc.new ThermostatDay(pair.getValue()));
     }
 
    }
    if(args.length == 1)
      gc.addEvent(
        new GreenhouseControls.Terminate(
          new Integer(args[0])));
    gc.run();
  }
}  
//: interfaces/music5/Music5.java
// Interfaces.
 
import static net.mindview.util.Print.*;
enum Note {
 HIGH_A,LOW_B,MIDDLE_C
}

interface Instrument  {
 // Compile-time constant:
 int VALUE = 5; // static & final
 // Cannot have method definitions:
 void play(Note n); // Automatically public void adjust();
 void adjust();
 // toString неразумно переносить в интерфейс, поскольку это не его метод, а метоод Object'a
}
abstract class Music implements Instrument {
   public void play(Note n) {
   print(this + ".play() " + n); 
  }
  public void adjust() { 
   print(this + ".adjust()"); 
  } 
}
class Wind extends Music {
 
  public String toString() { 
   return "Wind"; 
  }

}
class Percussion extends Music {

  public String toString() { 
   return "Percussion"; 
  }

}
class Stringed extends Music {

  public String toString() { 
   return "Stringed"; 
  }

}
class Brass extends Wind {
 public String toString() { 
  return "Brass"; 
 }
}
class Woodwind extends Wind {
 public String toString() { 
  return "Woodwind"; 
 }
}
public class Music5 {
 // Doesn’t care about type, so new types // added to the system still work right: 
 static void tune(Instrument i) {
  // ...
  i.play(Note.MIDDLE_C); 
 }
 static void tuneAll(Instrument[] e) {
    for(Instrument i : e)
     tune(i); 
 }
 public static void main(String[] args) {
 // Upcasting during addition to the array: 
 Instrument[] orchestra = {
  new Wind(),
  new Percussion(), 
  new Stringed(),
  new Brass(),
  new Woodwind()
 };
 tuneAll(orchestra);
  }
}
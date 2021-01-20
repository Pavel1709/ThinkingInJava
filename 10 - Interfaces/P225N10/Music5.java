//: interfaces/music5/Music5.java
// Interfaces.


import static net.mindview.util.Print.*;
interface Instrument {
 int VALUE = 5; // static & final 
}
interface Playable  {
  void play(Note n);

}
class Wind implements Instrument , Playable {
  public void play(Note n) {
   print(this + ".play() " + n);
  }
  public String toString() { 
   return "Wind"; 
  }
  public void adjust() { 
   print(this + ".adjust()"); 
  } 
}
class Percussion implements Instrument, Playable {
  public void play(Note n) {
   print(this + ".play() " + n); 
  }
  public String toString() { 
   return "Percussion";
  }
  public void adjust() { 
   print(this + ".adjust()"); 
  } 
}
class Stringed implements Instrument, Playable {
  public void play(Note n) {
   print(this + ".play() " + n); 
  }
  public String toString() { 
   return "Stringed"; 
  }
  public void adjust() { 
   print(this + ".adjust()"); 
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
 static void tune(  Playable i) {
  // ...
  i.play(Note.MIDDLE_C); 
 }
 static void tuneAll(  Playable[] e) {
  for(  Playable i : e)
  tune(i); 
 }
 public static void main(String[] args) {
  // Upcasting during addition to the array:
   Playable[] orchestra = {
   new Wind(),
   new Percussion(),
   new Stringed(),
   new Brass(),
   new Woodwind()
    };
    tuneAll(orchestra);
  }
}
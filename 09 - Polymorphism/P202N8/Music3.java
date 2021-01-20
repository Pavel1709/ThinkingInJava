import static net.mindview.util.Print.*;
import java.util.Random;
 enum Note {
 MIDDLE_C, MIDDLE_B, MIDDLE_A ;
}
class Instrument {
 void play(Note n) { 
  print("Instrument.play() " + n);
 }
 @Override
 public String toString() { 
  return "Instrument";
 }
 void adjust() {
  print("Adjusting Instrument");
 }
}
class Accordion extends Instrument {
 void play(Note n) { 
  print("Accordion.play() " + n); 
 }
 @Override
 public String toString() {
  return "Accordion";
 }
}
class Wind extends Instrument {
 void play(Note n) { 
  print("Wind.play() " + n); 
 }
 @Override
 public String toString() {
  return "Wind";
 }
 void adjust() {
  print("Adjusting Wind"); 
 }
}
class Percussion extends Instrument {
 void play(Note n) { 
  print("Percussion.play() " +n);
 } 
 @Override
 public String toString() { 
  return "Percussion";
 }
 void adjust() {
  print("Adjusting Percussion"); }
}
class Stringed extends Instrument {
 void play(Note n) { 
  print("Stringed.play() " + n);
 } 
 @Override
 public String toString() { 
  return "Stringed"; 
 }
 void adjust() { 
  print("Adjusting Stringed"); 
 }
}
class Brass extends Wind {
 void play(Note n) { 
  print("Brass.play() " + n); 
 } 
 void adjust() { 
  print("Adjusting Brass");
 }
}
class Woodwind extends Wind {
 void play(Note n) {
  print("Woodwind.play() " + n);
 }
 @Override
 public String toString() { 
  return "Woodwind"; 
 }
}
public class Music3 {
  static Instrument[] orchestra = {
    new Wind(),
    new Percussion(),
    new Stringed(), 
    new Brass(),
    new Woodwind(),
    new Accordion(),
  };
// Doesn’t care about type, so new types // added to the system still work right:
 public static void tune(Instrument i) {

 i.play(Note.MIDDLE_C); 
}
  public static void tuneSomething() {
    Random ran = new Random();
    int i = ran.nextInt(6);
     tune(orchestra[i]);
     System.out.println(orchestra[i]);
    
  }
  public static void main(String[] args) {
   // Upcasting during addition to the array:
  
    for ( int j = 0; j < 7; j++) 
    tuneSomething();
  }
} /* Output:
Wind.play() MIDDLE_C Percussion.play() MIDDLE_C Stringed.play() MIDDLE_C Brass.play() MIDDLE_C Woodwind.play() MIDDLE_C *///:~

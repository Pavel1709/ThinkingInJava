class Dog  {
 void play() {
   System.out.println("Dog is playing");
 }
}
public class Human {
 static void readyToPlay() {
  Human h = new Human();
  h.play = "Ready to play";
 }
 static String play;
 public static void main(String[] args) {
  Dog ovcharka;
  play=" Not ready to play ";
  readyToPlay();  
   if (play == "Ready to play") {
    ovcharka = new Dog();
    ovcharka.play();
   }
 }
 
}
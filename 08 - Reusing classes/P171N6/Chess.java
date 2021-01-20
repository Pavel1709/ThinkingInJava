import static net.mindview.util.Print.*;
class Game {
  Game(int i) {
   print("Game constructor"); 
  }
}
class BoardGame extends Game {
 BoardGame(int i) {
  //super(i) //Constructor Game in class Game cannot be applied to given types, по сути, если есть обращение к конструктору наследника, то и есть обращение к конструктору базового класса, а если учесть, что в конструкторе родительского класса у нас параметр(ы), то без явного обращения с указанием передаваемого значения у нас происходит обращения без передачи значений, поэтому такой конструктор не находится.
  print("BoardGame constructor"); 
  //super(i); //error: call to super must be first statement in constructor
 }
}
public class Chess extends BoardGame {
 Chess() {
  super(11);
  print("Chess constructor"); }
 public static void main(String[] args) { 
  Chess x = new Chess();
 }
}
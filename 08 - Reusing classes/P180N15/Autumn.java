import one.Tree;
public class Autumn {
 public static void main(String [] args) {
  Tree tree = new Tree();
  tree.fallOff();// не вызывается, так как класс Autumn находится вне пакета и не наследует класс Tree --- error: fallOff() has protected access in Tree

 }
}
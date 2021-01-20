class Base {
 public void thisIs() {
  System.out.println("This is basic class");
 }
 public void call() {
  thisIs();
 }
}
public class Inheriter extends Base {
 public void thisIs() {
  System.out.println("This is class inheriter");
 }
 public void call() {
  thisIs();
 }
 public static void main(String[] args) {
  Base i = new Inheriter();
  i.call();
 }
//Вызывался нужный метод

public class BlankFinal1 {
 final Ex e; ////если мы не инициализируем е либо тут, либо в конструкторах, то мы получим ошибку error: variable e might not have been initialized
 final Ex a = new Ex();
 BlankFinal1() {
  e = new Ex();
  //a = new Ex(); // так как мы уже инициализировали ссылку а, то мы не можем изменить ее. 
 }
 BlankFinal1(int i) {
  e = new Ex(i); 
  // a = new Ex(i); 
 }
 public static void main(String[] args) {
  new BlankFinal1();
  new BlankFinal1(7);
 }
}
class Ex {
 int i;
 Ex() {
 }
 Ex(int i) {
  this.i = i;
 }
}
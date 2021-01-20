public class ArrayOfLinks2 {
 static Elements a;
 static Elements b;
 static Elements c;
 static Elements d;
 static Elements e;
 public static void main( String ... args) {
  a = new Elements("First");
  b = new Elements("Second");
  c = new Elements("Third");
  d = new Elements("Forth");
  e = new Elements("Fifth");
  Elements[] elements = new Elements[]{
   a,
   b,
   c,
   d,
   e,
  };
 }
}
class Elements {
 Elements(String S) {
  System.out.println(S);
 }
}
//По идее, это продолжение предыдущего упражнения, где нас просили создать массив ссылок. Тут же, насколько я понимаю, нужно присвоить ссылкам объекты.Ну можно, конечно, было и без них обойтись. Прикладываю альтернативное решение.
class BerylliumSphere {
 private static long counter;
 private final long id = counter++;
 public String toString() { return "Sphere " + id; }
}
public class DynamicCall {
 static void callByArr(BerylliumSphere[] b) {
  for (int i = 0; i < b.length; i++) {
   System.out.print(b[i] + " ");
  }
  System.out.println();
 }
 public static void main(String[] ags) {
  BerylliumSphere[] b1 = new BerylliumSphere[5];
  BerylliumSphere[] b2;
  b2 = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()}; // `динамическая групповая инициализация
  BerylliumSphere[] b3 = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()}; //стандартная груповая инициализация
  callByArr(b1);
  callByArr(b2);
  callByArr(b3);
  callByArr(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()});
  // callByArr(new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere());
  /*
   error: method callByArr in class DynamicCall cannot be applied to given types;
   callByArr(new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere());
   ^
   required: BerylliumSphere[]
   found: BerylliumSphere,BerylliumSphere,BerylliumSphere
  */
  callByArr(new BerylliumSphere[3]); // null null null
 }
}
//В голову приходят ситуации, в которых вызывается подобный метод, массив уже есть, но еще не инициализирован(например, в конструкторе вызывается метод, а массив инициализируются только на стадии выполнения), в случае с нединамической инициализацией программист увидит ошибку, что может спасти его программу, но если у нас будет только неинициализированная ссылка,исключений может не появиться, что может быть причиной больших проблем.
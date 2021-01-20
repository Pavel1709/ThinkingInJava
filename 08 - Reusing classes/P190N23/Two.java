class One {
 static int i = returning();
 int j = 5;
 One() {
  System.out.println("One constructor");
 }
 static int returning() {
  System.out.println("Returned value");
  return 7;
 }
}
class Two extends One  {
 public static void main(String[] args) {
  One o = new One(); 
  One oo = new One(); // создается два объекта, однако поля инициализируются единожды, это видно по однократной инициализации статического поля i, метод, с помощью которого оно инициализируется срабатывает только один раз.
  int l = returning();// если мы закомментируем  создание экземпляра и напишем это строчку, которая представляет из себя инициализацию поля с помощью обращения. статическому методу, то увидем, что поля всего класса инициализируются, так как returning срабатывает дважды: здесь и при инициализации  i
 }
}

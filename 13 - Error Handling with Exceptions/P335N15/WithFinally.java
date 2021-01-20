//: exceptions/WithFinally.java 
// Finally Guarantees cleanup.
public class WithFinally {
 static Switch sw = new Switch();
 public static void main(String[] args) {
  try {
   sw.on();
   if(true) {
    throw new RuntimeException();
   }
   OnOffSwitch.f();
  } 
  catch(OnOffException1 e) { 
   System.out.println("OnOffException1");
  } 
  catch(OnOffException2 e) {
   System.out.println("OnOffException2");
  } 
  finally {
   sw.off(); 
  }
 }
} /* Output: on
off
*/
//абсолютно та же самая ошибка, что и в предыдущем упражнении. Не знаю, с чем связано. Упражнение выполняю, как написано. 
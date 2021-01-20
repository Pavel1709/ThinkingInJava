class ExceptionOne  extends Exception {}
class ExceptionTwo  extends Exception {}
class First {
 First() throws ExceptionOne {
  
 }
}
class FirstExtender extends First{
 FirstExtender()   {}
}
public class Executor {
 public static void main(String[] args) {
  try {
   First f = new First();
  }
  catch(ExceptionOne e) {
   e.printStackTrace();
  }
  try {
    FirstExtender fE = new FirstExtender();
  }
  catch(ExceptionOne e) {
   e.printStackTrace();
  }
 
 }
}
//error: unreported exception ExceptionOne; must be caught or declared to be thrown
//нужно отдельно закидывать исключение в конструкторе производного класса
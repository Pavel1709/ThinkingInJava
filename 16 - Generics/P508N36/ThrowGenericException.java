//: generics/ThrowGenericException.java 
import java.util.*;
interface Processor<T,E extends Exception, K extends Exception> {
 void process(List<T> resultCollector) throws E, K;
}
class ProcessRunner<T,E extends Exception, K extends Exception> extends ArrayList<Processor<T,E,K>> {
 List<T> processAll() throws E, K {
  List<T> resultCollector = new ArrayList<T>();
  for(Processor<T,E, K> processor : this)
   processor.process(resultCollector); 
  return resultCollector;
 } 
}
class Failure1 extends Exception {
 Failure1() {}
 Failure1(Exception e) throws Exception{
  throw e;
 } 
}
 
class Processor1 implements Processor<String,Failure1, Failure2> { 
 static int count = 3;
 public void process(List<String> resultCollector) throws Failure1, Failure2 {
  if(count-- > 1) 
   resultCollector.add("Hep!");
  else
   resultCollector.add("Ho!");
  if(count < 0)
   try{
    throw new Failure1(new Failure2());
   }
   catch(Exception e) {
    throw new RuntimeException(e);
   }
 } 
}
class Failure2 extends Exception {
 Failure2() {}
 Failure2(Exception e)  throws Exception{
  throw e;
 } 
}
class Processor2 implements Processor<Integer,Failure2,Failure1> { 
 static int count = 2;
 public void process(List<Integer> resultCollector) throws Failure2 {
  if(count-- == 0)
   resultCollector.add(47);
  else { 
   resultCollector.add(11);
  }
  if(count < 0)
   try{
    throw new Failure2(new Failure1());
   }
   catch(Exception e) {
    throw new RuntimeException(e);
   }
 }
}
public class ThrowGenericException {
 public static void main(String[] args) {
  ProcessRunner<String,Failure1,Failure2> runner = new ProcessRunner<String,Failure1,Failure2>();
  for(int i = 0; i < 3; i++) 
   runner.add(new Processor1());
  try {
   System.out.println(runner.processAll());
  } 
  catch(Failure1 e) {
   System.out.println(e);
  }
  catch(Failure2 e) {
   System.out.println(e);
  }
  ProcessRunner<Integer,Failure2, Failure1 > runner2 = new ProcessRunner<Integer,Failure2,Failure1 >();
  for(int i = 0; i < 3; i++) 
   runner2.add(new Processor2());
  try { 
   System.out.println(runner2.processAll());
  } 
  catch(Failure2 e) { 
   System.out.println(e);
  } 
    catch(Failure1 e) {
   System.out.println(e);
  }
 }
} ///:~
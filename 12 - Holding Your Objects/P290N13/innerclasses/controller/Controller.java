//: innerclasses/controller/Controller.java 
// The reusable framework for control systems. 
package innerclasses.controller;
import java.util.*;
public class Controller {
// A class from java.util to hold Event objects: 
 private List<Event> eventList  = new ArrayList<Event>(); 
// List<Event> toRemove = new ArrayList<Event>();
 public void addEvent(Event c) { 
  eventList.add(c); 
 } 

 public void run() {
   LinkedList<Event> eventListCopy = new LinkedList<Event>(eventList);
  ListIterator<Event> it = eventListCopy.listIterator();

  while(it.hasNext()) {
    Event e = it.next();
    if(e.ready()) { 
     System.out.println(e); 
       e.action(); 
   //  it.remove( );
   //  toRemove.add(e);
    } 
  }
 }
} ///:
//Вылезала ошибка ConcurrentModificationException
//Не знал, как исправить, не меняя структуры самого задания
// Нашел решение в интернете, понял, что проблема заключалась в том, что с помощью итератора я хочу изменить основной список, поэтому нужно было создать копию
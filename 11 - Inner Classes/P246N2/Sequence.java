interface Selector {
  boolean end();
  Object current();
  void next();
}

public class Sequence { 
    private static Object[] items;
    private int next = 0; 
    public Sequence(int size) {
        items = new Object[size]; 
    }
    public Sequence() {
        
    }
    public void add(Object x) {
     if(next < items.length)
         items[next++] = x;
    }

    private Stringer getStringer(String s) {
     return new Stringer(s);    
    }

    private static class Stringer {
        String l;
        public Stringer() {
            
        }
        public Stringer (String s) {
            l = s;
        }
        public String toString() {
          return l;  
        }
    }

  
    private class SequenceSelector implements Selector {
     private int i = 0;
     public boolean end() { 
         return i == items.length;
     } 
     public Object current() { 
         return items[i]; 
     } 
     public void next() { 
         if(i < items.length) 
             i++; 
     }


    }
    public Selector selector() {
     return new SequenceSelector();
    }
    public static void main(String[] args) { 
      Sequence sq = new Sequence();
         
      Sequence sequence = new Sequence(13);
      
      for(int i = 0; i < 10; i++) {
      sequence.add(Integer.toString(i));
      }
      sequence.add(sq.getStringer("First"));
      sequence.add(sq.getStringer("Second"));
      sequence.add(sq.getStringer("Third"));
      Selector selector = sequence.selector(); 
      while(!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next(); }
     
    }
} 
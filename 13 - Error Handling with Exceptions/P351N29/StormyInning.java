 
    class BaseballException extends RuntimeException {
     BaseballException(Exception e) {
      try{
       throw e; 
      }
      catch(Exception ex) {
       throw new RuntimeException(ex);
      }
     }
    }
    class Foul extends RuntimeException {}
    class Strike extends RuntimeException {}
    class UmpireException extends RuntimeException {}
    abstract class Inning {
      public abstract void newMeth()  ;
      public Inning()   { 
       try {
        throw new BaseballException(null);
       }
       catch(RuntimeException e) {
        throw new RuntimeException(new RuntimeException());
       }
      }
      public void event()   {
       try {
        throw new BaseballException(new RuntimeException());
       }
       catch(RuntimeException e) {
        throw new RuntimeException(e);
       }
      }
      public abstract void atBat() ;
      public void walk() {} 
    }
    class StormException extends RuntimeException {}
    class RainedOut extends RuntimeException {}
    class PopFoul extends RuntimeException {}
    interface Storm {
      public void event() ;
      public void rainHard()  ;
    }
    public class StormyInning extends Inning implements Storm { 
  
     public StormyInning()  {
 
       try {   
         throw new BaseballException(new RainedOut());
       }
         catch(RuntimeException e) {
          throw new RuntimeException(e);
         }
      }

     public StormyInning(String s)  {
       try {   
         throw new BaseballException(new Foul());
       }
         catch(RuntimeException e) {
          throw new RuntimeException(e);
         }

      }
     
     public void rainHard()   {}
    
     public void event() {}
     
     public void atBat()   {
      try {
        throw new PopFoul();
      }
       catch(RuntimeException e) {
        throw new RuntimeException(e);
       }
      }


     public void newMeth()  {}
     public static void main(String[] args) {
       StormyInning si = new StormyInning(); 
       si.atBat();
       Inning i = new StormyInning();
       i.atBat();
       StormyInning sii = new StormyInning(); 
       sii.newMeth();
       Inning ii = new StormyInning();
       ii.newMeth();
          }
} ///:~

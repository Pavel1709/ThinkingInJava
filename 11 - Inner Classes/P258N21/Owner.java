public interface Owner {
 int first();
 String second();
  static class Nester {
   static void execute (Owner o) {
    System.out.println(o.first());
    System.out.println(o.second());
   }
  }
  class Implementor implements Owner {
   public int first() {
    return 77;
   }
   public String second() {
    return "Cool";
   }
  } 
  public static void main(String[] args) {
    Implementor im = new Implementor();
    Nester.execute(im);
  }
}
  
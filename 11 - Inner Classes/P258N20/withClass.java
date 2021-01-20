public interface withClass {
  void printer();
  class InInter implements withClass {
    public void printer() {
     System.out.print("Hi !");
    }
  }
  public static void main(String[] args) {
   new InInter().printer();
  }
}
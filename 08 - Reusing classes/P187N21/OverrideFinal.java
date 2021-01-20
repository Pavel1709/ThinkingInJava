public class OverrideFinal extends WithFinalMethod{
 public static void main(String[] args) {
  OverrideFinal of = new OverrideFinal(); 
  of.finalMethod();
 }
  @Override
  final void finalMethod() {
   System.out.println("Overriden method");
 }
}
class WithFinalMethod {
 final void finalMethod() {
  System.out.println("Base method");
 }
}
/*
finalMethod() in OverrideFinal cannot override finalMethod() in WithFinalMethod
  final void finalMethod() {
             ^
  overridden method is final
*/
public class CheckVariableArguments {
 public static void main(String[] args) {
  printVariableArguments( "One", "Two", "Three", "Four", "Five");
  printVariableArguments( new String[]{ "One", "Two", "Three", "Four", "Five"});

 }

 static void printVariableArguments(String ... args) {
  for (String arg: args) {
   System.out.println(arg);
  }
 }
}
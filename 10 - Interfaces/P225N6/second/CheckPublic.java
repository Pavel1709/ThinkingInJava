package second;
import first.InterOne;
public class CheckPublic {
 public static void main(String[] args) {
  InterOne.meth();
 }
}
//javac -sourcepath ./ ./second/CheckPublic.java
//java  second.CheckPublic   
/*Output:
It is public
*/
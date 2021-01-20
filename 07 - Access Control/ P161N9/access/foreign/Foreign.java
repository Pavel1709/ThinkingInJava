// access/foreign/Foreign.java 
package access.foreign; 
import access.local.*;
public class Foreign {
  public static void main(String[] args) {
   PackagedClass pc = new PackagedClass(); //class PackagedClass не public, поэтому виден только внутри своего пакета. Перемещение в один пакет, конечно же, решит проблему
  }
}

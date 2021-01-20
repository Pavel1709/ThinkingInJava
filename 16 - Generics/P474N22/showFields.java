import java.lang.reflect.*;
import java.util.Arrays;

class ContainerWithArgs {
 int number;
 public ContainerWithArgs(int number) {
  this.number = number;
 }
}
class InstCreator<T> {
 T x;
 public InstCreator(Class<T> kind, int i) {
  try {
   x =(T) kind.getDeclaredConstructor(Integer.TYPE).newInstance(i);
  }
  catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
   throw new RuntimeException(e);
  }
 }
 public void showFields() {
  System.out.println(Arrays.toString(x.getClass().getDeclaredFields()));
 }
}
public class InstanceManipulator {
 public static void main(String[] args) {
  InstCreator<ContainerWithArgs> ic = new InstCreator<ContainerWithArgs>(ContainerWithArgs.class, 7);
  ic.showFields();
 }
}
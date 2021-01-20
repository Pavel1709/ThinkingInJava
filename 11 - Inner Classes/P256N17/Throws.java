interface Throwing {
 public void toThrow();
}
interface ThrowingFactory {
 Throwing getThrow();
}
class CoinThrow implements Throwing {
 public void toThrow() {
  System.out.println("Trowing the coin");
 }
 public static ThrowingFactory coinThrowingFactory  () {
  return new  ThrowingFactory() {
   public Throwing getThrow() {
    return new CoinThrow();
   }
  };
 }
}
class BoneThrow implements Throwing {
 public void toThrow() {
  System.out.println("Trowing bone");
 }
 public static ThrowingFactory BoneThrowingFactory  () {
  return new  ThrowingFactory() {
   public Throwing getThrow() {
    return new BoneThrow();
   }
  };
 }
}
public class Throws{
 public static void letsThrow(ThrowingFactory tf) {
  Throwing t = tf.getThrow();
  t.toThrow();
 }
 public static void main(String[] args) {
  letsThrow(CoinThrow.coinThrowingFactory());
  letsThrow(BoneThrow.BoneThrowingFactory());
 }
}
  
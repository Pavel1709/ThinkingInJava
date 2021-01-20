import java.util.concurrent.*;
public class Slepper {
 public void toSleep() throws InterruptedException{
  TimeUnit.SECONDS.sleep(10);
 }
}
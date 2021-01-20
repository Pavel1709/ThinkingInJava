class AlertStatus {
 public void signal() {
  System.out.println("Signal");
 }
}
class GoodAlertStatus extends AlertStatus {
 public void signal() {
  System.out.println("Good Signal");
 }
}
class BadAlertStatus extends AlertStatus {
 public void signal() {
  System.out.println("Bad Signal");
 }
}
class NoAlertStatus extends AlertStatus {
 public void signal() {
  System.out.println("No Signal");
 }
}
class Starship {
 AlertStatus alt = new NoAlertStatus();
 public void connectSignal() {
  alt = new BadAlertStatus();
 }
 public void repairSignal() {
  alt = new GoodAlertStatus();
 }
 public void showSignalStatus() {
  alt.signal();
 }
}
public class CheckConnection {
 public static void main(String[] args) {
  Starship s = new Starship();
  s.showSignalStatus();
  s.connectSignal();
  s.showSignalStatus();
  s.repairSignal();
  s.showSignalStatus();
 }
}
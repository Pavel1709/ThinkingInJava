package detergent;
import static net.mindview.util.Print.*;

class Cleanser {
 private String s = "Cleanser";
 public void append(String a) {
  s+=a;
 }
 public void dilute() {
  append(" dilute()");
 }
 public void apply() {
  append(" apply()");
 }
 public void scrub() {
  append(" scrub()");
 }
 public String toString() {
  return s;
 }
 public static void main(String... args) {
  Cleanser x = new Cleanser();
  x.dilute();
  x.apply();
  x.scrub();
  print(x);
 }
}
public class Detergent  {
 Cleanser x = new Cleanser();
 public void dilute() {
  x.dilute();
 }
 public void apply() {
  x.apply();
 }
 public void scrub() {
  x.scrub();
 }
 public void foam() {
  x.append(" foam()");
 }
 public String toString() {
  return x.toString();
 }
 public static void main(String[] args) {
  Detergent d = new Detergent();
  d.dilute();
  d.apply();
  d.scrub();
  d.foam();
  print(d);
  print("Проверяем базовый класс");
  Cleanser.main(" ", " ");
 }
}
  

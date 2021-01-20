import java.util.*;
public class Doer{
 private static int x = 1;
 private static int y = 2;
 public synchronized void change() {
  x = x*y;
  y = y*x;
 }
 public int getX() {
  return x;
 }
 public int getY() {
  return y;
 }
}

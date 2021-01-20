package one;
import java.util.*;
public class withDifferentMods {
 int a;
 String s = "only through private void";
 StringBuilder sb = new StringBuilder(s);
 public withDifferentMods( int a) {
  this.a = a;
 }
 private void whatIsS() {
  System.out.println(s);
 }
 void modS() {
  System.out.println(sb.append("it is possible to see s"));
 }
 protected int whatsA() {
  return a;
 }
}
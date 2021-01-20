//: net/mindview/util/CountingGenerator.java 
// Simple generator implementations.
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

interface SkipGenerator<T> extends net.mindview.util.Generator<T> {
T next();
}
public class SkipGenerator1 {
 public static class Boolean implements SkipGenerator<java.lang.Boolean> {
  private boolean value = false; 
  Boolean(boolean b) {
   value = b;
  }
  public java.lang.Boolean next() {
   value = !value; // Just flips back and forth
   return value;
  }
 }
 public static class Byte implements SkipGenerator<java.lang.Byte> {
  private byte value = 0;
  Byte(byte b) {
   value = b;
  }
  public java.lang.Byte next() { return value++; } 
 }
 static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
 public static class Character implements SkipGenerator<java.lang.Character> {
  int index = -1;
  Character(int c) {
    index =  c;
  }
  public java.lang.Character next() {
   index = (index + 1) % chars.length;
   return chars[index];
  }
 }
 public static class String implements SkipGenerator<java.lang.String> {
  private int length = 7;
  int index = -1;
  public String(char c) {
    index = c;
  }
  SkipGenerator<java.lang.Character> cg = new Character((char)index); 
  public String(int length) { this.length = length; } 
  public java.lang.String next() {
   char[] buf = new char[length];
   for(int i = 0; i < length; i++)
    buf[i] = cg.next();
   return new java.lang.String(buf);
  }
 }
 public static class Short implements SkipGenerator<java.lang.Short> {
  private short value = 0;
  Short(short s) {
   value = s;
  }
  public java.lang.Short next() { return value++; }
 }
 public static class Integer implements SkipGenerator<java.lang.Integer> {
  private int value = 0;
  Integer(int s) {
   value = s;
  }
  public java.lang.Integer next() { return value++; } 
 }
 public static class Long implements SkipGenerator<java.lang.Long> {
  private long value = 0;
  Long(long s) {
   value = s;
  }
  public java.lang.Long next() { return value++; } 
 }
 public static class Float implements SkipGenerator<java.lang.Float> {
  private float value = 0; 
  Float(float f) {
   value = f;
  }
  public java.lang.Float next() {
   float result = value; 
   value += 1.0;
   return result;
  }
 } 
 public static class Double implements SkipGenerator<java.lang.Double> {
  private double value = 0.0; 
  Double(double f) {
   value = f;
  }
  public java.lang.Double next() {
   double result = value; 
   value += 1.0;
   return result;
  } 
 }
 public static void main(String[] args) {
  double[] d = new double[10];
   for (int i = 0; i < d.length; i++) {
    d[i] = new SkipGenerator1.Double(4.5).next();
   }
   System.out.println(Arrays.toString(d));
 }
}
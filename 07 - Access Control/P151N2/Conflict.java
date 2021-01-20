import net.mindview.simple.*;
import java.util.*;
public class Conflict {
 public static void main(String[] args) {
  java.util.Vector vector = new java.util.Vector();// Конфликта не возникает, так как указано местонахождение, что конкретизирует, к чему именно мы обращаемся, можно обойтись без импорта того же самого
  Vector v1= new Vector(); // тут возникает конфликт имен, так как этот класс есть в обеих библиотеках
 }
}
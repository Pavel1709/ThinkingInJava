import java.util.regex.*;
import net.mindview.util.*;
public class Comment {
 public static void main( String [] args ) {
  Pattern p = Pattern.compile(args[1]); //регулярное выражение для поиска комментариев 
 // Pattern pp = Pattern.compile(args[2]);
  int index = 0; 
  String s = "Hi";
  Matcher m = p.matcher("");
  // перебор строк входного файла
  for( String line : new TextFile ( args[0] ) ) { 
   m.reset(line); 
   while(m.find()) 
    System.out.println(index++ + ":" + m.group() + ":" + m.start()); //вывод интересующих выражение
  }
 }
}
//java Comment Comment.java "[^\"]\b[A-Z]\w*\b[^\"]"
// примерно так, опять же, это не совсем правильно. Если у нас есть константы, то это определит их тоже, так как они содержат заглавные буквы

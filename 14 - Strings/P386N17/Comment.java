import java.util.regex.*;
import net.mindview.util.*;
public class Comment {
 public static void main(String[] args) {
  Pattern p = Pattern.compile(args[1]); //регулярное выражение для поиска комментариев "//.+/n"
 // Pattern pp = Pattern.compile(args[2]);
  int index = 0; 
  Matcher m = p.matcher("");
  // перебор строк входного файла
  for(String line: new TextFile(args[0])) { 
   m.reset(line); 
   while(m.find()) 
    System.out.println(index++ + ": " + m.group() + ": " + m.start()); //вывод интересующих выражение
  }
 }
}
//% java Comment Comment.java "//.*" 
// потратил очень много времени, возможности думать еще нет, не успею прочитать книгу. Работает только для // комментариев. Как сделать, чтобы работало для комментариев /* /n */ не знаю. Проблемы с переносом строки.
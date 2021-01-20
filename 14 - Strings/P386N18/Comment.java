import java.util.regex.*;
import net.mindview.util.*;
public class Comment {
 public static void main(String[] args) {
  Pattern p = Pattern.compile(args[1]); //регулярное выражение для поиска комментариев 
 // Pattern pp = Pattern.compile(args[2]);
  int index = 0; 
  String s = "hi";
  Matcher m = p.matcher("");
  // перебор строк входного файла
  for(String line: new TextFile(args[0])) { 
   m.reset(line); 
   while(m.find()) 
    System.out.println(index++ + ":" + m.group() + ":" + m.start()); //вывод интересующих выражение
  }
 }
}

//Я потратил порядка 4 часов на эту задачу, но ни к чему хорошему не пришел, а тратить время еще у меня возможности нет, так как не успею прочитать книгу. Вот все, что я смог сделать : java Comment Comment.java "\".*[^(\" +.*+ \"]\"" Но это работает далеко не для всего."\".*\"" - вот это работает для лишнего. Как исправить - не знаю.

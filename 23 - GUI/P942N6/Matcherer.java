import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import net.mindview.util.*;
import java.util.regex.*;
import static net.mindview.util.SwingConsole.*;
public class Matcherer extends JFrame {
 private JButton b = new JButton("Find");
 private JTextArea
  t1 = new JTextArea(20, 40),
  t2 = new JTextArea(20, 40);
 private JTextField f= new JTextField(10);
 Matcherer() {
     setLayout(new FlowLayout());
     add(b);
     add(new JScrollPane(t1));
     add(new JScrollPane(t2));
     add(f);
     b.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       String[] s = f.getText().split(" ");
       for(String ss: s) {
        String t = "Regular expression: \"" + ss + "\"";
        t2.append(t);
        Pattern p = Pattern.compile(ss);
        Matcher m = p.matcher(t1.getText());
        while(m.find()) {
         t2.append("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
         t2.append("\n");
        }
       }
      }
     });
 }
 public static void main(String[] args) {
  run(new Matcherer(), 600, 500);
 }
}
// for example
// put in t1 abcabcabcdefabc
// put in t2 abc+ (abc)+ (abc){2,}  
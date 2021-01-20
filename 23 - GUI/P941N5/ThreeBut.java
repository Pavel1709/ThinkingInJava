import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.SwingConsole.*;
public class ThreeBut extends JFrame {
 private JButton 
  b1 =  new JButton("First button"),
  b2 =  new JButton("Second button"),
  b3 =  new JButton("Third button");
 private JTextField txt = new JTextField(10);
 private ActionListener bl = new ActionListener() {
  public void actionPerformed(ActionEvent e) { 
   String name =   ((JButton)e.getSource()).getText();
   txt.setText(name); 
  }
 };
 public ThreeBut() {
  b1.addActionListener(bl); 
  b2.addActionListener(bl); 
  b3.addActionListener(bl); 
  setLayout(new FlowLayout()); 
  add(b1);
  add(b2);
  add(b3);
  add(txt); 
 }
 public static void main(String[] args) { 
  run(new ThreeBut(), 200, 200);
 }
}

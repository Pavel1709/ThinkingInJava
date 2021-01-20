import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;
import java.util.*;
public class FrameWithNewBut extends JFrame{
 class NewBut extends JButton {
  private Color color = new Color(0);
  ActionListener a = new ActionListener() {
   Random rand = new Random();
   public void actionPerformed(ActionEvent e) {
      color = new Color(rand.nextInt(0xFFFFFF));
       setBackground(Color.red);
   }
  };
  public NewBut() {
   super("New button");
   setBackground(Color.green);
   addActionListener(a);
  }
 }
 FrameWithNewBut() {
  add(new NewBut());  
  setLayout(new FlowLayout());
 }
 public static void main(String[] args) {
  run(new FrameWithNewBut(), 300, 300);
 }
}
//Вроде, делаю все верно. Не понимаю, почему не работает.
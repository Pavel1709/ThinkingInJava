import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static net.mindview.util.SwingConsole.*;
public class FocCrame extends JFrame {
 private JButton b1 = new JButton("press and type");
 private JButton b2 = new JButton("press and type but it won't help");
 private JTextField t1 = new JTextField(10);
 FocCrame() {
  KeyListener keyl  = new KeyListener() {
      public void keyPressed(KeyEvent k) {
       t1.setText("" + k.getKeyChar());
      }
      public void keyReleased(KeyEvent e) {}
      public void keyTyped(KeyEvent e) {}
     };
  b1.addFocusListener(new FocusListener() {
   public void focusGained(FocusEvent e) {
    b1.addKeyListener(keyl) ;
   }
   public void focusLost(FocusEvent e) {
    b1.removeKeyListener(keyl);
   }
  });
  setLayout(new FlowLayout());
  add(b1);
  add(b2);
  add(t1);
 }
 public static void main(String[] args) {
  run(new FocCrame(), 300,300);
 }
} 
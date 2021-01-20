import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class Password extends JFrame {
 JPasswordField p = new JPasswordField(20);
 JButton b = new JButton("Войти");
 JLabel t = new JLabel();
 private String pass ="qwerty";
 Password() {
  add(p);
  add(t);
  add(b);
  b.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e) {
    if(p.getText().equals("")) {
     t.setText("Введите пароль");
    }
    else if(p.getText().toString().equals(pass)) {
     t.setText("OK");
     JOptionPane.showMessageDialog(null, "Пароль верный!", " ", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
      t.setText("Пароль неверный");
    }
   }
  });
  setLayout(new FlowLayout()); 
 }
 public static void main(String[] args) {
  run(new Password(), 250, 250);
 
 }
}
  
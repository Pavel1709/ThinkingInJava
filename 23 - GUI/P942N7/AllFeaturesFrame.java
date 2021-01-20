import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.SwingConsole.*;

public class AllFeaturesFrame extends JFrame {
 private JButton b1 = new  JButton("JButton");
 
 private JComboBox b6 = new JComboBox();
 private JFileChooser b7 = new JFileChooser("JFileChooser");
 private JTextField b8 = new JTextField("JTextField");
 private JTextField txt = new JTextField(50);
 @SuppressWarnings("unchecked")
 public AllFeaturesFrame() {
  add(b1);
  add(b6);
  add(b7);
  add(b8);
  add(txt);
  b6.addItem("1");
  setLayout(new FlowLayout());
  b1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) { 
    String name = ((JButton)e.getSource()).getText();
    txt.setText(name); 
   }
  });
 
  b6.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) { 
    String name = "JComboBox" ;
    txt.setText(name); 
   }
  });
  b7.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) { 
    String name = "JFileChooser";
    txt.setText(name); 
   }
  });
  b8.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) { 
    String name = ((JTextField)e.getSource()).getText();
    txt.setText(name); 
   }
  });
 }
 public static void main(String[] args) {
  run(new AllFeaturesFrame(), 1000,1000 ); 
 }
}




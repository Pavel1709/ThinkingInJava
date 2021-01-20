//: gui/MessageBoxes.java
// Demonstrates JOptionPane.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

public class MessageBoxes extends JFrame {
  private JButton[] b = {
    new JButton("Alert"), new JButton("Yes/No"),
    new JButton("Color"), new JButton("Input"),
    new JButton("3 Vals")
  };
  private JTextField txt = new JTextField(15);
  private ActionListener alert = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      //String id = ((JButton)e.getSource()).getText();
      //if(id.equals("Alert"))
        JOptionPane.showMessageDialog(null,
          "There's a bug on you!", "Hey!",
          JOptionPane.ERROR_MESSAGE);
    }
   };
  private ActionListener yesno = new ActionListener() {
   public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(null,
          "or no", "choose yes",
          JOptionPane.YES_NO_OPTION);
   }
  };
  private ActionListener color = new ActionListener() {
   public void actionPerformed(ActionEvent e) {
        Object[] options = { "Red", "Green"};
        int sel = JOptionPane.showOptionDialog(
          null, "Choose a Color!", "Warning",
          JOptionPane.DEFAULT_OPTION,
          JOptionPane.WARNING_MESSAGE, null,
          options, options[0]);
        if(sel != JOptionPane.CLOSED_OPTION)
          txt.setText("Color Selected: " + options[sel]);
   }
  };
  private ActionListener input = new ActionListener() {
   public void actionPerformed(ActionEvent e) {
        String val = JOptionPane.showInputDialog(
            "How many fingers do you see?");
        txt.setText(val);
   }
  };
  private ActionListener vals = new ActionListener() {
   public void actionPerformed(ActionEvent e) {
        Object[] selections = {"First", "Second", "Third"};
        Object val = JOptionPane.showInputDialog(
          null, "Choose one", "Input",
          JOptionPane.INFORMATION_MESSAGE,
          null, selections, selections[0]);
        if(val != null)
          txt.setText(val.toString());
   }
  };
  public MessageBoxes() {
    setLayout(new FlowLayout());
    b[0].addActionListener(alert);
    b[1].addActionListener(yesno);
    b[2].addActionListener(color);
    b[3].addActionListener(input);
    b[4].addActionListener(vals);
    for(int i = 0; i < b.length; i++) {
      add(b[i]);
    }
    add(txt);
  }
  public static void main(String[] args) {
    run(new MessageBoxes(), 200, 200);
  }
} ///:~

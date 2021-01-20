//: gui/ShowAddListeners.java
// Display the "addXXXListener" methods of any Swing class.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;
import static net.mindview.util.SwingConsole.*;

public class ShowAddListeners extends JFrame {
 private static String usage =
    "usage:\n" +
    "ShowMethods qualified.class.name\n" +
    "To show all methods in class or:\n" +
    "ShowMethods qualified.class.name word\n" +
    "To search for methods involving 'word'";
  private JTextField name = new JTextField(25);
  int lines = 0;
  private JTextArea results = new JTextArea(40, 65);
  private static Pattern addListener =
    Pattern.compile("\\w+\\.");
  private static Pattern qualifier =
    Pattern.compile("\\w+\\.");
  class NameL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String nm = name.getText().trim();
      if(nm.length() < 1) {
        results.setText("usage");
        return;
      }
      Class<?> kind;
      try {
        kind = Class.forName( nm);
      } catch(ClassNotFoundException ex) {
        results.setText("No match");
        return;
      }
      Method[] methods = kind.getMethods();
      Constructor[] ctors = kind.getConstructors();
      results.setText("");
      String[] s = nm.split(" ");
      if (s.length == 1) {
      for(Method m : methods) {
        Matcher matcher1 =
          addListener.matcher(m.toString());
        if(matcher1.find())
          results.append(matcher1.replaceAll("")+ "\n");
      }
       for(Constructor ctor : ctors) {
        Matcher matcher2 =
          addListener.matcher(ctor.toString());
        if(matcher2.find())
            results.append(matcher2.replaceAll("") + "\n");
        }
      }
    }
  }
  public ShowAddListeners() {
    NameL nameListener = new NameL();
    name.addActionListener(nameListener);
    JPanel top = new JPanel();
    top.add(new JLabel("Swing class name (press Enter):"));
    top.add(name);
    add(BorderLayout.NORTH, top);
    add(new JScrollPane(results));
    // Initial data and test:
    name.setText("JTextArea");
    nameListener.actionPerformed(
      new ActionEvent("", 0 ,""));
  }
  public static void main(String[] args) {
    run(new ShowAddListeners(), 500, 400);
  }
} ///:~

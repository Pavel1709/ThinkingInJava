//: gui/SubmitSwingProgram.java
import javax.swing.*;
import java.util.concurrent.*;
import net.mindview.util.*;
public class SubmitSwingProgram extends JFrame {
  JLabel label;
  public SubmitSwingProgram() {
    super("Hello Swing");
    label = new JLabel("A Label");
    add(label);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 100);
  }
  static SwingConsole sc =  new SwingConsole();;
  static SubmitSwingProgram ssp;
  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { 
       ssp = new SubmitSwingProgram();
      }
    });
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { 
       sc.run(ssp, 300, 100);
      }
    });
    TimeUnit.SECONDS.sleep(1);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ssp.label.setText("Hey! This is Different!");
      }
    });
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { 
       sc.run(ssp, 300, 100);
      }
    });
  }
} ///:~

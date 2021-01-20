//: gui/HelloLabel.java
import javax.swing.*;
import java.util.concurrent.*;
import java.util.*;
public class HelloLabel {
  public static void main(String[] args) throws Exception {
    JFrame frame = new JFrame("Hello Swing");
    JLabel label = new JLabel("A Label");
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 100);
    frame.setVisible(true);
    TimeUnit.SECONDS.sleep(1);
    label.setText("Hey! This is Different!");
    TimeUnit.SECONDS.sleep(1);
    Random rand = new Random();
    int r = rand.nextInt(100);
    for (int i = 0; i < r; i++) {
     label.setText("Text" + i);
     TimeUnit.MILLISECONDS.sleep(1000);
    }
  }
} ///:~

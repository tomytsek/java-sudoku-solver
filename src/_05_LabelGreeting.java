import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _05_LabelGreeting extends JFrame {
  public _05_LabelGreeting () {
    super();
    setTitle("Label Demo");
    JLabel greeting = new JLabel("   How are you?    ");
    //JLabel greeting = new JLabel("<html><font size='10' color='red'>How are you?</font></html>");
    //JLabel greeting = new JLabel(new ImageIcon("howAreYou.jpg"));
    
    add(greeting);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
       _05_LabelGreeting lg = new _05_LabelGreeting();
      }
    });
  }
}
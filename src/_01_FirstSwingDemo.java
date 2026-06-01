import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;

public class _01_FirstSwingDemo {
  public static final int WIDTH = 300;
  public static final int HEIGHT = 200;
  
  public static void showGUI() {
    JFrame firstWindow = new JFrame();
    firstWindow.setSize(WIDTH, HEIGHT);
    firstWindow.setTitle("First Window Program!");
    firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton endButton = new JButton("Click to end program.");
    
    ActionListener buttonEar = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    };
    
    endButton.addActionListener(buttonEar);
    firstWindow.add(endButton);
    firstWindow.pack();
    firstWindow.setVisible(true);
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        showGUI();
      } 
    });
  }
}
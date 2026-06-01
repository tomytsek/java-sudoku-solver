import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class _04_ColorDemo extends JFrame implements ActionListener {
  public static final int WIDTH = 600;
  public static final int HEIGHT = 300;
  
  private JPanel redPanel;
  private JPanel whitePanel;
  private JPanel bluePanel;
  
  public static void main(String args[]) {
    _04_ColorDemo gui = new _04_ColorDemo();
    gui.setVisible(true);
  }
  
  public _04_ColorDemo() {
    super("Color Demonstration");
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    JPanel upperPanel = new JPanel();
    upperPanel.setLayout(new GridLayout(1,3));
    
    redPanel = new JPanel();
    redPanel.setBackground(Color.LIGHT_GRAY);
    upperPanel.add(redPanel);
    
    whitePanel = new JPanel();
    whitePanel.setBackground(Color.GRAY);
    upperPanel.add(whitePanel);
    
    bluePanel = new JPanel();
    bluePanel.setBackground(Color.LIGHT_GRAY);
    upperPanel.add(bluePanel);
    
    add(upperPanel, BorderLayout.CENTER);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());    
    //buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));    
    buttonPanel.setBackground(Color.LIGHT_GRAY);
    
    JButton redButton = new JButton("Red Button");
    redButton.setPreferredSize(new Dimension(200, 30));
    redButton.setBackground(Color.RED);
    redButton.addActionListener(this);
    buttonPanel.add(redButton);
    
    JButton whiteButton = new JButton("White");
    whiteButton.setBackground(Color.WHITE);
    whiteButton.setPreferredSize(new Dimension(200, 30));
    whiteButton.addActionListener(this);
    buttonPanel.add(whiteButton);
    
    JButton blueButton = new JButton("Blue");
    blueButton.setBackground(Color.BLUE);
    blueButton.setPreferredSize(new Dimension(200, 30));
    blueButton.addActionListener(this);
    buttonPanel.add(blueButton);
    
    add(buttonPanel, BorderLayout.SOUTH);
  }
  
  public void actionPerformed(ActionEvent e) {
    String buttonString = e.getActionCommand();
    if(buttonString.equals("Red") ) {
      redPanel.setBackground(Color.RED);
      whitePanel.setBackground(Color.LIGHT_GRAY);
      bluePanel.setBackground(Color.LIGHT_GRAY);
    }
    else if(buttonString.equals("White") ) {
      redPanel.setBackground(Color.LIGHT_GRAY);
      whitePanel.setBackground(Color.WHITE);
      bluePanel.setBackground(Color.LIGHT_GRAY);
    }
    else if(buttonString.equals("Blue") ) {
      redPanel.setBackground(Color.LIGHT_GRAY);
      whitePanel.setBackground(Color.LIGHT_GRAY);
      bluePanel.setBackground(Color.BLUE);
    }
  }
}
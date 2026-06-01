import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
  JTextField textField = null;
  String memText;
  int operation = 0;
  
  private static final int ADD = 1;
  private static final int SUB = 2;
  private static final int MUL = 3;
  private static final int DIV = 4;

  public Calculator () {
    int i;
    setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    setPreferredSize(new Dimension(300,230));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    textField = new JTextField(20);
    textField.setFont( new Font("Arial", Font.BOLD, 20) );
    textField.setEditable(false);
    textField.setBackground(Color.WHITE);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    add(textField);
    JPanel buttonPanel = new JPanel();
    add(buttonPanel);
    buttonPanel.setLayout(new GridLayout(4,4));
    JButton [] buttons = new JButton[16];
    String label=null;
    for(i=1; i<=16; i++) {
      switch(i) {
        case 4: label = "+"; break;
        case 8: label = "-"; break;
        case 12: label = "*"; break;
        case 16: label = "/"; break;
        case 13: label = "CE"; break;        
        case 14: label = "0"; break;
        case 15: label = "="; break;
        default: 
          if( i>4 && i<8) label = (new Integer(i-1)).toString();
          else if(i>8) label = (new Integer(i-2)).toString();
          else label = (new Integer(i)).toString();
          break;
      }
      buttons[i-1] = new JButton(label);
      buttons[i-1].setPreferredSize(new Dimension(40,40));
      buttons[i-1].addActionListener(this);
      buttonPanel.add(buttons[i-1]);
    }
  }
  
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if(command.equals("CE")) {
      textField.setText("");
      memText = "";
    }
    else if(command.equals("+")) {
      memText = textField.getText();
      operation = ADD;
      textField.setText("");
    }
    else if(command.equals("-")) {
      memText = textField.getText();
      operation = SUB;
      textField.setText("");
    }
    else if(command.equals("*")) {
      memText = textField.getText();
      operation = MUL;
      textField.setText("");
    }
    else if(command.equals("/")) {
      memText = textField.getText();
      operation = DIV;
      textField.setText("");
    }
    else if(command.equals("=")) {
      int mem = (new Integer(memText)).intValue();
      int curr = (new Integer(textField.getText())).intValue();
      //System.out.println("mem:"+mem+", curr:"+curr);
      if(operation == ADD) {
        textField.setText((new Integer(mem+curr)).toString());
      }
      if(operation == SUB) {
        textField.setText((new Integer(mem-curr)).toString());
      }
      if(operation == MUL) {
        textField.setText((new Integer(mem*curr)).toString());
      }
      if(operation == DIV) {
        textField.setText((new Integer(mem/curr)).toString());
      }
    }
    else {
      textField.setText( textField.getText() + command );
    }
  }

  public static void main(String []args) {
    Calculator calc = new Calculator();
    calc.pack();
    calc.setVisible(true);
  }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class _10_TextComponentsDemo {

  JFrame frame;
  JTextField textField;
  JPasswordField passwdField;
  JLabel msgLabel;
  JTextArea textArea;
  JCheckBox textFieldCheck, passwdFieldCheck;
  
  public _10_TextComponentsDemo() {
    frame = new JFrame("Text Components Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel framePanel = new JPanel();
    framePanel.setLayout(new BoxLayout(framePanel, BoxLayout.Y_AXIS));
    frame.setContentPane(framePanel);
    JPanel textFieldPanel = new JPanel(new GridLayout(3,3));
    framePanel.add(textFieldPanel);
    textField = new JTextField(15);
    textField.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textArea.setText(textArea.getText()+(textArea.getText().isEmpty()?"":"\n")+textField.getText());
        textField.setText("");
      }
    });
    textFieldPanel.add(new JLabel("JTextField:"));
    textFieldPanel.add(textField);
    textFieldCheck = new JCheckBox("Editable", true);
    textFieldCheck.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED)
          textField.setEditable(true);
        else
          textField.setEditable(false);
      }
    });
    textFieldPanel.add(textFieldCheck);
    
    textFieldPanel.add(new JLabel("JPasswordField:"));
    passwdField = new JPasswordField();
    textFieldPanel.add(passwdField);
    passwdFieldCheck = new JCheckBox("Editable", true);
    passwdFieldCheck.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED)
          passwdField.setEditable(true);
        else
          passwdField.setEditable(false);
      }
    });
    textFieldPanel.add(passwdFieldCheck);
    
    msgLabel = new JLabel("TextArea Options:", JLabel.LEFT);    
    textFieldPanel.add(msgLabel);
    
    String []font = {"Arial", "Courier", "Verdana", "Tahoma"};
    JComboBox<String> fontCombo = new JComboBox<>(font);
    fontCombo.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String option = font[fontCombo.getSelectedIndex()];
        textArea.setFont(new Font(option, Font.ITALIC|Font.BOLD, 15));
      }
    });
    
    
    String []fontColor = { "RED", "BLUE", "CYAN", "DARK_GRAY" };
    JComboBox<String> fontColorCombo = new JComboBox<>(fontColor);
    fontColorCombo.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Color c;
        switch(fontColorCombo.getSelectedIndex()) {
          case 0:
            c = Color.RED;
            break;
          case 1:
            c = Color.BLUE;
            break;
          case 2:
            c = Color.CYAN;
            break;
          case 3:
            c = Color.DARK_GRAY;
            break;          
          default:
            c = Color.YELLOW;
        }
        textArea.setForeground(c);
      }
    });
    textFieldPanel.add(fontCombo);
    textFieldPanel.add(fontColorCombo);
    
    textArea = new JTextArea(10, 20);
    textArea.setText("");
    textArea.setFont(new Font("Arial", Font.ITALIC|Font.BOLD, 15));
    textArea.setForeground(new Color(250, 30, 30));
    JScrollPane textAreaScrollPane = new JScrollPane(textArea);
    textAreaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    framePanel.add(textAreaScrollPane);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  public static void main(String []args) {
    javax.swing.SwingUtilities.invokeLater( new Runnable() {
      public void run() {
        new _10_TextComponentsDemo();
      }
    });
  }
}
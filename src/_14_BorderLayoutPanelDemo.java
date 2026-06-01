import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class _14_BorderLayoutPanelDemo extends JFrame {
  public _14_BorderLayoutPanelDemo () {
    super();
    setSize(400, 150);
    setTitle("BorderLayout Demo");
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
    ButtonListener listener = new ButtonListener();
    
    okCancelPanel(this);    
    
    JButton centerButton = new JButton("Close Window Button");
    centerButton.addActionListener( listener );
    add(centerButton, BorderLayout.CENTER);
  }
  
  private void okCancelPanel(Container container) {
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new FlowLayout());
    container.add(southPanel,  BorderLayout.SOUTH);
    
    JButton cancelButton = new JButton("Cancel");    
    southPanel.add(cancelButton);
    
    JButton okButton = new JButton("OK!");
    southPanel.add(okButton);    
  }
  
  public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println(e);
      System.exit(1);
    }
  }
  
  public static void main(String[] args) {
    _14_BorderLayoutPanelDemo w = new _14_BorderLayoutPanelDemo();
    w.setVisible(true);
  }
}
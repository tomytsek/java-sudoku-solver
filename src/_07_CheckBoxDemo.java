import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * _07_CheckBoxDemo.java requires 16 image files in the images/geek
 * directory: 
 * geek-----.gif, geek-c---.gif, geek--g--.gif, geek---h-.gif, geek----t.gif,
 * geek-cg--.gif, ..., geek-cght.gif.
 */
public class _07_CheckBoxDemo extends JPanel {
              
  JCheckBox chinButton;
  JCheckBox glassesButton;
  JCheckBox hairButton;
  JCheckBox teethButton;

  StringBuffer choices;
  JLabel pictureLabel;

  public _07_CheckBoxDemo() {
    super(new BorderLayout());

    //Create the check boxes.
    chinButton = new JCheckBox("Chin");
    chinButton.setMnemonic(KeyEvent.VK_C);
    chinButton.setSelected(true);

    glassesButton = new JCheckBox("Glasses");
    glassesButton.setMnemonic(KeyEvent.VK_G);
    glassesButton.setSelected(true);

    hairButton = new JCheckBox("Hair");
    hairButton.setMnemonic(KeyEvent.VK_H);
    hairButton.setSelected(true);

    teethButton = new JCheckBox("Teeth");
    teethButton.setMnemonic(KeyEvent.VK_T);
    teethButton.setSelected(true);

    //Register a listener for the check boxes.
    chinButton.addItemListener(itemListener);
    glassesButton.addItemListener(itemListener);
    hairButton.addItemListener(itemListener);
    teethButton.addItemListener(itemListener);

    //Indicates what's on the geek.
    choices = new StringBuffer("cght");

    //Set up the picture label
    pictureLabel = new JLabel();
    pictureLabel.setFont(pictureLabel.getFont().deriveFont(Font.ITALIC));
    updatePicture();

    //Put the check boxes in a column in a panel
    JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
    checkBoxPanel.add(chinButton);
    checkBoxPanel.add(glassesButton);
    checkBoxPanel.add(hairButton);
    checkBoxPanel.add(teethButton);

    add(checkBoxPanel, BorderLayout.WEST);
    add(pictureLabel, BorderLayout.CENTER);
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
  }
  
  ItemListener itemListener = new ItemListener() {

    /* Listens to the check boxes. */
    public void itemStateChanged(ItemEvent e) {
      int index = 0;
      char c = '-';
      Object source = e.getItemSelectable();

      if (source == chinButton) {
        index = 0;
        c = 'c';
      } else if (source == glassesButton) {
        index = 1;
        c = 'g';
      } else if (source == hairButton) {
        index = 2;
        c = 'h';
      } else if (source == teethButton) {
        index = 3;
        c = 't';
      }

      //Now that we know which button was pushed, find out
      //whether it was selected or deselected.
      if (e.getStateChange() == ItemEvent.DESELECTED) {
        c = '-';
      }

      //Apply the change to the string.
      choices.setCharAt(index, c);

      updatePicture();
    }
  };

  protected void updatePicture() {
    //Get the icon corresponding to the image.
    ImageIcon icon = new ImageIcon(
                  "geek/geek-"
                  + choices.toString()
                  + ".gif");
    pictureLabel.setIcon(icon);
    pictureLabel.setToolTipText(choices.toString());
    if (icon == null) {
      pictureLabel.setText("Missing Image");
    } else {
      pictureLabel.setText(null);
    }
  }

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("CheckBoxDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new _07_CheckBoxDemo();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
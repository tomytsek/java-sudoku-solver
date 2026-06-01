import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * _08_RadioButtonDemo.java requires these files:
 *   images/Bird.gif
 *   images/Cat.gif
 *   images/Dog.gif
 *   images/Rabbit.gif
 *   images/Pig.gif
 */
public class _08_RadioButtonDemo extends JPanel {
  static String birdString = "Bird";
  static String catString = "Cat";
  static String dogString = "Dog";
  static String rabbitString = "Rabbit";
  static String pigString = "Pig";

  JLabel picture;

  public _08_RadioButtonDemo() {
    super(new BorderLayout());

    //Create the radio buttons.
    JRadioButton birdButton = new JRadioButton(birdString);
    birdButton.setMnemonic(KeyEvent.VK_B);
    birdButton.setActionCommand(birdString);
    birdButton.setSelected(true);

    JRadioButton catButton = new JRadioButton(catString);
    catButton.setMnemonic(KeyEvent.VK_C);
    catButton.setActionCommand(catString);

    JRadioButton dogButton = new JRadioButton(dogString);
    dogButton.setMnemonic(KeyEvent.VK_D);
    dogButton.setActionCommand(dogString);

    JRadioButton rabbitButton = new JRadioButton(rabbitString);
    rabbitButton.setMnemonic(KeyEvent.VK_R);
    rabbitButton.setActionCommand(rabbitString);

    JRadioButton pigButton = new JRadioButton(pigString);
    pigButton.setMnemonic(KeyEvent.VK_P);
    pigButton.setActionCommand(pigString);

    //Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(birdButton);
    group.add(catButton);
    group.add(dogButton);
    group.add(rabbitButton);
    group.add(pigButton);

    //Register a listener for the radio buttons.
    birdButton.addActionListener(listener);
    catButton.addActionListener(listener);
    dogButton.addActionListener(listener);
    rabbitButton.addActionListener(listener);
    pigButton.addActionListener(listener);

    //Set up the picture label.
    picture = new JLabel(new ImageIcon(
                       birdString
                       + ".gif"));

    //The preferred size is hard-coded to be the width of the
    //widest image and the height of the tallest image.
    //A real program would compute this.
    picture.setPreferredSize(new Dimension(177, 122));


    //Put the radio buttons in a column in a panel.
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
    radioPanel.add(birdButton);
    radioPanel.add(catButton);
    radioPanel.add(dogButton);
    radioPanel.add(rabbitButton);
    radioPanel.add(pigButton);

    add(radioPanel, BorderLayout.WEST);
    add(picture, BorderLayout.CENTER);
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
  }

  ActionListener listener = new ActionListener() {
    /* Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
      picture.setIcon(new ImageIcon(e.getActionCommand() + ".gif"));
    }
  };

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("RadioButtonDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new _08_RadioButtonDemo();
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
/******************************************
*                                         
* Official Name:  Brian Heckman                         
*                                         
* E-mail:  baheckma@syr.edu               
*                                         
* Final Project:  Yahtzee game               
*                                         
* Compiler:  drJava on a pc               
*                                         
* Date:  Dec. 2, 2013              
*                                         
*******************************************/
import java.util.Scanner; 
import java.util.Random; 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
  
public class PlayerInformation extends JPanel 
{ 
  JFrame holdingFrame;       // frame for holding a panel  
  PlayerInformation p1;      // this panel
  HighRoll hr;               // the panel that will follow
  /*----------------- (AR) --------------------*/
  public static JTextField[] name = new JTextField[2];  
  public static Player[] player = new Player[2]; 
    
//-------------------------------------------------------- 
// Constructor: sets up the panel for player1 
//-------------------------------------------------------- 
  public PlayerInformation(JFrame frame) 
  { 
    p1 = this; 
    holdingFrame = frame; 
    
    JLabel instructions = new JLabel("Do Not Press Enter");
    JLabel name1Heading = new JLabel ("Player 1, please enter your name (up to 5 characters)"); 
    name1Heading.setPreferredSize(new Dimension(500, 100));               // set label size 
    name1Heading.setFont(name1Heading.getFont().deriveFont(16.0f));       // increase font size 
    name1Heading.setHorizontalAlignment(SwingConstants.CENTER);           // center the text in the label 
    add(name1Heading); 
    add(instructions);
                                     
      
    /*-------------------- (AR) --------------------------*/
    /*------------------- (GUI2) -------------------------*/
    // create an array of JTextField to store each players name 
    name[0] = new JTextField(20);
    name[1] = new JTextField(20);
    
    name[0].addActionListener(new TextListener());          // add a listener to listen for the text input 
    add(name[0]);
      
    JLabel instructions2 = new JLabel("Press Enter");                                 
    JLabel name2Heading = new JLabel("Player 2, please enter you name (up to 5 characters)"); 
    name2Heading.setPreferredSize(new Dimension(500, 100));               // set label size 
    name2Heading.setFont(name2Heading.getFont().deriveFont(16.0f));       // increase font size 
    name2Heading.setHorizontalAlignment(SwingConstants.CENTER);           // center the text in the label 
    add(name2Heading); 
    add(instructions2);
      
    name[1].addActionListener(new TextListener()); 
    add(name[1]); 
  } 
    

  /*----------------------- (LI) --------------------------------*/
  public class TextListener implements ActionListener 
  { 
    //--------------------------------------------------------------------- 
    // listener for the JTextField -- executes when enter key is pressed 
    //---------------------------------------------------------------------  
    public void actionPerformed(ActionEvent event) 
    { 
      /*----------------------- (CL) ------------------------------*/
      player[0] = new Player(name[0].getText());
      player[1] = new Player(name[1].getText());
      
      // flag to make sure names are no more than 5 chars
      if ((name[0].getText().length() > 5) || (name[0].getText().length() > 5)) {
        JOptionPane.showMessageDialog(null, "No more than 5 character please");
        
        // reshow the original player information panel
        holdingFrame.remove(p1);                    // remove the old panel 
        p1 = new PlayerInformation(holdingFrame);   // create the new panel to be added 
        holdingFrame.add(p1);                       // add the panel to the frame 
        holdingFrame.validate();                    // redisplay the frame
      }
      // flag to make sure both players enter a name
      if ((name[1].getText().equals("")) || (name[1].getText().equals("")))  {
        JOptionPane.showMessageDialog(null, "Both players must enter a name");
        
        // reshow the original player information panel        
        holdingFrame.remove(p1);                    // remove the old panel 
        p1 = new PlayerInformation(holdingFrame);   // create the new panel to be added 
        holdingFrame.add(p1);                       // add the panel to the frame 
        holdingFrame.validate();                    // redisplay the frame
      }
      
      else {
      holdingFrame.remove(p1);                     // remove the old panel 
      hr = new HighRoll(holdingFrame);             // create the new panel to be added 
      holdingFrame.add(hr);                        // add the panel to the frame 
      holdingFrame.validate();                     // redisplay the frame 
      }
    } 
  } 
    
}

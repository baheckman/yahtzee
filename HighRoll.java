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
  
public class HighRoll extends JPanel 
{ 
  JFrame holdingFrame;                   // frame for holding a panel
  HighRoll hr;                           // this panel
  PlayYahtzee py;                        // next panel
  JLabel highRollLabel = new JLabel();   // label for instructions
  JButton roll = new JButton("Roll");    // button for rolling
  int count = 1;                         // to be used with rolling, further explained below
    
  public HighRoll(JFrame frame) 
  {     
    setBackground(Color.red); 
      
    hr = this; 
    holdingFrame = frame; 
    
    highRollLabel = new JLabel(PlayerInformation.player[0].getName() + ", please roll");
    
    highRollLabel.setPreferredSize(new Dimension(500, 100));               // set label size 
    highRollLabel.setFont(highRollLabel.getFont().deriveFont(32.0f));      // increase font size 
    highRollLabel.setHorizontalAlignment(SwingConstants.CENTER);           // center the text in the label 
    add(highRollLabel);    // add highRollLabel to the panel  
      
    add(PlayerInformation.player[0].dice[0]);               // adds diepanel to the frame 
      
    // implement a listener for the roll button and adds it to the panel 
    ButtonListener rollListener = new ButtonListener(); 
    roll.addActionListener(rollListener); 
    add(roll); 
      
  } 
  
//------------------------------------------------------------
// change the panel for when player 2 will roll
//------------------------------------------------------------
   public void player2Roll()
   {
     /*-------------------------- (GUI3) ---------------------------------*/
      highRollLabel.setText(PlayerInformation.player[1].getName() + ", please roll");
      validate();
      count++;
     
   }
   
/*---------------------------- (LI) ---------------------------------*/
  private class ButtonListener implements ActionListener 
  { 
//------------------------------------------------------------- 
// Button Listener - when roll is clicked, roll rhe die 
//------------------------------------------------------------- 
    public void actionPerformed (ActionEvent event) 
    {  
      // count is a variable to keep track of the roll process
      // if count = 1, then only player 1 has rolled
      // when count = 2, both players have rolled and the game will start
      
      if (count == 1) {
        PlayerInformation.player[0].roll();
        
        holdingFrame.validate();
        hr.revalidate();
        hr.repaint();
        System.out.println(PlayerInformation.player[0].getFaceValue());
        player2Roll();
      }
      else {
        PlayerInformation.player[1].roll();
        holdingFrame.validate();
        hr.revalidate();
        hr.repaint();
        
        System.out.println(PlayerInformation.player[1].getFaceValue());
        
        // if one player rolls high than the other, move on to start the game in a new panel
        // if they roll the same fave value, reroll                                         
        
        if (PlayerInformation.player[0].getFaceValue() > PlayerInformation.player[1].getFaceValue()) {
          System.out.println(PlayerInformation.player[0] + " goes first");
          
          holdingFrame.remove(hr);                                         // remove the old panel 
          py = new PlayYahtzee(PlayerInformation.player[0],
                               PlayerInformation.player[1], holdingFrame); // create the new panel to be added 
          holdingFrame.add(py);                                            // add the panel to the frame 
          holdingFrame.validate();                                         // redisplay the frame 
        }
        else if (PlayerInformation.player[0].getFaceValue() == PlayerInformation.player[1].getFaceValue()) {
          System.out.println("reroll");
          highRollLabel.setText(PlayerInformation.player[0].getName() + ", please roll");
          count = 1;
        }
        else {
          System.out.println(PlayerInformation.player[1] + " goes first");
          
          holdingFrame.remove(hr);                                         // remove the old panel 
          py = new PlayYahtzee(PlayerInformation.player[1],
                               PlayerInformation.player[0], holdingFrame); // create the new panel to be added 
          holdingFrame.add(py);                                            // add the panel to the frame 
          holdingFrame.validate();                                         // redisplay the frame 
        }  
      }
        
    } // end roll listener event 
  } // end ButtonListener 
}

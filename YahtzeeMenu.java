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
import java.io.*; 
  
public class YahtzeeMenu extends JPanel 
{ 
  JFrame holdingFrame;      // holds a panel
  PlayerInformation p1;     // the panel that will follow this one 
  HighRoll hr;              // next panel
  YahtzeeMenu ym;           // this panel 
    
  
  public YahtzeeMenu(JFrame frame) 
  { 
    ym = this;  //need to do this so Listener will have access to this panel 
    holdingFrame = frame; 
      
    JLabel title = new JLabel("YAHTZEE");                   // create title label 
    title.setPreferredSize(new Dimension(550, 100));        // set label size 
    title.setFont(title.getFont().deriveFont(64.0f));       // increase font size 
    title.setHorizontalAlignment(SwingConstants.CENTER);    // center the text in the label 
    add(title);                                             // add title to titleMenu Panel 
  
    /*------------------- (LM) -----------------------------*/
    setLayout (new FlowLayout());                           // LAYOUT MANAGER to organize the buttons 
    setBackground(Color.green); 
      
    /*------------------ (GUI1) ----------------------------*/
    JButton instructions = new JButton("Instructions");     // create button for the instructions 
    JButton play = new JButton("Play Yahtzee");             // create button to play 
    add(instructions);                                      // add instructions to titleMenu panel 
    add(play);                                              // add play to titleMenu panel 
      
    setPreferredSize(new Dimension(550, 500)); 
    setBackground(Color.green); 
      
    //add the listener to play button 
    PlayListener playListener = new PlayListener(); 
    play.addActionListener(playListener); 
      
    // add listener to instruction button 
    InstrucListener instructionsListener = new InstrucListener(); 
    instructions.addActionListener(instructionsListener); 
  } 
    
  private class PlayListener implements ActionListener 
  { 
    public void actionPerformed (ActionEvent event) 
    { 
      holdingFrame.remove(ym);                    // remove the old panel 
      p1 = new PlayerInformation(holdingFrame);   // create the new panel to be added 
      holdingFrame.add(p1);                       // add the panel to the frame 
      holdingFrame.validate();                    // redisplay the frame 
    } 
  } 
    
  /*---------------------------- (LI) -------------------------------*/
  private class InstrucListener implements ActionListener 
  { 
    //--------------------------------------------------------------------
    // listener - if instructions button is pressed, show instructions
    //--------------------------------------------------------------------
    public void actionPerformed (ActionEvent event) 
    { 
      // read instructions 
      /*-------------------------- (I/O) --------------------------------*/
      
      try {
        System.out.println ("File Found: ");
        Scanner fileReader=new 
                         Scanner(new File("YahtzeeInstructions.txt"));
        while (fileReader.hasNext())
        {
          System.out.println(fileReader.nextLine());
        }
      }
    catch(FileNotFoundException e)
    {
      System.out.println("Oops! File not found.");
    }  //end catch  
    
    } 
  } 
} 

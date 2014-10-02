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
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class DiePanel extends JPanel
{
  private Die die = new Die();  // die for this panel
  
  
  //Constructor
  public DiePanel ()
  {
    setBackground(Color.white); // dice background
    setPreferredSize(new Dimension(75, 75));
  }
 
  // return the dice
  public Die getDie()
  { 
    return die; 
  }
  
  // rolls and returns the face value
  public int roll()
  {
    die.roll();
    revalidate();
    repaint();
    return die.getFaceValue();
  }
  
  // returns the face value of the dice
  public int getFaceValue()
  {
    return die.getFaceValue();
  }
  
  //draw the panel with a die
  public void paintComponent (Graphics page)
  {
    super.paintComponent (page);
    die.draw(page); //draw the die  
  }
}

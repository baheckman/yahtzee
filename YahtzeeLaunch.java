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
* 
*******************************************/
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
  
public class YahtzeeLaunch 
{ 
//---------------------------------------------------- 
//   This program launches the Yahtzee app 
//---------------------------------------------------- 
  public static void main (String[] args) 
  { 
    JFrame frame = new JFrame ("Yahtzee"); 
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
      
    frame.getContentPane().add(new YahtzeeMenu(frame));  
      
    frame.pack(); 
    
    frame.setVisible(true); 
  } 
}

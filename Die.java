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
import java.util.Random;

public class Die
{     
  private final int MAX = 6;  // maximum face value      
  private int faceValue;      // current value showing on the die     
  private int x, y, size; 
  
//-----------------------------------------------------------------     
//  Constructor: Sets random faceValue.    
//-----------------------------------------------------------------     
  public Die()     
  {        
    faceValue = 1;   
    x = 12; 
    y = 12; 
    size = 50; 
    roll(); 
  }  
    
//-----------------------------------------------------------------     
//  Rolls the die and returns the result.     
//-----------------------------------------------------------------     
  public int roll()     
  {     
    Random generator = new Random();
    faceValue = (generator.nextInt(6) + 1);
    return faceValue;     
  }       

  
//-----------------------------------------------------------------     
//  Face value accessor.     
//-----------------------------------------------------------------     
  public int getFaceValue()     
  {        
    return faceValue;     
  } 
  
//-----------------------------------------------------------------
// face value mutator
//-----------------------------------------------------------------
  public void setFaceValue(int faceVal)
  {
    faceValue = faceVal;
  }
    
//-----------------------------------------------------------------     
//  Returns a string representation of this die.     
//-----------------------------------------------------------------     
  public String toString()     
  {        
    String result = Integer.toString(faceValue);         
    return result;     
  }  
   
//-----------------------------------------------------------------     
//  draws the die 
//-----------------------------------------------------------------      
  public void draw(Graphics page)   
  { 
    page.setColor(Color.blue);
      
    page.setColor(Color.red); 
    switch (faceValue) {
    case 1: {
      page.fillOval(x+size/2-5,y+size/2-5,10,10); 
      break;
      } 
    case 2:
    { 
      page.fillOval(x+5,y+5,10,10); 
      page.fillOval(x+size-15,y+size-15,10,10); 
      break;
    } 
    case 3:  { 
      page.fillOval(x+5,y+5,10,10); 
      page.fillOval(x+size/2-5,y+size/2-5,10,10); 
      page.fillOval(x+size-15,y+size-15,10,10);
      break;
      } 
    case 4: { 
      page.fillOval(x+5,y+5,10,10); 
      page.fillOval(x+size-15,y+5,10,10); 
      page.fillOval(x+5,y+size-15,10,10); 
      page.fillOval(x+size-15,y+size-15,10,10); 
      break;
      } 
    case 5: { 
      page.fillOval(x+5,y+5,10,10); 
      page.fillOval(x+size-15,y+5,10,10); 
      page.fillOval(x+5,y+size-15,10,10); 
      page.fillOval(x+size-15,y+size-15,10,10); 
      page.fillOval(x+size/2-5,y+size/2-5,10,10); 
      break;
      } 
    case 6: { 
      page.fillOval(x+5,y+5,10,10); 
      page.fillOval(x+size-15,y+5,10,10); 
      page.fillOval(x+5,y+size-15,10,10); 
      page.fillOval(x+size-15,y+size-15,10,10); 
      page.fillOval(x+5,y+size/2-5,10,10); 
      page.fillOval(x+size-15,y+size/2-5,10,10);
      break;  
      }
      default: {
        break;
      }
    }// end switch statement
  }// end draw function
      
//--------------------------------------------------------
//Draws a die to the right of another die
//--------------------------------------------------------
      public void drawRight(Graphics page)
      {
        x = x + 12 + size;
        draw(page);
      }
}

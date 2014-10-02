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
import java.util.Collections;
import java.util.ArrayList;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;

public class Player
{
  public String name;
  public int score;
  public DiePanel[] dice = new DiePanel[5];
  public int[] scoreTable = new int[13];               // array  to keep score in a table
  
//----------------------------------------------------------------
// Constructor - initialize values
//----------------------------------------------------------------
  public Player(String n)
  {
    name = n;
    score = 0;
    
    // initialize all dice and rerollButtons in their respective arrays
    for (int i = 0; i < 5; i++) {
      dice[i] = new DiePanel();
    }
  }
  
//-------------------------------------------------
// name accessor
//-------------------------------------------------
  public String getName()
  {
    return name;
  }
  
//-------------------------------------------------
// score accessor
//-------------------------------------------------
  public int getScore()
  {
    return score;
  }
  
//-------------------------------------------------
// score mutator
//-------------------------------------------------
  public void setScore(int s)
  {
    score += s;
  }
  
//-------------------------------------------------
// rolls all 5 die
//-------------------------------------------------
  public void rollAll()
  {
    for (int i = 0; i < 5; i++) {
      dice[i].roll();
    }
  }
  
//--------------------------------------------------
// roll only the first die
//--------------------------------------------------
  public int roll() {
    return dice[0].roll();
  }
  
//--------------------------------------------------
// roll a specific die
//--------------------------------------------------
  public int roll(int i) {
    return dice[i].roll();
  }
  
//---------------------------------------------------
// roll 2 dice
//---------------------------------------------------
  public void roll(int a, int b) 
  {
    {
      int one = a;
      int two = b;
      
      dice[one].roll();
      dice[two].roll();
    }
  }
    
//---------------------------------------------------
// roll 3 dice
//---------------------------------------------------
  public void roll(int a, int b, int c) 
  {
    {
      int one = a;
      int two = b;
      int three = c;
      
      dice[one].roll();
      dice[two].roll();
      dice[three].roll();
    }
  }
  
//---------------------------------------------------
// roll 4 dice
//---------------------------------------------------
  public void roll(int a, int b, int c, int d) 
  {
    {
      int one = a;
      int two = b;
      int three = c;
      int four = d;
      
      dice[one].roll();
      dice[two].roll();
      dice[three].roll();
      dice[four].roll();
    }
  }
  
//--------------------------------------------------
// return face value of a the first die
//--------------------------------------------------
  public int getFaceValue()
  {
    return dice[0].getFaceValue();
  }
  
//--------------------------------------------------
// return the face value of a specified die
//--------------------------------------------------
  public int getFaceValue(int i)
  {
    return dice[i].getFaceValue();
  }
  
//---------------------------------------------------
// to String (output)
//---------------------------------------------------
  public String toString()
  {
    return (name + ": " + score);
  }

//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------  
//-----------------------------------------------------------------------------
//   CHECK SCORES | CHECK SCORES | CHECK SCORES | CHECK SCORES | CHECK SCORES
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
//-----------------------------------------------------------------------------
  
//-----------------------------------------------------------------------------
// Check Aces - see if a 1 is rolled
//-----------------------------------------------------------------------------
  public int checkAces()
  {
    int total = 0;            // total rolled
    
    // find total number of ones rolled
    // then add the other values to get the total score available
    for (int i = 0; i < 5; i++) {
      if (dice[i].getFaceValue() == 1) {
        total+=1;
      }
    }
    return total;
  }
   
//-----------------------------------------------------------------------------
// Check Twos - see if a 2 is rolled
//-----------------------------------------------------------------------------
  public int checkTwos()
  {
    int total = 0;            // total rolled
    
    // find total number of twos rolled
    // then add the other values to get the total score available
    for (int i = 0; i < 5; i++) {
      if (dice[i].getFaceValue() == 2) {
        total+=2;
      }
    }
    return total;
  }
  
//-----------------------------------------------------------------------------
// Check Threes - see if a 3 is rolled
//-----------------------------------------------------------------------------
  public int checkThrees()
  {
    int total = 0;            // total rolled
    
    // find total number of threes rolled
    // then add the other values to get the total score available
    for (int i = 0; i < 5; i++) {
      if (dice[i].getFaceValue() == 3) {
        total+=3;
      }
    }
    return total;
  }
  
//-----------------------------------------------------------------------------
// Check Fours - see if a 4 is rolled
//-----------------------------------------------------------------------------
  public int checkFours()
  {
    int total = 0;            // total rolled
    
    // find total number of fours rolled
    // then add the other values to get the total score available
    for (int i = 0; i < 5; i++) {
      if (dice[i].getFaceValue() == 4) {
        total+=4;
      }
    }
    return total;
  }
  
//-----------------------------------------------------------------------------
// Check Fives - see if a 5 is rolled
//-----------------------------------------------------------------------------
  public int checkFives()
  {
    int total = 0;            // total rolled
    
    // find total number of fives rolled
    // then add the other values to get the total score available
    for (int i = 0; i < 5; i++) {
      if (dice[i].getFaceValue() == 5) {
        total+=5;
      }
    }
    return total;
  }
  
//-----------------------------------------------------------------------------
// Check Sixes - see if a 6 is rolled
//-----------------------------------------------------------------------------
  public int checkSixes()
  {
    int total = 0;            // total rolled
    
    // find total number of sixes rolled
    // then add the other values to get the total score available
    for (int i = 0; i < 5; i++) {
      if (dice[i].getFaceValue() == 6) {
        total+=6;
      }
    }
    return total;
  }
  
//----------------------------------------------------------
// check for 3 of a kind
//----------------------------------------------------------
  public int check3oK()
  {
    int[] tally = new int[7];
    int total = 0;
    
    // tally the number of times 1 - 6 were rolled
    for (int i = 0; i < 5; i++) {
      for (int c = 0; c < 7; c++) {
        if (c == dice[i].getFaceValue())
            tally[c]++;
      }
    }
    // if the tally for any roll are 3 or over it is a 3 of a kind
    for (int i = 0; i < 7; i++) {
      if (tally[i] >= 3) {
        for (int c = 0; c < 5; c++) {
          total += dice[c].getFaceValue();
        }
      }
    }
    return total;
  }
  
//----------------------------------------------------------
// check for 4 of a kind
//----------------------------------------------------------
  public int check4oK()
  {
    int[] tally = new int[7];
    int total = 0;
    
    // tally the number of times 1 - 6 were rolled
    for (int i = 0; i < 5; i++) {
      for (int c = 0; c < 7; c++) {
        if (c == dice[i].getFaceValue())
            tally[c]++;
      }
    }
    // if any numbers were rolled 4 or more times it is a four of a kind
    for (int i = 0; i < 7; i++) {
      if (tally[i] >= 4) {
        for (int c = 0; c < 5; c++) {
          total += dice[c].getFaceValue();
        }
      }
    }
    return total;
  }
  
//----------------------------------------------------------
// check for a full house
//----------------------------------------------------------
  public int checkFullHouse()
  {
    int[] tally = new int[7];
    int total = 0;
    boolean exists3 = false;
    boolean exists2 = false;
    
    // tally the number of times 1 - 6 were rolled
    for (int i = 0; i < 5; i++) {
      for (int c = 0; c < 7; c++) {
        if (c == dice[i].getFaceValue())
            tally[c]++;
      }
    }
    
    // if a number was rolled 3 times then the 3 matches exist
    for (int i = 0; i < 7; i++) {
      if (tally[i] == 3) {
        exists3 = true;
        for (int c = 0; c < 5; c++) {
          total += dice[c].getFaceValue();
        }
      }
    }
    
   // if a number was also rolled twice then the 2 matches exiest
    for (int i = 0; i < 7; i++) {
      if (tally[i] == 2 && total != 0) {
        exists2 = true;
        for (int c = 0; c < 5; c++) {
          total += dice[c].getFaceValue();
        }
      }
    }
    // if both matches exist then it is a full house (worth 25 points)
    if (exists3 == true && exists2 == true)
      total = 25;
    else
      total = 0;
    return total;
  }
 
//----------------------------------------------------------
// check for a small straight (4 in a row)
//----------------------------------------------------------
  public int checkSmallStraight()
  {
    int total = 0;
    /*--------------------------- (AR) -------------------------------*/
    ArrayList<Integer> orderedDice = new ArrayList<Integer>();
    
    // store the value of all 5 dice into the arraylist
    for (int i = 0; i < 5; i++) {
      orderedDice.add(dice[i].getFaceValue());
    }
    
    // sort the array list numerically
    Collections.sort(orderedDice);
    
    // if the conditions of the dice meet the conditions of a small straight, player gets 30 points
    // small staight (1, 2, 3, 4) (2, 3, 4, 5) (3, 4, 5, 6)
    // since there a 6 dice and it must be 4 in a row there are several possibilites to account for
    if((orderedDice.get(0) == 1 && orderedDice.get(1) == 1 && orderedDice.get(2) == 2 && 
        orderedDice.get(3) == 3 && orderedDice.get(4) == 4) || 
       (orderedDice.get(0) == 1 && orderedDice.get(1) == 2 && orderedDice.get(2) == 2 && 
        orderedDice.get(3) == 3 && orderedDice.get(4) == 4) || 
       (orderedDice.get(0) == 1 && orderedDice.get(1) == 2 && orderedDice.get(2) == 3 && 
        orderedDice.get(3) == 3 && orderedDice.get(4) == 4) ||
       (orderedDice.get(0) == 1 && orderedDice.get(1) == 2 && orderedDice.get(2) == 3 &&
        orderedDice.get(4) == 4))
      total = 30;
     else if((orderedDice.get(0) == 2 && orderedDice.get(1) == 2 && orderedDice.get(2) == 3 && 
              orderedDice.get(3) == 4 && orderedDice.get(4) == 5) || 
             (orderedDice.get(0) == 2 && orderedDice.get(1) == 3 && orderedDice.get(2) == 3 && 
              orderedDice.get(3) == 4 && orderedDice.get(4) == 5) || 
             (orderedDice.get(0) == 2 && orderedDice.get(1) == 3 && orderedDice.get(2) == 4 && 
              orderedDice.get(3) == 4 && orderedDice.get(4) == 5) ||
             (orderedDice.get(0) == 2 && orderedDice.get(1) == 3 && orderedDice.get(2) == 4 &&
              orderedDice.get(4) == 5))
       total = 30;
     else if((orderedDice.get(0) == 3 && orderedDice.get(1) == 3 && orderedDice.get(2) == 4 && 
              orderedDice.get(3) == 5 && orderedDice.get(4) == 6) || 
             (orderedDice.get(0) == 3 && orderedDice.get(1) == 4 && orderedDice.get(2) == 4 && 
              orderedDice.get(3) == 5 && orderedDice.get(4) == 6) || 
             (orderedDice.get(0) == 3 && orderedDice.get(1) == 4 && orderedDice.get(2) == 5 && 
              orderedDice.get(3) == 5 && orderedDice.get(4) == 6) ||
             (orderedDice.get(0) == 3 && orderedDice.get(1) == 4 && orderedDice.get(2) == 5 &&
              orderedDice.get(4) == 6))
      total = 30;
 
 
    return total;
  }
 
//----------------------------------------------------------
// check for a large straight (5 in a row)
//----------------------------------------------------------
  public int checkLargeStraight()
  {
    int total = 0;
    /*------------------------- (AR) ------------------------------*/
    ArrayList<Integer> orderedDice = new ArrayList<Integer>();
    
    // store the values of the dice into an arraylist
    for (int i = 0; i < 5; i++) {
      orderedDice.add(dice[i].getFaceValue());
    }
    
    // sort the list numerically
    Collections.sort(orderedDice);
    
    // if the conditions of the dice meet the conditions of a large straight, player gets 40 points
    // large staright (1, 2, 3, 4, 5) (2, 3, 4, 5, 6)
    if((orderedDice.get(0) == 1 && orderedDice.get(1) == 2 && orderedDice.get(2) == 3 && 
        orderedDice.get(3) == 4 && orderedDice.get(4) == 5) || (orderedDice.get(0) == 2 && 
        orderedDice.get(1) == 3 && orderedDice.get(2) == 4 && orderedDice.get(3) == 5 && 
        orderedDice.get(4) == 6))
      total = 40;
 
    return total;
  }
  
//----------------------------------------------------------
// check yahtzee (all 5 die rolled the same face value)
//----------------------------------------------------------
    public int checkYahtzee()
    {
      // yahtzee is 5 of the same number
      // if every dice has the same face value it is a yahtzee (worth 50 points)
      if (dice[0].getFaceValue() == dice[1].getFaceValue() &&
          dice[1].getFaceValue() == dice[2].getFaceValue() &&
          dice[2].getFaceValue() == dice[3].getFaceValue() &&
          dice[3].getFaceValue() == dice[4].getFaceValue())
        return 50;
      else
        return 0;
    }
    
//-----------------------------------------------------------
// chance -- if you have no other combinations, sum all dice
//-----------------------------------------------------------
    public int checkChance()
    {
      int total = 0;
      for (int i = 0; i < 5; i++) {
        total += dice[i].getFaceValue();
      }
      return total;
    }
    
 //----------------------------------------------------------
 // find total scores for the end of the game
 //----------------------------------------------------------
    public int totalScore(Player p)
    {
      Player player  = p;
      int total = getScore();
      
      if ((scoreTable[0] + scoreTable[1] + scoreTable[2] + 
          scoreTable[3] + scoreTable[4] + scoreTable[5]) > 62)
        total += 35;
        
      total += (scoreTable[6] + scoreTable[7] + scoreTable[8] +
                scoreTable[9] + scoreTable[10] + scoreTable[11] +
                scoreTable[12]);
      return total;
    }
 //----------------------------------------------------------
 // create a table with the players scores
 //----------------------------------------------------------
    public String setScoreTable(Player p)
    {
      Player player = p;
      
      // table to keep track of the scores
      String table = (
                      "\n\t\t\t\tCURRENT SCORES\t\n" + 
                      "\t\tRoll:\t" + dice[0].getFaceValue() +"\t" + dice[1].getFaceValue() + "\t" + 
                      dice[2].getFaceValue() + "\t" + dice[3].getFaceValue() + "\t" +
                      dice[4].getFaceValue() + "\n\n\t\tAces\tTwos\tThrees\tFours\tFives\tSixes\n" + 
                      toString() + "\t\t" + scoreTable[0] + "\t" + scoreTable[1] + "\t" +
                      scoreTable[2] + "\t" + scoreTable[3] + "\t" +
                      scoreTable[4] + "\t" + scoreTable[5] + 
                      "\n\t\t3oK\t4oK\tF.H.\tS.S.\tL.S.\tYahtzee\tChance\n" + 
                      "\t\t" + scoreTable[6] + "\t" + scoreTable[7] + "\t" +
                      scoreTable[8] + "\t" + scoreTable[9] + "\t" + 
                      scoreTable[10] + "\t" + scoreTable[11] + "\t" +
                      scoreTable[12] + "\n");
      return table;
    }
    
    //------------------------------------------------------------
    // output a table to keep score
    //------------------------------------------------------------
    public String setScoreTable(Player p, int i, int s)
    {
      Player player = p;
      int score = s;
      int index = i;
      
      setScore(s);
      scoreTable[index - 1] = s;
      
      // output a table for scoring
      String table = (
                      "\n\n\tRoll:\t" + dice[0].getFaceValue() + "\t" + dice[1].getFaceValue() + "\t" +
                      dice[2].getFaceValue() + "\t" + dice[3].getFaceValue() + "\t" + dice[4].getFaceValue() +
                      "\n\n\t\t\t\tSCORE TABLE\t" +
                      "\n\t\tAces\tTwos\tThrees\tFours\tFives\tSixes\n" + 
                      toString() + "\t\t" + scoreTable[0] + "\t" + scoreTable[1] + "\t" +
                      scoreTable[2] + "\t" + scoreTable[3] + "\t" +
                      scoreTable[4] + "\t" + scoreTable[5] + 
                      "\n\t\t3oK\t4oK\tF.H.\tS.S.\tL.S.\tYahtzee\tChance\n" + 
                      "\t\t" + scoreTable[6] + "\t" + scoreTable[7] + "\t" +
                      scoreTable[8] + "\t" + scoreTable[9] + "\t" + 
                      scoreTable[10] + "\t" + scoreTable[11] + "\t" +
                      scoreTable[12] + "\n\n");
      return table;
    }
    
    //----------------------------------------------------------------
    // returnt he score table output for the given player
    //----------------------------------------------------------------
    public String getScoreTable()
    {
      String table = (
                      "\n\n\tRoll:\t" + dice[0].getFaceValue() + "\t" + dice[1].getFaceValue() + "\t" +
                      dice[2].getFaceValue() + "\t" + dice[3].getFaceValue() + "\t" + dice[4].getFaceValue() +
                      "\n\n\t\t\t\t\tSCORE TABLE\t" +
                      "\n\t\t\tAces\tTwos\tThrees\tFours\tFives\tSixes\n" + 
                      toString() + "\t\t\t" + scoreTable[0] + "\t" + scoreTable[1] + "\t" +
                      scoreTable[2] + "\t" + scoreTable[3] + "\t" +
                      scoreTable[4] + "\t" + scoreTable[5] + 
                      "\n\t\t\t3oK\t4oK\tF.H.\tS.S.\tL.S.\tYahtzee\tChance\n" + 
                      "\t\t\t" + scoreTable[6] + "\t" + scoreTable[7] + "\t" +
                      scoreTable[8] + "\t" + scoreTable[9] + "\t" + 
                      scoreTable[10] + "\t" + scoreTable[11] + "\t" +
                      scoreTable[12] + "\n\n");
      return table;
    }
    
    public void savedGameData(Player p)
    {
      Random generator = new Random();
      Player player = p;
      
      // assign random numbers to the scores table
      // but leave a few combinations out to ensure
      // the game can still be played
      p.scoreTable[0] = (1 + generator.nextInt(3));            // random 1s scores
       setScore(p.scoreTable[0]);
        if (p.scoreTable[0] == 6)                               // yahtzee bonus (multiple yahtzee = 100 point bonus)
          setScore(100);
      p.scoreTable[1] = (2 * (1 + generator.nextInt(3)));      // random 2s score
       setScore(p.scoreTable[1]);
       if (p.scoreTable[1] == 12)                               // yahtzee bonus (multiple yahtzee = 100 point bonus)
          setScore(100);
       p.scoreTable[2] = (3 * (1 + generator.nextInt(3)));      // random 3s score
       setScore(p.scoreTable[2]);
       if (p.scoreTable[2] == 18)                               // yahtzee bonus (multiple yahtzee = 100 point bonus)
          setScore(100);
      p.scoreTable[3] = (4 * (1 + generator.nextInt(3)));      // random 4s score
       setScore(p.scoreTable[3]);
       if (p.scoreTable[3] == 24)                               // yahtzee bonus (multiple yahtzee = 100 point bonus)
          setScore(100);
      p.scoreTable[4] = (5 * (1 + generator.nextInt(3)));      // random 5s score
       setScore(p.scoreTable[4]);
       if (p.scoreTable[4] == 30)                               // yahtzee bonus (multiple yahtzee = 100 point bonus)
          setScore(100);
      p.scoreTable[5] = (6 * (1 + generator.nextInt(3)));      // random 6s score
       setScore(p.scoreTable[5]);
       if (p.scoreTable[5] == 36)                               // yahtzee bonus (multiple yahtzee = 100 point bonus)
          setScore(100);
      p.scoreTable[7] = ((generator.nextInt(5)) + (4 * (1 + generator.nextInt(4)))); // random 4oK score
       setScore(p.scoreTable[7]);
      p.scoreTable[8] = 25;                                    // full house
       setScore(p.scoreTable[8]);
      p.scoreTable[9] = 30;                                    // small straight
       setScore(p.scoreTable[9]);
      p.scoreTable[10] = 40;                                   // large straight
       setScore(p.scoreTable[10]);
      p.scoreTable[11] = 50;                                   // yahtzee
       setScore(p.scoreTable[11]);
      
    }
   
}

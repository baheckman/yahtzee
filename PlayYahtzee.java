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
  
public class PlayYahtzee extends JPanel 
{ 
  JFrame holdingFrame;                          // frame for holding a panel 
  HighRoll hr;                                  // previous panel 
  PlayYahtzee py;                               // this panel 
  JLabel playLabel = new JLabel();              // label for instructions 
  JButton roll = new JButton("Roll");           // button for rolling 
  Player player1, player2;                      // 2 players 
  static int turn = 1;                          // keeps track of which player rolls 
  int rerolls = 1;                              // keep track of how many rerolls are used in a turn (2 is max) 
  int numRerolled = 0;                          // ask user how many dice they would like rerolled 
    
  /*---------------------------- (CL) ---------------------------------*/
  public PlayYahtzee(Player p1, Player p2, JFrame frame) 
  {
    setBackground(Color.red);
    
    // give p1 and p2 new names (whoever rolled higher is p1) 
    player1 = p1; 
    player2 = p2; 
      
    py = this;  
    holdingFrame = frame;  
      
    playLabel = new JLabel(player1.getName() + ", please roll");       // instructions label 
    playLabel.setPreferredSize(new Dimension(500, 100));               // set label size  
    playLabel.setFont(playLabel.getFont().deriveFont(32.0f));          // increase font size  
    playLabel.setHorizontalAlignment(SwingConstants.CENTER);           // center the text in the label  
    add(playLabel);        // add playlabel to the panel   
        
    // adds 5 diepanels to the frame (draws them) 
    /*--------------------- (DR) -------------------------*/
    for (int i = 0; i < 5; i ++) { 
      add(player1.dice[i]); 
    } 
      
    // implement a listener for the roll button and adds it to the panel  
    ButtonListener rollListener = new ButtonListener();  
    roll.addActionListener(rollListener); 
    add(roll);  
      
      
      
      
  /* ----------------------------------------------------------------------------------------               
   *                                   Game Algorithm 
   * 1. whichever player rolled higher will begin 
   * 2. first they will roll all 5 dice 
   * 3. next there will be a of check all possible score combinations to see if any were rolled 
   * 4. then the users can chose to reroll the dice up to 3 times if they chose 
   * 5. then the next player will do the same (repeat steps 2 - 4) 
   * ---------------------------------------------------------------------------------------- 
   *          this is to be repeated until both players hit all combinations 
   *             at that time the scores will be compared to see who won 
   *-----------------------------------------------------------------------------------------*/
     
  } 
   
  private class ButtonListener implements ActionListener  
  {  
   //-------------------------------------------------------------  
   // Button Listener - when roll is clicked, roll the die  
   //-------------------------------------------------------------  
    public void actionPerformed (ActionEvent event)  
    {  
      // finished = true for both players print out who won
      if (checkForWinner() == true)
        checkForWinner();
      
      else if ((finished(player1) == false) || (finished(player2) == false)) { 
        
        // player 1's turn 
        if (turn % 2 == 1) { 
          if (turn != 1) {          
          // removes player1s 5 diepanels to the frame (draws them) 
          /*--------------------- (DR) -------------------------*/
            for (int i = 0; i < 5; i ++) { 
              remove(player2.dice[i]); 
            } 
            
            // adds 5 diepanels to the frame (draws them) 
            /*--------------------- (DR) -------------------------*/
            for (int i = 0; i < 5; i ++) { 
              add(player1.dice[i]); 
            } 
          }
          
          // rolls the dice and prints the results of the roll
          for (int i = 0; i < 5; i++) {
            player1.roll(i);
          }
          holdingFrame.validate();
          validate();
          py.repaint();
          
          playLabel.setText(player2.getName() + ", please roll"); 
          validate();
          
          selectScore(player1); 
        }
        
        // player 2s turn 
        if (turn % 2 == 0) { 
          // removes player1s 5 diepanels to the frame (draws them) 
          /*--------------------- (DR) -------------------------*/
          for (int i = 0; i < 5; i ++) { 
            remove(player1.dice[i]); 
          } 
          
          // adds 5 diepanels to the frame (draws them) 
          /*--------------------- (DR) -------------------------*/
          for (int i = 0; i < 5; i ++) { 
            add(player2.dice[i]); 
          }  
          
          // rolls the dice and prints the results of the roll            
          for (int i = 0; i < 5; i++) {
            player2.roll(i);
          }
          holdingFrame.validate();
          validate();
          py.repaint();
          playLabel.setText(player1.getName() + ", please roll"); 
          validate(); 
          
          selectScore(player2);
        }  
        if ((finished(player1) == false) || (finished(player2) == false)) 
            System.out.println("Next Player, please roll from the yahtzee frame");
        else checkForWinner();
        
        PlayYahtzee.turn++;   
      } // end if statement to find finish 
      
    } // end roll listener event  
  } // end button listener 
   
  public boolean checkForWinner()
  {
    // if the game is finished print out both player tbales and annoucne the winner
    if((finished(player1) == true) && (finished(player2) == true)) {
      if (player1.totalScore(player1) > player2.totalScore(player2)) {
        System.out.println();
        System.out.println(player1.getScoreTable());
        System.out.println(player2.getScoreTable());
        System.out.println();
        System.out.println(player1 + " Wins!");
        playLabel.setText(player1 + " Wins!"); 
        validate(); 
      } 
      else if (player1.totalScore(player1) < player2.totalScore(player2)) {
        System.out.println();
        System.out.println(player2.getScoreTable());
        System.out.println(player1.getScoreTable());
        System.out.println();
        System.out.println(player2 + " Wins!");
        playLabel.setText(player2 + " Wins!"); 
        validate(); 
      } 
      else { 
        System.out.println();
        System.out.println(player1.getScoreTable());
        System.out.println(player2.getScoreTable());
        System.out.println();
        System.out.println("Tie!");
        playLabel.setText("TIE!, Play Again!"); 
        validate(); 
      } 
      return true;
    }
    else
      return false;
  }
      
//----------------------------------------------------------- 
// check if finished; no score function will return a 0 
//----------------------------------------------------------- 
    public boolean finished(Player p) 
    { 
      Player player = p; 
        
      if (player.scoreTable[0] > 0 && 
          player.scoreTable[1] > 0 && 
          player.scoreTable[2] > 0 && 
          player.scoreTable[3] > 0 && 
          player.scoreTable[4] > 0 && 
          player.scoreTable[5] > 0 && 
          player.scoreTable[6] > 0 && 
          player.scoreTable[7] > 0 && 
          player.scoreTable[8] > 0 && 
          player.scoreTable[9] > 0 && 
          player.scoreTable[10] > 0 && 
          player.scoreTable[11] > 0 && 
          player.scoreTable[12] > 0) 
        return true; 
      else
        return false; 
    } 
      
    //----------------------------------------------------------- 
    // user will select the score that they want to apply 
    // that score will then be added to that players score table 
    //----------------------------------------------------------- 
    public void selectScore(Player p) 
    { 
      Player player = p; 
        
      // ask the user to input which score they would like to keep 
      System.out.println ("Enter the number of the combination you would like to keep\n" +  
                          "1) Aces: "  + player.checkAces() + "\n" + 
                          "2) Twos: " + player.checkTwos() +"\n" +  
                          "3) Threes: " + player.checkThrees() + "\n" + 
                          "4) Fours: " + player.checkFours() + "\n" +  
                          "5) Fives: " + player.checkFives() + "\n" + 
                          "6) Sixes: " + player.checkSixes() + "\n" +  
                          "7) 3 of a Kind: " + player.check3oK() + "\n" +  
                          "8) 4 of a kind: " + player.check4oK() + "\n" + 
                          "9) Full House: " + player.checkFullHouse() + "\n" +  
                          "10) Small Straight: " + player.checkSmallStraight() + "\n" + 
                          "11) Large Straight: " + player.checkLargeStraight() + "\n" + 
                          "12) Yahtzee: " + player.checkYahtzee() + "\n" +  
                          "13) Chance: " + player.checkChance() + "\n" + 
                          "14) Reroll"); 
                           System.out.println(player.setScoreTable(player)); 
      Scanner input = new Scanner(System.in); 
      int combination = input.nextInt(); 
      
      // set limits and flags for the input
      if ((combination < 1) || (combination > 14)) {
        System.out.println(combination + " is not an option, please go back to the yahtzee frame.");
        JOptionPane.showMessageDialog(null, combination + " is not an option"); 
        selectScore(player); 
      }
      
      // add that score to the score table 
      if (combination == 1) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player,combination, player.checkAces())); 
      } 
      else if (combination == 2) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkTwos())); 
      } 
      else if (combination == 3) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkThrees())); 
      } 
      else if (combination == 4) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkFours())); 
      } 
      else if (combination == 5) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkFives())); 
      } 
      else if (combination == 6) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkSixes())); 
      } 
      else if (combination == 7) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.check3oK())); 
      } 
      else if (combination == 8) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.check4oK())); 
      } 
      else if (combination == 9) { 
        rerolls= 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkFullHouse())); 
      } 
      else if (combination == 10) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkSmallStraight())); 
      } 
      else if (combination == 11) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkLargeStraight())); 
      } 
      else if (combination == 12) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkYahtzee())); 
      } 
      else if (combination == 13) { 
        rerolls = 0; 
        System.out.println(player.setScoreTable(player, combination, player.checkChance())); 
      } 
      else if (combination == 14) 
        if (rerolls < 3) 
          rerollData(player); 
        else { 
          JOptionPane.showMessageDialog(null, "You can only reroll twice!"); 
          selectScore(player); 
      } 
    } 
      
    //----------------------------------------------
    // Rerolling the dice - ask how many, then which dice to reroll
    //-----------------------------------------------
    public void rerollData(Player p) 
    { 
      Player player = p; 
      Scanner input = new Scanner(System.in); 
      int rI1 = 0;                            // index of the dice to reroll
      int rI2 = 0; 
      int rI3 = 0; 
      int rI4 = 0; 
      int rI5 = 0; 
      rerolls++; 
        
      // prompt for how many dice to reroll
      // if it is 0, take user back to select a score option
      // if it over ask how many again
      System.out.println ("How many die would you like to reroll?"); 
        numRerolled = input.nextInt();
        if (numRerolled == 0)
          selectScore(player);
        else if (numRerolled > 5)
          rerollData(player);
        
        // based on how any dice are being rerolled ask which dice then reroll them
        if (numRerolled == 1) { 
            System.out.println("Which dice would you like to reroll (1 - 5)"); 
              rI1 = input.nextInt(); 
              player.roll((rI1 - 1)); 
              selectScore(player); 
        } 
          
        else if (numRerolled == 2) { 
          System.out.println("What are the 2 die you would like to reroll (1 - 5) (seperate by a space)"); 
          rI1 = input.nextInt(); 
          rI2 = input.nextInt(); 
          player.roll((rI1 - 1), (rI2 - 1)); 
          selectScore(player); 
        } 
          
        else if (numRerolled == 3 ) { 
          System.out.println("What are the 3 die you would like to reroll (1 - 5) (seperate by spaces)"); 
          rI1 = input.nextInt(); 
          rI2 = input.nextInt(); 
          rI3 = input.nextInt(); 
          player.roll((rI1 - 1), (rI2 - 1), (rI3 - 1)); 
          selectScore(player); 
        } 
          
         else if (numRerolled == 4 ) { 
          System.out.println("What are the 4 die you would like to reroll (1 - 5) (seperate by spaces)"); 
          rI1 = input.nextInt(); 
          rI2 = input.nextInt(); 
          rI3 = input.nextInt(); 
          rI4 = input.nextInt(); 
          player.roll((rI1 - 1), (rI2 - 1), (rI3 - 1), (rI4 - 1)); 
          selectScore(player); 
        } 
           
         else if (numRerolled == 5 ) {
          player.rollAll(); 
          selectScore(player);
         }
           
         else { 
           JOptionPane.showMessageDialog(null, "Invalid Number, try again"); 
           rerolls = 0; 
           selectScore(player); 
         } 
    } 
}

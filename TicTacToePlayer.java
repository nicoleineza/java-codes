import java.util.Scanner;
/*discussed with Eddy Kubwimana */

/**
 * This class represents a player in the game of Tic-Tac-Toe.
 * 
 * 
 */
public class TicTacToePlayer{
  private String name;
  private String symbol;
  
  /**
   * This method reads in the player's name and desired symbol.
   * It allows only non-digit single-character symbols.
   */
  public void getPlayerInfo() {
    Scanner input = new Scanner(System.in);
    String pattern = "[^\\d]";
    String answer;
    
    System.out.print("What is your name? ");
    name = input.next();
    
    do {
      System.out.print("What symbol would you like to use? ");
      answer = input.next();
      if (!answer.matches(pattern)){
        System.out.println("Your symbol must be exactly one character, " + 
                           "and cannot be a digit");
      } else
        symbol = answer;
    } while (!answer.matches(pattern));
  }
  
  /**
   * Retrieves the name of the player.
   */
  public String getName(){
    return name;
  }
  
  /**
   * Retrieves the symbol of the player.
   */
  public String getSymbol(){
    return symbol;
  }
}
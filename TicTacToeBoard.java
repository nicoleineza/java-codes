 import java.util.Scanner;
 /*discussed with Eddy Kubwimana */

/**
 * This class represents the board for a game of 
 * TicTacToe
 * 
 * 
 */
public class TicTacToeBoard {

    private String[][] board; // the board 
    private int numEmpty; // The number of empty slots
    private boolean detectedWin; // Whether or not a winner has been seen
    private String winningSymbol; // The symbol of the winner
    public static final int SIZE = 3;
    public static final String EMPTY = ".";

    /**
     * The constructor for the class. 
     * It instantiates the 3x3 board and initializes the board to be empty.
     * You should also initialize the number of empty slots
     * 
     */
    public TicTacToeBoard() {
        // TODO: Complete the method
        numEmpty= SIZE*SIZE;
       board= new String[SIZE][SIZE];
       for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = "-";
            
            
        }
    }

        // This part below has been done for you, for free 😄
        detectedWin = false;
        winningSymbol = "";
    }

    /**
     * It prints the board
     */
    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * If the number of empty spaces is 0, then the board is full
     * 
     * @return whether or not the board is full.
     */
    public boolean isBoardFull(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return true if a given location on the board, 
     * specified by a given row index and column index, is empty
     * 
     * @param row The row of the board.
     * @param col the column of the board
     * @return Whether or not the location is empty.
     */
    public boolean isEmpty(int row, int col) {
        if (board[row][col] == "-") {
            return true;
        } else {
            return false;
        }
         // TODO: Correct the method
    }

    /**
     * check the game for a win
     * If all the elements a row, column, or diagonal are the same, 
     * then a win has been detected.
     * 
     * If a win is detected, the detectedWin instance variable should be set to true, 
     * and the winningSymbol instance variable should be set to the symbol of the winner.
     *
     * Hint: There are 8 ways to win a 3x3 game of tic-tac-toe
     */
    private void detectWin(){
          // Check rows
          for (int i = 0; i < SIZE; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(EMPTY)) {
                detectedWin = true;
                winningSymbol = board[i][0];
                return;
            }
        }

        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]) && !board[0][j].equals(EMPTY)) {
                detectedWin = true;
                winningSymbol = board[0][j];
                return;
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(EMPTY)) {
            detectedWin = true;
            winningSymbol = board[0][0];
            return;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(EMPTY)) {
            detectedWin = true;
            winningSymbol = board[0][2];
            return;
        }
    } 
    public boolean play(int row, int col, String symbol) {
        // TODO: Implement the method
        if (isEmpty(row, col)) {
            board[row][col] = symbol;
            return true;
        }
        return false;
         // TODO: Correct the method
    }

    /**
     * If the game is over,and has a winner, return true. Otherwise, return false
     * 
     * @return The boolean value of detectedWin.
     */
    public boolean hasWinner() {
        return detectedWin;

        // TODO: Correct the method
    }

    /**
     * This function returns the winning symbol.
     * It is only valid to call this method if hasWinner returns true.
     * 
     * @return The winningSymbol.
     */
    public String getWinningSymbol() {
        if (detectedWin) {
            return winningSymbol;
        } 
        return EMPTY; // TODO: Correct the method
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToeBoard board = new TicTacToeBoard();
        board.printBoard();

        int row, col;
        boolean xTurn = true;
        while (!board.isBoardFull() && !board.hasWinner()) {
            System.out.print("Enter row & col to play: ");
            row = input.nextInt();
            col = input.nextInt();
            board.play(row, col, xTurn ? "X" : "O");
            board.printBoard();
            if (board.isBoardFull())
                System.out.println("Board is full.");
            if (board.hasWinner())
                System.out.println("Has winner: " + board.getWinningSymbol());
            xTurn = !xTurn;
        }
        System.out.println("Goodbye!");
        input.close();
    }
}


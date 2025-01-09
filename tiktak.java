import java.util.*;

public class tiktak

{
    static String[] board; // this is a string array of size 9 that will represent the Tic-Tac-Toe board 
    static String turn; // this is also a string variable that will keep track of whose turn it is to play

    static String checkingw() // this is a method used to determine if there is a winner or if the game is a draw
    {
        for (int a = 0; a < 8; a++) { // it repeats through 8 winning combinations and for each one it constructs a string line
            String line = null; // by connecting the characters at the corresponding positions on the board
 
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            // for x winning
            if (line.equals("♥♥♥")) {
                return "♥";
            }
             
            // for 0 winning
            else if (line.equals("♡♡♡")) {
                return "♡";
            }
        }
         
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw"; // after checking all winning combinations, the code checks for a draw and empty spaces,
            }                  // if so the loop breaks, and the game continues
        }
 
       // this is basically for printing the X or O at the exact place on the board
        System.out.println(
            turn + "'s turn; enter a slot number to place "
            + turn + " in:");
        return null;
    }
    static void printBoard() // now with this we print the board
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                           + board[1] + " | " + board[2]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                           + board[4] + " | " + board[5]
                           + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                           + board[7] + " | " + board[8]
                           + " |");
        System.out.println("|---|---|---|");
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "♥";
        String winner = null;
 
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
 
        System.out.println("hiiii welcome to tikitokie !!! ♡ ♥ \n");
        printBoard();
 
        System.out.println(
            "\nplayer ♥ will go first. enter a slot number to place ♥ in:");
 
        while (winner == null) {
            int numInput;
           
           // here we handle any exceptions.
           // numInput from 1 to 9, if it is not then it will show you an error message.

            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "invalid input :( ; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "invalid input :( ; re-enter slot number:");
                continue;
            }
             
            // here is the logic to decide the turn of the players

            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;
 
                if (turn.equals("♥")) {
                    turn = "♡";
                }
                else {
                    turn = "♥";
                }
 
                printBoard();
                winner = checkingw();
            }
            else {
                System.out.println(
                    " this slot is already taken :( ; re-enter slot number:");
            }
        }
       
        // if no one wins or lose, we print draw

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                " it's a draw! thanks for playing. :) ");
        }
       
        // winner's message

        else {
            System.out.println(
                "Congratulations! " + winner
                + " just won! thanks for playing. ;) ");
        }
      in.close();
    }
}

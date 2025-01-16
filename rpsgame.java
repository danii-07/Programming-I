import java.util.Scanner;
import java.util.Random; // this generate random results

public class rpsgame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // objects
        Random random = new Random(); // objects x2

        System.out.println("hii welcome to the rock, paper, scissors game!!");

        // we get the first player's input 

        System.out.print("hey girrl enter your choice (1 aka Rock, 2 aka Paper, 3 aka Scissors): ");
        int playerChoice = Integer.parseInt(scanner.nextLine()); // reads and convert in an integer and puts it in my variable pC

        // we validate the first player's input

        if (playerChoice < 1 || playerChoice > 3) {
            System.out.println(" super invalid choice bro. please, again, enter 1 (Rock), 2 (Paper), or 3 (Scissors).");
            scanner.close();
            return;
        }

        // creating what the computer will randomly say, generating a number between 1 and 3

        int compuchoiceNum = random.nextInt(3) + 1; 

        // transform text for output, soo the numbers get assign a word and then go to pCT or cC

        String playerChoiceText = "";
        String compuchoiceText = "";
        switch (playerChoice) {
            case 1:
                playerChoiceText = "Rock";
                break;
            case 2:
                playerChoiceText = "Paper";
                break;
            case 3:
                playerChoiceText = "Scissors";
                break;
        }
        switch (compuchoiceNum) { 
            case 1:
                compuchoiceText = "Rock";
                break;
            case 2:
                compuchoiceText = "Paper";
                break;
            case 3:
                compuchoiceText = "Scissors";
                break;
        }

        System.out.println("your choice queen: " + playerChoiceText);
        System.out.println("the fake girlie's choice: " + compuchoiceText);

        // picking the winner 

        String result = "";
        if (playerChoice == compuchoiceNum) {
            result = "it's a tie, better luck next time!";
        } else if (
                (playerChoice == 1 && compuchoiceNum == 3) ||
                (playerChoice == 2 && compuchoiceNum == 1) ||
                (playerChoice == 3 && compuchoiceNum == 2)
        ) {
            result = "you win, slayy!";
        } else {
            result = "a fake being won and you didn't hihi!";
        }

        System.out.println(result);

        scanner.close();
    }
}
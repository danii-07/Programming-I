import java.util.Random;
import java.util.Scanner;

public class numberguess {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1; // this generates a number between 1 and 100
        int attempts = 0;
        int guess;

        System.out.println("hiii welcome to the Number Guessing Game!!!!");
        System.out.println("i've chosen a secret number between 1 and 100.");

        do {
            System.out.print("nowww try to guess which one: ");
            if (scanner.hasNextInt()) { // this checks if the input is an integer
                guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("too low!");
                } else if (guess > secretNumber) {
                    System.out.println("too high!");
                } else {
                    System.out.println("congratulations! you guessed the number in " + attempts + " attempts.");
                }
            } else {
                System.out.println("invalid input. please enter a number.");
                scanner.next(); // takes the invalid input and continues
                guess = -1; // setting the guess to a value that won't match the secret number, so that the game goes on
            }
        } while (guess != secretNumber);

        scanner.close();
    }
}
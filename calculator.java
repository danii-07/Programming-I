import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" hi i am your simple calculator :)");

        while (true) {
            System.out.print("enter the first number (or 'q' to quit): ");
            if (scanner.hasNext("q")) {
                break; // you can exit the loop if you enter 'q'
            } else if (!scanner.hasNextDouble()) {
              System.out.println("invalid input. please enter a number...");
              scanner.next();
              continue; // next to the other loop
            }
            double num1 = scanner.nextDouble();

            System.out.print("enter operator (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("enter a second number: ");
            if (!scanner.hasNextDouble()) {
              System.out.println("invalid input. please enter a number...");
              scanner.next();
              continue;
            }
            double num2 = scanner.nextDouble();

            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("girrl i cannot divide by zero, what do you mean?");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("invalid operator.");
                    continue; // Go to the next loop iteration
            }

            System.out.println("yourr result is: " + result);
        }
        scanner.close();
    }
}
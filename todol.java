import java.util.ArrayList;
import java.util.Scanner;

public class todol {

    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n welcome to yourrr to-do list:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }

            System.out.println("\nOptions:");
            System.out.println("1. add item :)");
            System.out.println("2. remove item :(");
            System.out.println("3. quit");
            System.out.print("pleaseee enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("invalid input. please enter a number.");
                scanner.next();
                continue; 
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // here we pass the newline character

            switch (choice) {
                case 1:
                    System.out.print("enter the item you want to add: ");
                    String item = scanner.nextLine();
                    todoList.add(item);
                    break;
                case 2:
                    System.out.print("enter the number of the item that you want to remove: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("invalid input. please enter the number of the item.");
                        scanner.next();
                        continue;
                      }

                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index > 0 && index <= todoList.size()) {
                        todoList.remove(index - 1); // here we adjust the index for ArrayList
                    } else {
                        System.out.println("invalid number.");
                    }
                    break;
                case 3:
                    System.out.println("byeee...");
                    scanner.close();
                    return; // here the program ends
                default:
                    System.out.println("invalid choice.");
            }
        }
    }
}
package makeup;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static boolean userMenu = true;

    public static void main(String[] args) {
         while (userMenu) {
            System.out.println("\n--- hii, welcome to Amor:) makeup store inventory <3 ---");
            System.out.println("1. add user");
            System.out.println("2. add product");
            System.out.println("3. view products");
            System.out.println("4. search product");
            System.out.println("5. exit");
            System.out.print("please enter the number of your choice: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("please put a valid input. enter a number again.");
                scanner.next();
                continue;
            }
            scanner.nextLine();
            
             switch (choice) {
                case 1: addUser(); break;
                case 2: addProduct(); break;
                case 3: showProducts(); break;
                case 4: searchProducts(); break;
                case 5: userMenu = false; System.out.println("okay. bye! :)"); break;
                default:
            }
        }
        scanner.close();
    }
     // main methods

     private static void addUser(){
       System.out.print("enter you name: ");
       String name = scanner.nextLine();

       users.add(new User(name));
       System.out.print("user created!");
     }

     private static void addProduct(){
        System.out.print("enter the product name: ");
        String name = scanner.nextLine();
                    
        System.out.print("enter category: ");
        String category = scanner.nextLine();
                    
        System.out.print("enter price: ");
        double price = scanner.nextDouble();

        System.out.print("enter quantity: ");
        int quantity = scanner.nextInt();

        products.add(new Product(name, category, price, quantity));
        System.out.println("the product was just added! slayy!");
     }

     private static void showProducts(){
        System.out.println("\n productss list");
        if (products.isEmpty()){ System.out.println("no products sorry"); return;}
        products.forEach(System.out::println);
     }

     private static void searchProducts(){
        System.out.print("enter product name to search: ");
        String searchName = scanner.nextLine();
        Product found = null;
            for (Product p : products) {
                if (p.getName().equalsIgnoreCase(searchName)) {
                    found = p;
                    break;
                }
            }
            if (found != null) {
            System.out.println("product found: " + found);}
            else { System.out.println("couldn't find the product sorry.");}
     }
}

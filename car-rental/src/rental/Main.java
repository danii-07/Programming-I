package rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static List<Car> cars = new ArrayList<>();
    public static List<Rentbook> rentals = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static boolean userMenu = true;

    public static void main(String[] args) {
        while (userMenu){
            System.out.println("\n hiii welcome to our carr system <3");
            System.out.println("1. add User");
            System.out.println("2. add Car");
            System.out.println("3. login");
            System.out.println("4. exit");
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
                case 2: addCar(); break;
                case 3: loginuser(); break;
                case 4: userMenu = false; System.out.println("okay. bye! :)"); break;
                default:
            }
        }
        scanner.close(); // closing the main loop
    }

    // main methods

    private static void addUser() {
        System.out.print("enter you name: ");
        String name = scanner.nextLine();


        System.out.print("what is your budget: ");
        double cash = scanner.nextDouble();


        users.add(new User(name, cash));
        System.out.print("user created!");
        showUsers();
    }

    private static void addCar() {
        System.out.print("enter license plate: ");
        String plate = scanner.nextLine();
        System.out.print("brand: "); String brand = scanner.nextLine();
        System.out.print("model: "); String model = scanner.nextLine();
        System.out.print("enter price/day:");
        double pricepday= scanner.nextDouble();
        cars.add(new Car(plate, brand, model, pricepday));
        System.out.println("the car was added!");
    }

    // menu when already logged in

    private static void loginuser() {
        if (users.isEmpty()) {
            System.out.println("no users girlie pop. kindly add one first.");
            return;
        }

        System.out.println("\n users jiji");
        showUsers();
        System.out.print("write your user name: ");
        String userName = scanner.nextLine();

        User selectedUser = null;
        for (User user : users) {
            if (user.name.equalsIgnoreCase(userName)) { // finding the user
                selectedUser = user;
                break;
            }
        }

        if (selectedUser == null) {
            System.out.println("user not found!");
            return;
        }

        // second menu after login

        boolean loggedInMenu = true;
        while (loggedInMenu) {
            System.out.println("\n welcomeee, " + selectedUser.name + "!"); // Use selectedUser.name
            System.out.println("1. rent a car");
            System.out.println("2. see my bookings"); // View rentals specific to this user
            System.out.println("3. go back to main menu");
            System.out.print("enter your choice: ");

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
                case 1: rentCar(selectedUser); break;
                case 2: showRentalsByUser(selectedUser); break;
                case 3: loggedInMenu = false; System.out.println("logging out from " + selectedUser.name + "."); break;
                default:
            }
            break;
        }
    }

    private static void rentCar(User currentUser) {

        boolean anyCarAvailable = false;
        for (Car c : cars) {
            if (c.available) {
                anyCarAvailable = true;
                break;
            }
        }
        if (!anyCarAvailable) {
            System.out.println("no cars sorry."); return;
        }

        System.out.println("\n one step closer to your rent-car");
        showCars();
        System.out.print("car plate: ");
        String carPlate = scanner.nextLine().toUpperCase();

        // looking for a car

        Car car = null;
        for (Car c : cars) {
            if (c.plate.equalsIgnoreCase(carPlate)) {
                car = c;
                break;
            }
        }

        if (car == null || !car.available) {
            System.out.println("can't find any car or is already rented."); return;
        }

        System.out.print("number of days to rent: ");
        int days;
        days = scanner.nextInt();
        scanner.nextLine();

        double cost = car.pricepday * days;
        if (!currentUser.pay(cost)) {
            System.out.println("heyyy not enough money money! you only have €" + String.format("%.2f", currentUser.cash));
            return;
        }

        car.available = false;
        rentals.add(new Rentbook(currentUser, car, days)); //
        System.out.println("slayyy you just rented a car!");
        System.out.println(rentals.getLast());
        showRentalsByUser(currentUser);
    }

    // here are the displaying methods

    private static void showCars() {
        System.out.println("\n carsss list");
        boolean anyAvailable = false;

        for (Car car : cars) {
            if (car.available) {
                System.out.println(car);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("no cars sorry.");
        }
    }

    private static void showUsers() {
        System.out.println("\n userss list");
        if (users.isEmpty()) { System.out.println("no users sorry."); return; }
        users.forEach(System.out::println);
    }

    private static void showRentalsByUser(User user) {
        System.out.println("\n these are your bookings pookie: ");
        boolean foundBookings = false;
        for (Rentbook r : rentals) {
            if (r.user == user) { // compare by reference since it is the same object jiji
                System.out.println(r);
                System.out.println("---");
                foundBookings = true;
            }
        }
        if (!foundBookings) {
            System.out.println("no bookings for " + user.name + " yet ;) .");
        }
    }
}
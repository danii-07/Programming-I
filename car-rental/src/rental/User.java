package rental;

public class User {
    public String name;
    public double cash;

    public User(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    // payments

    public boolean pay(double amount) {
        if (this.cash >= amount) {
            this.cash -= amount;
            return true; // yes payment
        }
        return false; // not enough money
    }

    @Override
    public String toString() {
        return name;
    }
}
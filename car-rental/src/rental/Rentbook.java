package rental;

public class Rentbook {
    public User user;
    public Car car;
    public int days;
    public double totalCost;

    // adding bookings

    public Rentbook(User user, Car car, int days) {
        this.user = user;
        this.car = car;
        this.days = days;
        this.totalCost = car.pricepday * days;
    }

    @Override
    public String toString() {
        return car + " " + days  + " " + totalCost;
    }
}
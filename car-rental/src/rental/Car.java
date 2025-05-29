package rental;

public class Car {
    public String plate;
    public String brand;
    public String model;
    public boolean available;
    public double pricepday;

    // getting the data and assign it on its place :)

    public Car(String plate, String brand, String model, double pricepday) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.pricepday = pricepday;
        this.available = true;
    }

    @Override
    public String toString() {
        return plate + " " + brand + " " + model + " " + pricepday;
    }
}
public class Car extends Vehicle {
    private int doors;
    private int seats;
    private boolean isLuxury;
    private String fuelType;

    public Car(String brand, String model, int year, double pricePerDay,
               int doors, int seats, boolean isLuxury, String fuelType) {
        super(brand, model, year, pricePerDay);
        this.doors = doors;
        this.seats = seats;
        this.isLuxury = isLuxury;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + " (" + getYear() + ") - " +
               "$" + getPricePerDay() + "/day, " +
               doors + " doors, " + seats + " seats, " +
               (isLuxury ? "Luxury" : "Standard") + ", Fuel: " + fuelType;
    }
}

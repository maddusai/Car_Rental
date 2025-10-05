public class Car extends Vehicle {
    private int seats;

    public Car(String brand, String model, int year, double pricePerDay, int seats) {
        super(brand, model, year, pricePerDay);
        this.seats = seats;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Seats: " + seats;
    }
}

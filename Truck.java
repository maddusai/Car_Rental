public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String brand, String model, int year, double pricePerDay, double loadCapacity) {
        super(brand, model, year, pricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Load: " + loadCapacity + " tons";
    }
}

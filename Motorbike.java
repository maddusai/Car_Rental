public class Motorbike extends Vehicle {
    private int engineCC;

    public Motorbike(String brand, String model, int year, double pricePerDay, int engineCC) {
        super(brand, model, year, pricePerDay);
        this.engineCC = engineCC;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Engine: " + engineCC + "cc";
    }
}

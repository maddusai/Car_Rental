public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double pricePerDay;
    protected boolean available;

    public Vehicle(String brand, String model, int year, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getDetails() {
        return brand + " " + model + " (" + year + ") - $" + pricePerDay + "/day";
    }
}

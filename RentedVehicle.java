public class RentedVehicle {
    private Vehicle vehicle;
    private Customer customer;
    private int days;

    public RentedVehicle(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.vehicle.setAvailable(false);
    }

    public double getTotalPrice() {
        return vehicle.getPricePerDay() * days;
    }

    public String getReceipt() {
        return customer.getName() + " rented " + vehicle.getBrand() + " " + vehicle.getModel() +
               " for " + days + " days. Total: $" + getTotalPrice();
    }

    public Vehicle getVehicle() { return vehicle; }
}

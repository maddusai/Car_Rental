public class RentedVehicle {
    private Vehicle vehicle;
    private Customer customer;
    private int duration;
    private double totalCost;
    private String rentalType;
    private boolean isPaid;
    private PaymentMethod paymentMethod;

    public enum PaymentMethod {
        CREDIT_CARD, DEBIT_CARD, CASH, DIGITAL_WALLET
    }

    public RentedVehicle(Vehicle vehicle, Customer customer, int duration, 
                         double totalCost, String rentalType, PaymentMethod paymentMethod) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.duration = duration;
        this.totalCost = totalCost;
        this.rentalType = rentalType;
        this.paymentMethod = paymentMethod;
        this.isPaid = false;
    }

    public boolean processPayment() {
        System.out.println("Processing Payment...");
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Total Amount: $" + totalCost);
        
        isPaid = true;
        System.out.println("Payment Successful!");
        return true;
    }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public int getDuration() { return duration; }
    public double getTotalCost() { return totalCost; }
    public String getRentalType() { return rentalType; }
    public boolean isPaid() { return isPaid; }
    public String getFormattedDuration() {
        return duration + " " + (rentalType.equals("daily") ? "day(s)" : "hour(s)");
    }
}